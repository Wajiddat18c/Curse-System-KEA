package com.kea.dat18c.coursesystem.Service;

import com.kea.dat18c.coursesystem.Model.CourseInformation;
import com.kea.dat18c.coursesystem.Repository.CourseInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseInformationService {

    final CourseInformationRepository courseInformationRepository;

    @Autowired
    private CourseInformationService(CourseInformationRepository courseInformationRepository){
        this.courseInformationRepository = courseInformationRepository;
    }

    public void create (CourseInformation courseInformation){
        courseInformationRepository.save(courseInformation);
    }

    public void delete(int id){
        courseInformationRepository.deleteById(id);
    }


    public void update(CourseInformation courseInformation){
        courseInformationRepository.save(courseInformation);
    }

    public CourseInformation findById(int id){
        Optional<CourseInformation>find = courseInformationRepository.findById(id);
        if (find.isPresent()){
            return find.get();
        }
        return null;
    }

    public List<CourseInformation> getAll(){
        return (List<CourseInformation>) courseInformationRepository.findAll();
    }

}
