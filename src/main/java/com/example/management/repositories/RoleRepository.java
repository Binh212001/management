package com.example.management.repositories;

import com.example.management.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
