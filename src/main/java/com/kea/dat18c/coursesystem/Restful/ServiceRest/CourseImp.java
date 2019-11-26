package com.kea.dat18c.coursesystem.Restful.ServiceRest;

import com.kea.dat18c.coursesystem.Restful.model.Course;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CourseImp implements CourseApi {

    private RestTemplate restTemplate;

    public CourseImp(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Course> getCourse() {

        Course[] courses = restTemplate.getForObject(
                "http://35.159.46.191/course", Course[].class);
        List<Course> sl = Arrays.asList(courses);

        return sl;
    }


}


