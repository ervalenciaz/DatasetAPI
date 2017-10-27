package com.datasetapi;

import java.util.Optional;
import java.util.Properties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Start {

    public static void main(String[] args) {
        Properties properties = new Properties();
        
        Optional<String> host = Optional.ofNullable(System.getenv("HOSTNAME"));
        Optional<String> port = Optional.ofNullable(System.getenv("PORT"));
        
        properties.setProperty("server.address", host.orElse("localhost"));
        properties.setProperty("server.port", port.orElse("8080"));

        SpringApplication app = new SpringApplication(Start.class);
        app.setDefaultProperties(properties);
        app.run(args);

    }    
}
