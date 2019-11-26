package com.kea.dat18c.coursesystem.Restful.ServiceRest;

import com.kea.dat18c.coursesystem.Restful.model.StudentRest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentAPI implements APIStudentService {

    private RestTemplate restTemplate;

    public StudentAPI(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public List<StudentRest> getStudent() {

        StudentRest[] student = restTemplate.getForObject(
                "http://35.159.46.191/student", StudentRest[].class);
        List<StudentRest> sl = Arrays.asList(student);

        return sl;
    }

}
