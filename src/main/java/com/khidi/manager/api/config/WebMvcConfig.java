package com.khidi.manager.api.config;

import com.khidi.manager.api.interceptor.AuthorizationInterceptor;
import com.khidi.manager.api.resolver.LoginUserHandlerMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.List;

/**
 * MVC配置
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-04-20 22:30
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    //    @Autowired
//    private AuthorizationInterceptor authorizationInterceptor;
//    @Autowired
//    private LoginUserHandlerMethodArgumentResolver loginUserHandlerMethodArgumentResolver;
    @Value("${file.location}")
    private String filePath;
    @Value("${template.location}")
    private String templatePath;
    //新闻管理文件上传
    @Value("${app.news.location}")
    private String appNewsPath;
    //新闻版本文件上传
    @Value("${app.install.location}")
    private String appInstallPath;
    //水功能区文件上传
    @Value("${file.waterability}")
    private String waterabilityPath;
    //水功能区文件上传
    @Value("${file.station}")
    private String stationPath;
    //默认
    @Value("${file.upload.location}")
    private String defPath;
    @Value("${file.intake}")
    private  String intakePath;
    @Value("${file.publicitycard}")
    private String publicitycardPath;
    @Value("${file.meetingm}")
    private String meetingmPath;
    @Value("${file.maintask}")
    private String maintaskPath;
    @Value("${file.appeven}")
    private String appevenPath;

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/api/**");
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        registry.addResourceHandler("/uploadfiles/**")
                .addResourceLocations("file:///" + filePath +"\\");

        registry.addResourceHandler("/publicitycard/**")
                .addResourceLocations("file:///" + publicitycardPath +"\\");

        registry.addResourceHandler("/appeven/**")
                .addResourceLocations("file:///" + appevenPath +"\\");

        registry.addResourceHandler("/station/**")
                .addResourceLocations("file:///" + stationPath +"\\");

        registry.addResourceHandler("/template/**")
                .addResourceLocations("file:///" + templatePath +"\\");

        registry.addResourceHandler("/newsapp/**")
                .addResourceLocations("file:///" + appNewsPath +"\\");

        registry.addResourceHandler("/install/**")
                .addResourceLocations("file:///" + appInstallPath +"\\");

        registry.addResourceHandler("/maintask/**")
                .addResourceLocations("file:///" + maintaskPath +"\\");

        registry.addResourceHandler("/waterability/**")
                .addResourceLocations("file:///" + waterabilityPath +"\\");

        registry.addResourceHandler("/def/**")
                .addResourceLocations("file:///" + defPath +"\\");

        registry.addResourceHandler("/meetingm/**")
                .addResourceLocations("file:///" + meetingmPath +"\\");


        registry.addResourceHandler("/intake/**")
                .addResourceLocations("file:///" + intakePath +"\\");

//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        argumentResolvers.add(loginUserHandlerMethodArgumentResolver);
//    }
    }

    //解决中文乱码问题
    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(
                Charset.forName("UTF-8"));
        return converter;
    }

    @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());
    }

    @Override
    public void configureContentNegotiation(
            ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }
}