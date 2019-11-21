package com.kea.dat18c.coursesystem.Controller;


import com.kea.dat18c.coursesystem.Model.CourseApplication;
import com.kea.dat18c.coursesystem.Model.CourseInformation;
import com.kea.dat18c.coursesystem.Service.CourseApplicationService;
import com.kea.dat18c.coursesystem.Service.CourseInformationService;

import com.kea.dat18c.coursesystem.Model.Teacher;

import com.kea.dat18c.coursesystem.Service.TeacherService;
import com.kea.dat18c.coursesystem.auth.User.AuthGroup;
import com.kea.dat18c.coursesystem.auth.User.User;
import com.kea.dat18c.coursesystem.auth.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.Id;

@Controller
public class MainController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    CourseInformationService courseInformationService;
    @Autowired
    UserService userService;
    @Autowired
    CourseApplicationService courseApplicationService;


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

    @GetMapping("/adminlogin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminView() { return "admin"; }

    @GetMapping(value = "/login")
    public String getLoginPage(){
        return "login";
    }
    @GetMapping(value = "/logout-success")
    public String getLogoutPage(){
        return "logout";
    }

    @GetMapping("/showUsers")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showUsers(Model model){
        model.addAttribute("users", userService.getAll());
        return "showUsers";
    }
    @GetMapping("/showAllApplications")
    @PreAuthorize("hasRole('ROLE_TEACHER')")
    public String showApplications(Model model){
        model.addAttribute("apply", courseApplicationService.getAll());
        return "showAllApplications";
    }

    @GetMapping("/showRoles")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showRoles(Model model){
        model.addAttribute("roles", userService.getUserGroup());
        return "showRoles";
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

    @GetMapping("/teacherShowCourse")
    @PreAuthorize("hasRole('ROLE_TEACHER')")
    public String teacherShowCourse(Model model){
        model.addAttribute("courseInformations", courseInformationService.getAll());
        return "teacherShowCourse";
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
    @GetMapping("/updateApplication/{id}")
    @PreAuthorize("hasRole('ROLE_TEACHER')")
    public String updateApplications(@PathVariable("id") int id, Model model){
        model.addAttribute("apply", courseApplicationService.findbyId(id));
        return "updateApplication";
    }
    @PostMapping("updateApplication")
    public String updateApp(@ModelAttribute CourseApplication courseApplication){
        courseApplicationService.update(courseApplication);
        return "redirect:/showAllApplications";
    }

    @GetMapping("/updateUser/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.findById(id));
        return "updateUser";
    }

    @PostMapping("/updateUser")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateUser(@ModelAttribute User user){
        userService.update(user);
        return "redirect:/showUsers";
    }

    @GetMapping("/updateRole/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateRole(@PathVariable("id") int id, Model model){
        model.addAttribute("role", userService.getRole(id));
        return "updateRole";
    }

    @PostMapping("/updateRole")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateRole(@ModelAttribute AuthGroup authGroup){
        userService.saveRole(authGroup);
        return "redirect:/showRoles";
    }

    @GetMapping("/updateCourse/{id}")
    @PreAuthorize("hasRole('ROLE_TEACHER')")
    public String updateCourse(@PathVariable("id") int id, Model model){
        model.addAttribute("courseInformations",courseInformationService.findById(id));
        return "updateCourse";
    }

    @PostMapping("/updateCourse")
    public String updateCourse(@ModelAttribute CourseInformation courseInformation){
        courseInformationService.update(courseInformation);
        return "redirect:/teacherShowCourse";
    }

    @GetMapping("/createTeacher")
    @PreAuthorize("hasRole('ROLE_TEACHER')")
    public String  createTeachers(){
        return "createTeacher";
    }

    @PostMapping("createTeacher")
    public String createTeachers(@ModelAttribute Teacher teacher)
    {
        teacherService.create(teacher);
        return "redirect:/showTeachers";
    }

    @GetMapping("/createUser")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createUsers(){
        return "createUser";
    }

    @PostMapping("createUser")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createUsers(@ModelAttribute User user){
        userService.create(user);
        return "redirect:/showUsers";
    }

    @GetMapping("/createRole")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createRole(Model model){
        model.addAttribute("users", userService.getAll());
        return "createRole";
    }

    @PostMapping("createRole")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createRole(@ModelAttribute AuthGroup authGroup){
        userService.saveRole(authGroup);
        return "redirect:/showRoles";
    }


    @GetMapping("/createCourse")
    @PreAuthorize("hasRole('ROLE_TEACHER')")
    public String createCourse(){
        return "createCourse";
    }

    @PostMapping("createCourse")
    public String createCourse(@ModelAttribute CourseInformation courseInformation) {
        courseInformationService.create(courseInformation);
        return "redirect:/teacherShowCourse";
    }
    @GetMapping("/createApplication")
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public String createApplication(Model model){
        model.addAttribute("courseList", courseInformationService.getAll());
        return "createApplication";
    }
    @PostMapping("createApplication")
    public String createApplications(@ModelAttribute CourseApplication courseApplication){
        courseApplicationService.create(courseApplication);
        return "redirect:/showCourse";
    }


    @GetMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable("id") String eMail)
    {
        teacherService.delete(eMail);
        return "redirect:/showTeachers";
    }

    @GetMapping("/deletec/{id}")
    public String deleteCourse(@PathVariable("id") int id ){
        courseInformationService.delete(id);
        return "redirect:/teacherShowCourse";
    }
    @GetMapping("/deleteUser/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteUser(@PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/showUsers";
    }
    @GetMapping("/deleteApplication/{id}")
    @PreAuthorize("hasRole('ROLE_TEACHER')")
    public String deleteApp(@PathVariable("id") int id){
        courseApplicationService.delete(id);
        return "redirect:/showAllApplications";
    }



    @GetMapping("/deleteRole/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteRole(@PathVariable("id") int id){
        userService.deleteRole(id);
        return "redirect:/showRoles";
    }

}
