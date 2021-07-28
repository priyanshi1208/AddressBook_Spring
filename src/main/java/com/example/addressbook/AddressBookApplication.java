package com.example.addressbook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
@Slf4j
@SpringBootApplication
public class AddressBookApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context=SpringApplication.run(AddressBookApplication.class, args);
        log.info("AddressBook App Started in {} Environment",context.getEnvironment().getProperty("environment"));
        log.info("AddressBook DB user is {} ",context.getEnvironment().getProperty("spring.datasource.username"));
    }
}
