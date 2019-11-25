package com.kea.dat18c.coursesystem.Restful.ServiceRest;

import com.kea.dat18c.coursesystem.Restful.model.TeacherRest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ApiServiceImp implements ApiService {

    private RestTemplate restTemplate;

    public ApiServiceImp(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<TeacherRest> getTeacher() {

        TeacherRest[] teacher = restTemplate.getForObject(
                "http://35.159.46.191/teacher/", TeacherRest[].class);
        List<TeacherRest> searchList = Arrays.asList(teacher);

        return searchList;
    }

}
