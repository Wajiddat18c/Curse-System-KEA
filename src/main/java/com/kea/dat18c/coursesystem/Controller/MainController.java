package com.kea.dat18c.coursesystem.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

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
}
