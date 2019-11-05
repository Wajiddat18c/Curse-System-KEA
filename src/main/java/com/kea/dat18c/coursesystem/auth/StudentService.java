package com.kea.dat18c.coursesystem.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
@Service
public class StudentService implements UserDetailsService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        super();
        this.studentRepository = studentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = this.studentRepository.findByUsername(username);
        if(null== student){
            throw new UsernameNotFoundException("cannot find username: " + username);
        }
        return new StudentPrincipal(student);
    }
}
