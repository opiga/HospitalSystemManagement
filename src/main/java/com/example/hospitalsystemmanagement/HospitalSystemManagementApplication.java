package com.example.hospitalsystemmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Created by bonda on 08.05.2023 12:45
 *
 * @author bonda
 */
@SpringBootApplication
public class HospitalSystemManagementApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(HospitalSystemManagementApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(HospitalSystemManagementApplication.class);
    }
}
