package com.example.demo.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ConfigurationProperties("storage")

@Configuration
//@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"com.example.demo"})
public class StorageProperties {

	/**
	 * Folder location for storing files
	 */
	private String location = "C:\\Users\\Cuong\\OneDrive\\Desktop\\New folder\\test";

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
