package org.andot.share.oauth.server.configura;

import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.*;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * redis 配置
 * @author Andot
 */
@Slf4j
@Configuration
@EnableCaching
public class RedisConfigure extends CachingConfigurerSupport {

    /**
     * // 注入 Lettuce 连接工厂
     */
    @Resource
    private LettuceConnectionFactory connectionFactory;

    /**
     * 缓存生存时间
     */
    private final Duration duration = Duration.ofDays(1);

    /***
     * 设置redis为默认缓存工具
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){
        //Redis 缓存配置
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration
                .defaultCacheConfig()
                .entryTtl(this.duration)
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(stringSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jsonSerializer()))
                .disableCachingNullValues();
        // 缓存配置
        Map<String, RedisCacheConfiguration> cacheConfigurationMap = new HashMap<>(50);
        //自定义缓存配置名称
        cacheConfigurationMap.put("users", redisCacheConfiguration);
        cacheConfigurationMap.put("default", redisCacheConfiguration);
        //根据redis缓存配置和reid连接工厂生成redis缓存管理器
        RedisCacheManager redisCacheManager = RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(redisCacheConfiguration)
                .transactionAware()
                .withInitialCacheConfigurations(cacheConfigurationMap)
                .build();
        log.debug("自定义RedisCacheManager加载完成");
        return redisCacheManager;
    }

    /**
     * redisTemplate 模板提供给其他类对redis操作
     */
    @Bean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(){
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        // 配置连接工厂
        redisTemplate.setConnectionFactory(connectionFactory);


        ObjectMapper om = new ObjectMapper();
        om.setVisibility(JsonMethod.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        // 使用字符串方式序列化
        redisTemplate.setKeySerializer(stringSerializer());
        redisTemplate.setHashKeySerializer(stringSerializer());
        // 使用json方式序列化
        redisTemplate.setValueSerializer(jsonSerializer());
        redisTemplate.setHashValueSerializer(jsonSerializer());

        redisTemplate.afterPropertiesSet();
        log.debug("自定义RedisTemplate加载完成");
        return redisTemplate;
    }

    /**
     * redis序列化key使用的StringRedisSerializer
     * @return
     */
    private RedisSerializer<String> stringSerializer(){
        return new StringRedisSerializer();
    }
    /**
     * 使用Jackson2JsonRedisSerializer 来序列化和反序列化redis的value（默认采用JDK序列化方式）
     * @return
     */
    private RedisSerializer<Object> jsonSerializer(){
        return new Jackson2JsonRedisSerializer<>(Object.class);
    }

    /**
     * 对hash类型的操作
     * @param redisTemplate
     * @return
     */
    @Bean
    public HashOperations<String, String, Object> hashOperations(RedisTemplate<String, Object> redisTemplate){
        return redisTemplate.opsForHash();
    }

    /***
     * 对value类型的操作
     * @param redisTemplate
     * @return
     */
    @Bean
    public ValueOperations<String, Object> valueOperations(RedisTemplate<String, Object> redisTemplate){
        return redisTemplate.opsForValue();
    }

    /**
     * 对list类型的操作
     * @param redisTemplate
     * @return
     */
    @Bean
    public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate){
        return redisTemplate.opsForList();
    }

    /**
     * 对set类型操作
     * @param redisTemplate
     * @return
     */
    @Bean
    public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate){
        return redisTemplate.opsForSet();
    }

    /***
     * 对有序集合的操作
     * @return
     */
    @Bean
    public ZSetOperations<String, Object> zsetOperations(){
        return redisTemplate().opsForZSet();
    }
}
