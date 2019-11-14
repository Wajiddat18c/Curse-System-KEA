package com.kea.dat18c.coursesystem.Service;

import com.kea.dat18c.coursesystem.Model.CourseApplication;
import com.kea.dat18c.coursesystem.Repository.CourseApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseApplicationService
{
    final CourseApplicationRepository courseApplicationRepository;

    @Autowired
    private CourseApplicationService(CourseApplicationRepository courseApplicationRepository)
    {
        this.courseApplicationRepository = courseApplicationRepository;
    }

    public void create (CourseApplication courseApplication)
    {
        courseApplicationRepository.save(courseApplication);
    }
    public CourseApplication findbyId(int id)
    {
        Optional<CourseApplication>find = courseApplicationRepository.findById(id);
                if(find.isPresent())
                {
                    return find.get();
                }

                return null;
    }
    public void update(CourseApplication courseApplication)
    {
        courseApplicationRepository.save(courseApplication);
    }
    public void delete (int id)
    {
        courseApplicationRepository.deleteById(id);
    }

    public List<CourseApplication> getAll(){
        return (List<CourseApplication>) courseApplicationRepository.findAll();
    }
}
