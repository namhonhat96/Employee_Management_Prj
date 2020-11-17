package com.beaconfire.work_mgt_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WorkMgtProjectApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WorkMgtProjectApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(WorkMgtProjectApplication.class, args);
    }

}
