package com.young.eman;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationHome;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication( exclude = {DataSourceAutoConfiguration.class,DataSourceTransactionManagerAutoConfiguration.class })
@EnableScheduling
@ConfigurationProperties
public class EmanApplication extends SpringBootServletInitializer{
	
	private static final Log logger = LogFactory.getLog(EmanApplication.class);
	 
	@Autowired
	private Environment env;
	 
	public static void main(String[] args) {
		
		SpringApplication.run(EmanApplication.class, args);
		ApplicationHome home = new ApplicationHome(EmanApplication.class);
	    logger.info("-----Eman Application Start on home {"+ home.getDir().getAbsolutePath()+"} -----");
	  
	}
}
