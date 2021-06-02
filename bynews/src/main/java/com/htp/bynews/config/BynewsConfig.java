package com.htp.bynews.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@Configuration
@ComponentScans(value = {
		@ComponentScan(basePackages = "com.htp.bynews.service"),
		@ComponentScan(basePackages = "com.htp.bynews.dao") 
		})
public class BynewsConfig {

}