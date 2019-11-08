package com.kea.dat18c.coursesystem.Repository;

import com.kea.dat18c.coursesystem.Model.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, String > {
}
