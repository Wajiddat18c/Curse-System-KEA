package com.kea.dat18c.coursesystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String frontPage(){
        return "index";
    }
}
