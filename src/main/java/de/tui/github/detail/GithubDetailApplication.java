/*
 * Copyright (c)
 * @author Venkata Ila
 */
package de.tui.github.detail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class GithubDetailApplication extends SpringBootServletInitializer {

	public static void main(final String[] args) {
		SpringApplication.run(GithubDetailApplication.class, args);
	}

	@Bean
	public RestTemplate geRestTemplate()
	{
		return new RestTemplate();
	}
	
}
