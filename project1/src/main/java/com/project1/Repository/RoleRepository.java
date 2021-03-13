package com.project1.Repository;

import com.project1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<User, Integer> {
}
