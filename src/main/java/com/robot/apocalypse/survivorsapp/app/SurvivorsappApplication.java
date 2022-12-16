package com.robot.apocalypse.survivorsapp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebMvc
@Import(SwaggerConfiguration.class)
@EnableSwagger2
@EnableJpaRepositories("com.robot.apocalypse.survivorsapp")
@EntityScan("com.robot.apocalypse.survivorsapp")
@SpringBootApplication(scanBasePackages = "com.robot.apocalypse.survivorsapp")
public class SurvivorsappApplication {
	public static void main(String[] args) {
		SpringApplication.run(SurvivorsappApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Bean
	public InternalResourceViewResolver defaultViewResolver() {
		return new InternalResourceViewResolver();
	}
}
