package com.example.demo.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {
    private String location = "C:\\Users\\Cuong\\OneDrive\\Desktop\\New folder\\test";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
