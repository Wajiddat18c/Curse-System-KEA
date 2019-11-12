package com.kea.dat18c.coursesystem.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course_information")
public class CourseInformation {
    @Id
    @Column(name = "Id_Course")
    private int id;
    private String course;
    @Column(name = "semester")
    private int semester;
    private int ects;
    private String course_language;
    @Column(name = "min_of_students")
    private int min_num_of_student;

    @Column(name = "max_of_students")
    private int max_num_of_student;
    @Column(name="prerequisites")
    private String prerequisites;
    private String learning_outcome;
    private String content;
    private String learning_activities;
    private String exam_form;
    @Column(name="teacher_Email")
    private String teacher_email;

    public CourseInformation() {
    }

    public CourseInformation(int id, String course, int semester, int ects, String course_language, int min_num_of_student, int max_num_of_student, String prerequisites, String learning_outcome, String content, String learning_activities, String exam_form, String teacher_Email) {
        this.id = id;
        this.course = course;
        this.semester = semester;
        this.ects = ects;
        this.course_language = course_language;
        this.min_num_of_student = min_num_of_student;
        this.max_num_of_student = max_num_of_student;
        this.prerequisites = prerequisites;
        this.learning_outcome = learning_outcome;
        this.content = content;
        this.learning_activities = learning_activities;
        this.exam_form = exam_form;
        this.teacher_email = teacher_Email;
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

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public String getCourse_language() {
        return course_language;
    }

    public void setCourse_language(String course_language) {
        this.course_language = course_language;
    }

    public int getMin_num_of_student() {
        return min_num_of_student;
    }

    public void setMin_num_of_student(int min_num_of_student) {
        this.min_num_of_student = min_num_of_student;
    }

    public int getMax_num_of_student() {
        return max_num_of_student;
    }

    public void setMax_num_of_student(int max_num_of_student) {
        this.max_num_of_student = max_num_of_student;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public String getLearning_outcome() {
        return learning_outcome;
    }

    public void setLearning_outcome(String learning_outcome) {
        this.learning_outcome = learning_outcome;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLearning_activities() {
        return learning_activities;
    }

    public void setLearning_activities(String learning_activities) {
        this.learning_activities = learning_activities;
    }

    public String getExam_form() {
        return exam_form;
    }

    public void setExam_form(String exam_form) {
        this.exam_form = exam_form;
    }

    public String getTeacher_Email() {
        return teacher_email;
    }

    public void setTeacher_Email(String teacher_Email) {
        this.teacher_email = teacher_Email;
    }
}
