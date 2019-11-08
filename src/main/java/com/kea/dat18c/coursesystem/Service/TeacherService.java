package com.kea.dat18c.coursesystem.Service;

import com.kea.dat18c.coursesystem.Model.Teacher;
import com.kea.dat18c.coursesystem.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    final TeacherRepository teacherRepository;
    @Autowired
    private TeacherService(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }
    public void create(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void delete(String email){
        teacherRepository.deleteById(email);
    }

    public void update(Teacher teacher){
        teacherRepository.save(teacher);
    }
    public Teacher findById(String email){
        Optional<Teacher>find = teacherRepository.findById(email);
        if (find.isPresent()){
            return find.get();
        }
        return null;
    }
    public List<Teacher>getAll(){
        return (List<Teacher>) teacherRepository.findAll();
    }

}
