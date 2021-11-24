package com.team.clouddoctor.configuration;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile("!live")
public class SwaggerApiConfig {

	@Bean
	public Docket api() {

		Parameter contentType = new ParameterBuilder().name("Content-Type").defaultValue("application/json").modelRef(new ModelRef("string"))
				.parameterType("header").required(true).build();
		Parameter authorization = new ParameterBuilder().name("Authorization").defaultValue("Bearer").modelRef(new ModelRef("string"))
				.parameterType("header").required(true).build();

		List<Parameter> myList = new ArrayList<>();
		myList.add(contentType);
		myList.add(authorization);

		return new Docket(DocumentationType.SWAGGER_2).globalOperationParameters(myList).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class)).paths(PathSelectors.any()).build();
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
