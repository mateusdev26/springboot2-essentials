package br.com.mateus.springboot2_essentials;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class SpringBoot2EssentialsApplication {

    public static void main(String[] args) {
        log.info("The Spring boot application is starting");
		SpringApplication.run(SpringBoot2EssentialsApplication.class, args);
		log.info("The Spring boot application start");
	}

}
