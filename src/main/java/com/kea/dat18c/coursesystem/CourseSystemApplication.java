package com.kea.dat18c.coursesystem;

import com.kea.dat18c.coursesystem.Rest.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

@SpringBootApplication
public class CourseSystemApplication {

    private static final Logger log = LoggerFactory.getLogger(CourseSystemApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CourseSystemApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Teacher[] teacher = restTemplate.getForObject(
                    "http://35.159.46.191/teacher", Teacher[].class);
//            log.info(teacher.toString());
            List<Teacher> searchList = Arrays.asList(teacher);

            System.out.println(searchList);
        };
    }


}
