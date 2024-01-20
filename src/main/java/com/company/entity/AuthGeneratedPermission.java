package com.company.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "auth_generate_permission")
public class AuthGeneratedPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "permission_name")
    private String permissionName;

    @CreationTimestamp
    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

}