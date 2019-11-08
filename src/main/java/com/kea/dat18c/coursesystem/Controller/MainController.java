package com.kea.dat18c.coursesystem.Controller;

import com.kea.dat18c.coursesystem.Service.CourseInformationService;
import com.kea.dat18c.coursesystem.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    CourseInformationService courseInformationService;

    @GetMapping("/")
    public String frontPage(){
        return "index";
    }

    @GetMapping("/studentlogin")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public String studentView(){
        return "student";
    }

    @GetMapping("/teacherlogin")
    @PreAuthorize("hasRole('ROLE_TEACHER')")
    public String teacherView(){
        return "teacher";
    }

    @GetMapping(value = "/login")
    public String getLoginPage(){
        return "login";
    }
    @GetMapping(value = "/logout-success")
    public String getLogoutPage(){
        return "logout";
    }

    @GetMapping("/showTeachers")
    @PreAuthorize("hasRole('ROLE_TEACHER')")
    public String showTeachers(Model model){
        model.addAttribute("teachers", teacherService.getAll());

        return "showTeachers";
    }

    @GetMapping("/showCourse")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public String showCourse(Model model){
        model.addAttribute("courseInformations", courseInformationService.getAll());
        return "showCourseInformation";
    }

}
