package com.shawn.learningalways;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 系统名称: learningAlways
 * 模块名称: Swagger2的配置类
 * 类 名 称: Swagger2
 * 软件版权: Jones
 * 功能说明：通过访问：http://{ip}:{port}/swagger-ui.html就可以看到RESTful API的页面
 * 系统版本：v1.0.1
 * 开发人员: Jones
 * 开发时间: 2018/7/1 9:51
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
// 通过@Configuration注解，让Spring来加载该类配置
@Configuration
// 通过@EnableSwagger2注解来启用Swagger2
@EnableSwagger2
public class Swagger2 {

    /**
     * 创建Docket的Bean
     * @return
     */
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 控制哪些接口暴露给Swagger来展现，本例采用指定扫描的包路径来定义，Swagger会扫描该包下所有Controller定义的API，并产生文档内容（除了被@ApiIgnore指定的请求）
                .apis(RequestHandlerSelectors.basePackage("com.jones.learningalways.example"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建该Api的基本信息（这些基本信息会展现在文档页面中）
     * @return
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                // api文档标题
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                // api文档描述
                .description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
                // 相关链接
                .termsOfServiceUrl("http://blog.didispace.com/")
                // api文档创建人
                .contact("Jones")
                // api版本
                .version("1.0.1")
                .build();
    }
}
