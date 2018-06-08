package com.khidi.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
@EnableSwagger2
@Configuration
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
    	ParameterBuilder tokenPar = new ParameterBuilder();
    	tokenPar.name("token").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(true).defaultValue("admin123456789").build();
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.khidi.manager"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(new ArrayList<Parameter>(){{
                	add(tokenPar.build());
                }});
    }
    //构建 api文档的详细信息函数
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("河长制 API")
                //创建人
                //.contact(new Contact("Ricky", "http://www.bytebeats.com", "ricky_feng@163.com"))
                //版本号
                .version("1.0")
                //描述
                .description("中国电建集团昆明院河长制信息系统项目开发组")
                .build();
    }
}
