//package com.example.management.config;
//
//import com.example.management.models.Role;
//import com.example.management.models.User;
//import com.example.management.repositories.RoleRepository;
//import com.example.management.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//    UserRepository userRepository;
//    RoleRepository roleRepository;
//
//
//    @Autowired
//    public CustomUserDetailsService(UserRepository userRepository, RoleRepository roleRepository ) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        User user  = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("UserName not found"));
//        return new org.springframework.security.core.userdetails.User(user.getUsername() , user.getPassword(),mapRoleTo(user.getRoles()));
//    }
//
//    private Collection<GrantedAuthority> mapRoleTo(Set<Role> roles){
//        return  roles.stream().map(i->new SimpleGrantedAuthority(i.getName())).collect(Collectors.toList());
//    }
//}
