package com.example.management.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String password;
    private  String fullName;
    private  String photoUrl ;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    private  boolean gender ;
    private String  address;
    private   Long manager;
    private  LocalDate createdAt;
    private  LocalDate updatedAt;
    private String phone;
    private  String email ;

    @ManyToMany
    @JoinTable(name = "user_role",
        joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles  = new HashSet<>();

    public Employee(Long id, String password, String fullName, Set<Role> roles) {
        this.id = id;
        this.password = password;
        this.fullName = fullName;
        this.roles = roles;
    }

}
