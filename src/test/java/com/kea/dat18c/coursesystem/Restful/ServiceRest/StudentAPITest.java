package com.kea.dat18c.coursesystem.Restful.ServiceRest;

import com.kea.dat18c.coursesystem.Restful.model.StudentRest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class StudentAPITest {

    @Autowired
    APIStudentService apiStudentService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getStudent() {

        List<StudentRest> student = apiStudentService.getStudent();
        assertEquals(25, student.size());
    }
}