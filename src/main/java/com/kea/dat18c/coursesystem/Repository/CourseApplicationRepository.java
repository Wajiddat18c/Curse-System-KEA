package com.kea.dat18c.coursesystem.Repository;

import com.kea.dat18c.coursesystem.Model.CourseApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CourseApplicationRepository extends CrudRepository<CourseApplication, Integer>
{
}
