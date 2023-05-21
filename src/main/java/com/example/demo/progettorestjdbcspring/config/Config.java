package com.example.demo.progettorestjdbcspring.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example.demo.progettorestjdbcspring.controller")
@ImportResource("configuration.xml")
public class Config {

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver= new InternalResourceViewResolver();
        //il metodo 'setPrefix("...")' indica al resolver dove sono le view
        resolver.setPrefix("/WEB-INF/view/");
        //il metodo 'setSuffix("...")' indica il formato dei file da prendere nella folder delle view
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
