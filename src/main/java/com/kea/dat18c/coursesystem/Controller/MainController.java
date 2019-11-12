package com.kea.dat18c.coursesystem.Controller;


import com.kea.dat18c.coursesystem.Service.CourseInformationService;

import com.kea.dat18c.coursesystem.Model.Teacher;

import com.kea.dat18c.coursesystem.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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


    @GetMapping("updateTeachers/{email}")
    @PreAuthorize("hasRole('ROLE_TEACHER')")
    public String updateTeachers(@PathVariable("email") String email, Model model){
        model.addAttribute("teachers", teacherService.findById(email));
        return "updateTeachers";
    }
    @PostMapping("/updateTeachers")
//    @PreAuthorize("hasRole('ROLE_TEACHER')")
    public String updateTeacher(@ModelAttribute Teacher teacher){
        teacherService.update(teacher);
        return "redirect:/showTeachers";
    }

    @GetMapping("/createTeacher")
    @PreAuthorize("hasRole('ROLE_TEACHER')")
    public String  createTeachers(){
        return "showTeachers";
    }

    @PostMapping("createTeacher")
    public String createTeachers(@ModelAttribute Teacher teacher)
    {
        teacherService.create(teacher);
        return "redirect:/showTeachers";
    }

}
