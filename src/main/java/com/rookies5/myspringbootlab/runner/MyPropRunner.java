package com.rookies5.myspringbootlab.runner;

import com.rookies5.myspringbootlab.property.MyPropProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class MyPropRunner implements ApplicationRunner {
    @Value("springboot")
    private String username;

    @Value("${random.int(1,100)}")
    private int port;


    @Autowired
    private MyPropProperties properties;

    //Logger
    private Logger logger = LoggerFactory.getLogger(MyPropRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Logger 구현체 클래스명 = " + logger.getClass().getName());
        logger.debug("MyBootProperties getName() = " + properties.getUsername());

        logger.info("Name: "+ properties.getUsername());
        logger.info("Property Age : " + properties.getPort());

    }
}
