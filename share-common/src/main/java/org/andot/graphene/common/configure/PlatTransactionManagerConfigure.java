package org.andot.graphene.common.configure;

import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.TransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/***
 * 平台数据库事务管理接口，所有事务统一继承此类做实现
 * @author andot
 * @date 2019-1-19 11:34:18
 * @since 1.0
 */
public interface PlatTransactionManagerConfigure {

    /***
     * 事务拦截类型设置
     * @return
     */
    TransactionAttributeSource transactionAttributeSource();

    /***
     * 切面拦截规则配置
     * @param txInterceptor
     * @return
     */
    AspectJExpressionPointcutAdvisor pointcutAdvisor(TransactionInterceptor txInterceptor);


    /***
     * 事务拦截器
     * @param tx
     * @return
     */
    TransactionInterceptor getTransactionInterceptor(PlatformTransactionManager tx);
}
