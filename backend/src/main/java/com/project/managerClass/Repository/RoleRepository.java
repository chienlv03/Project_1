package com.project.managerClass.Repository;

import com.project.managerClass.Entity.Enum.ERole;
import com.project.managerClass.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
