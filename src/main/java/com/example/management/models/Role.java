package com.example.management.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="roles")
public class Role {

    @Id
    @SequenceGenerator(name = "role_sequence" , sequenceName = "role_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO , generator = "role_sequence")
    private Long id;
    private  String name ;

    @ManyToMany(mappedBy = "roles" ,fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
    @JsonIgnore
    private  Set<Employee>  user = new HashSet<>();

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
