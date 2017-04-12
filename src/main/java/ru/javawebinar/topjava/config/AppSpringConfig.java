package ru.javawebinar.topjava.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = {"ru.javawebinar.topjava.repository.jdbc", "ru.javawebinar.topjava.service", "ru.javawebinar.topjava.web"})
@ImportResource("spring/spring-db.xml")
public class AppSpringConfig {

}
