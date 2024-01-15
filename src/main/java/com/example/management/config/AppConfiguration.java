package com.example.management.config;

import jakarta.servlet.Registration;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@RequiredArgsConstructor
//@EnableWebMvc
@ComponentScan(basePackages = "com.example.management")
public class AppConfiguration  {


//
//    CustomUserDetailsService customUserDetailsService;
//    @Autowired
//    public AppConfiguration(UserRepository userRepository , CustomUserDetailsService customUserDetailsService) {
//        this.userRepository = userRepository;
//        this.customUserDetailsService = customUserDetailsService;
//
//    }
//
//
//

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception{



        http.csrf().disable()
                 .authorizeRequests()
                .requestMatchers("/","/css/**", "/js/**" ,  "/image/**" , "/employee/create**")
                .permitAll()
                .requestMatchers("/employee/**").permitAll()
                .and()
                .authorizeRequests()
                .requestMatchers("/*").permitAll()
                .and()
                .authorizeRequests()
                .requestMatchers("/auth/**").permitAll()
                .and()
                .authorizeRequests()
                .requestMatchers("/home/**")
                .authenticated()
                .anyRequest()
                .hasRole("USER_ROLE")
                .and()
                ;

        ;

        return http.build();
    }




    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//
//    @Bean
//    CommandLineRunner runner(UserService userService){
//        return  args -> {
//            userService.saveRole(new Role(null, "USER_ROLE"));
//            userService.saveRole(new Role(null, "USER_MANAGER"));
//            userService.saveRole(new Role(null, "ROLE_ADMIN"));
//
//            userService.saveUser(new UserEntity(null,"admin", "123", "ADMIN", new HashSet<>()));
//            userService.addRoleToUser("admin" , "USER_ROLE");
//            userService.addRoleToUser("admin" , "USER_MANAGER");
//            userService.addRoleToUser("admin" , "ROLE_ADMIN");
//        };
//    }


}
