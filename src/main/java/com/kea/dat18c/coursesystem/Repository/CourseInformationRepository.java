package com.kea.dat18c.coursesystem.Repository;

import com.kea.dat18c.coursesystem.Model.CourseInformation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseInformationRepository extends CrudRepository<CourseInformation, Integer>  {
}
