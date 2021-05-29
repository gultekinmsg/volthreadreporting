package com.volthread.volthreadreporting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class VolthreadreportingApplication {

    public static void main(String[] args) {
        SpringApplication.run(VolthreadreportingApplication.class, args);
    }

}


/*
*  TODO
*   Save change delete and show methods for forms. -> ok
*   Get statistics from forms -> ok
*   Unit Test(Both Service and Controller Layer)
*   Additional
*   Dockerize
*   Swagger -> ok
*
*
*
*
*
*
*
*
*
* */
