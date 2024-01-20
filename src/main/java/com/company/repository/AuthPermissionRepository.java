package com.company.repository;

import com.company.entity.AuthPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthPermissionRepository extends JpaRepository<AuthPermission, Long> {
}