package com.mk;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Swagger2
 * @Description swagger自定义配置
 * @Date 2019-03-14 23:01
 * @Created by fengjingxing
 */
@SpringBootApplication        //same as @Configuration+@EnableAutoConfiguration+@ComponentScan
@EnableSwagger2             //启动swagger注解
@ConditionalOnProperty(name = "swagger.enable", havingValue = "true")
public class Swagger2 {

    private final static String ACCESS_TOKEN_KEY="access_token";
    public static void main(String[] args) {
                 SpringApplication.run(Swagger2.class, args);
    }
    @Bean
    public Docket webAPI(){
        String ACCESS_TOKEN_Value="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidW5pdHktcmVzb3VyY2UiXSwidXNlclJlZ2lvbkNvZGVOb3ciOiIiLCJ1c2VyQWNjb3VudCI6Iue7j-WKniIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJzeXN0ZW1UeXBlIjoiMyIsInVzZXJUeXBlTm93IjoiMiIsInVzZXJOYW1lIjoi57uP5YqeIiwiZXhwIjoxNTU1NjY1MDAxLCJ1c2VySWQiOiJmZjgwODA4MTZhMjk0NDIwMDE2YTJiMTIzZjc0MDAwYiIsImp0aSI6ImIxMTJiNjg5LWIwOTEtNGE5Yi05OTc4LWZmMzY1MmJhMzkyZSIsImNsaWVudF9pZCI6ImdwLWdhdGV3YXktY2VudGVyIn0.QTWRiNbh9enLOXFoI62ujjd3WrS30KHNZmblRlFN6ShL5_zG_muWmzqong1lJ7j11I4r0ZTvqRya6w-88hUvpvOOzSL4aN_1w9iZX3IRxEju2qqkqBEVV4DnkcvEyqk2Kp0ua0qy9o3VYJBXC2Iqnb4hStKCX7XfWY0djif9f2gusN8kDDg4iE5IUs0AndTBt1zqX4lzTLrK45jaWGnFktpj_-e0jN0XRqpHV1TvVDRo0uTwEnGMp0vNFvLFpOJMvBOuGC1U4BsS9db_g0RJ_t94aI1X-m3TJ99GDU0VJh237JZf1jjkMebtKAC-zm9vtzoHGCqF3TC7eucOp1sk6g";
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name(ACCESS_TOKEN_KEY).defaultValue(ACCESS_TOKEN_Value)
                .description("令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true).
                build();
        pars.add(tokenPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("SWMS API interface document")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mk"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars)
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Building RESTful APIs with Swagger 2 in GPMS")
                .termsOfServiceUrl("http://localhost/")
                .contact(new Contact("博思软件","", ""))
                .version("1.0")
                .description("Deployment information")
                .build();
    }
}
