package com.kea.dat18c.coursesystem.auth.Teacher;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TeacherService implements UserDetailsService {

    private final TeacherRepository teacherRepository;

    TeacherService(TeacherRepository teacherRepository){
        super();
        this.teacherRepository = teacherRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Teacher teacher = this.teacherRepository.findByUsername(username);
        if (null == teacher){
            throw new UsernameNotFoundException("cannot find username: " + username);
        }
        return new TeacherPrincipal(teacher);
    }
}
