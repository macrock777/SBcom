package com.mudra.mboss.master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@PropertySources({ @PropertySource("classpath:sqlquery.properties"),
	@PropertySource("classpath:supplier.properties"),
	@PropertySource("classpath:itemmastersqlquery.properties"),
	@PropertySource("classpath:campaignquery.properties"),
	@PropertySource("classpath:filepaths.properties"),
	@PropertySource("classpath:publicationEditionSqlQuery.properties")})
public class AppConfig {
	@Autowired
	Environment env;
}