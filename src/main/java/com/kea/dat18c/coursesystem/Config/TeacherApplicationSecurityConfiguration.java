//package com.kea.dat18c.coursesystem.Config;
//
//import com.kea.dat18c.coursesystem.auth.Student.StudentService;
//import com.kea.dat18c.coursesystem.auth.Teacher.TeacherService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//@Order(10)
//public class TeacherApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private TeacherService teacherService;
//
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(teacherService);
//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//        return provider;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/teacherlogin")
//                .authenticated()
//                .and()
//                .formLogin()
//                .and()
//                .httpBasic();
//
//    }
//
//
//}