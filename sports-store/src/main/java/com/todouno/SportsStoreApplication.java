package com.todouno;

import com.todouno.util.LoggingInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class SportsStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsStoreApplication.class, args);
	}


	public void addInterceptors(InterceptorRegistry registry)
	{
		registry.addInterceptor(new LoggingInterceptor()).addPathPatterns("/**");
	}


	@Bean
	public Docket docket()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(getClass().getPackage().getName()))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(generateApiInfo());
	}

	private ApiInfo generateApiInfo()
	{
		return new ApiInfo("Prueba tecnica Fabricio Jacome TODOUNO", "Backend para prueba.", "Version 1.0 - mw",
				"urn:tos", "rnfbr1@hotmail.com", "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	}
}
