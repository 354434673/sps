package com.sps.system;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ComponentScan(basePackages ={"com.sps"})
public class SwaggerConfig {

	@Bean  
	public Docket createRestApi() {  
		return new Docket(DocumentationType.SWAGGER_2)  
				.apiInfo(apiInfo())  
				.select()  
				.apis(RequestHandlerSelectors.basePackage("com.sps"))
				.paths(PathSelectors.any())  
				.build();  
	}


	private ApiInfo apiInfo() {
		/*
		 * ApiInfo apiInfo = new ApiInfo( "My Project's REST API",
		 * "This is a description of your API.", "version:1.0", "API TOS",
		 * "me@wherever.com", "API License", "API License URL" );
		 */
		return new ApiInfoBuilder()
				.title("Swagger")
				.description("api")
				.termsOfServiceUrl("http://localhost:8080/sps-api/swagger-ui.html")
				.version("1.0")
				.build();
	}
}
