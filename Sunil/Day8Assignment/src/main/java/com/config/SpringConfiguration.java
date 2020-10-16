package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan({"com.controller","com.repository", "com.service", "com.model"})
@ComponentScan("com.*")
public class SpringConfiguration {

}
