package org.andot.account.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/***
 * swagger api doc configure
 */

@Configuration
@Profile("dev")
public class ApiSwagger2Config {
    @Bean
    public Docket apiRbac(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.andot.account"))
                .paths(PathSelectors.any())
                .build()
                //.globalOperationParameters(setHeaderToken())
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                .apiInfo(this.apiInfoRbac());
    }

    private ApiInfo apiInfoRbac(){
        return new ApiInfoBuilder()
                .title("角色权限控制服务API文档")
                .description("控制石墨烯整个平台的角色权限")
                .termsOfServiceUrl("https://andot.org")
                .contact(new Contact("andot", "https://andot.org", "yanfront@qq.com"))
                .version("1.0.0")
                .build();
    }

    /***
     * 设置全局token
     * @return 参数集合
     */
    private List<Parameter> setHeaderToken() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("X-Auth-Token").description("token").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return pars;
    }

    private List<ApiKey> securitySchemes() {
        return newArrayList(
                new ApiKey("Authorization", "X-Auth-Token", "header"));
    }

    private List<SecurityContext> securityContexts() {
        return newArrayList(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
                        .build()
        );
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return newArrayList(
                new SecurityReference("Authorization", authorizationScopes));
    }
}
