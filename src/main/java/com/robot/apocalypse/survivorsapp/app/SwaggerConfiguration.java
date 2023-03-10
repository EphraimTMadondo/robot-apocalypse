package com.robot.apocalypse.survivorsapp.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.Collections;


@Configuration
@EnableSwagger2WebMvc
@Import(SpringDataRestConfiguration.class)
 class SwaggerConfiguration {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.robot.apocalypse.survivorsapp"))
                .paths(PathSelectors.any()).build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Robot Apocalypse Survivors App",
                "Apocalypse Survivors App enables the access to information about whereabout and status of Robots and Survivors",
                "1.0",
                "Terms of service",
                new Contact("Apocalypse Survivors App Team", "https://www.robotapocalypse.com/", "madondoephram@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());    }

}
