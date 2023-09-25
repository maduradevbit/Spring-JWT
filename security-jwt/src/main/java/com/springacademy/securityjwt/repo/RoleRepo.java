package com.springacademy.securityjwt.repo;

import com.springacademy.securityjwt.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface RoleRepo extends JpaRepository<Role,String> {
}
