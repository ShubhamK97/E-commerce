package com.project.e_commerce.repositories;

import com.project.e_commerce.model.AppRole;
import com.project.e_commerce.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole appRole);
}
