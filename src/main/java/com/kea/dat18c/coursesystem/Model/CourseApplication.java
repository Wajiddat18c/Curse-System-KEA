package com.kea.dat18c.coursesystem.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course_application")
public class CourseApplication
{
    @Id
    @Column(name = "Application_id")
    private int id;
    private String course;
    @Column(name = "First_name")
    private String firstName;
    @Column(name = "Last_name")
    private String lastName;
    @Column(name = "birth")
    private String birthDay;
    @Column(name = "Current_class")
    private String currentClass;
    @Column(name = "Email")
    private String email;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Course_information_id_Course")
    private String courseInformation;
    private int courseId;

    public CourseApplication(){}

    public CourseApplication(int id, String course, String firstName, String lastName, String birthDay, String currentClass, String email, String phone, String courseInformation, int courseId) {
        this.id = id;
        this.course = course;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.currentClass = currentClass;
        this.email = email;
        this.phone = phone;
        this.courseInformation = courseInformation;
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getCurrentClass() {
        return currentClass;
    }

    public void setCurrentClass(String currentClass) {
        this.currentClass = currentClass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCourseInformation() {
        return courseInformation;
    }

    public void setCourseInformation(String courseInformation) {
        this.courseInformation = courseInformation;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
