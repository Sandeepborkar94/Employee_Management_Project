package com.infy;

import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConfigurationClass
{
	@Bean
	public InMemoryHttpExchangeRepository createTraceRepository() 
	{
	  return new InMemoryHttpExchangeRepository();
	}

}
