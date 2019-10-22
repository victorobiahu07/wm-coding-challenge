package com.workmarket.coding.challenge.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


@Configuration
@EnableZuulProxy
@PropertySource("classpath:application.properties")

public class ApiKeyConfiguration {

	@Value("${apiKey}")
	private String apiKey;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertyConfig() {
		return new PropertySourcesPlaceholderConfigurer();
	}	
	
}

