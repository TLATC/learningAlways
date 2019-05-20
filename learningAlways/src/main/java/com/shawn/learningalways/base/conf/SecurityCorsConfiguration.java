package com.shawn.learningalways.base.conf;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @ClassName: SecurityCorsConfiguration
 * @Description 配置跨域请求
 * @author: Shawn Wu
 * @date: 2019/5/20 10:53
 * @version:
 */
@Configuration
public class SecurityCorsConfiguration {

    @Bean
    public FilterRegistrationBean corsFilter() {  
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
        CorsConfiguration config = new CorsConfiguration(); 
        config.setAllowCredentials(true);
        // 允许任何域名使用
        config.addAllowedOrigin("*");
        // 设置访问源请求头
        config.addAllowedHeader(CorsConfiguration.ALL);
        // 设置访问源请求方法
        config.addAllowedMethod(CorsConfiguration.ALL);  
        source.registerCorsConfiguration("/**", config);  
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));  
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);  
        return bean;  
    } 
}
