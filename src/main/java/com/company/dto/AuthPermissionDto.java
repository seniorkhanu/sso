package com.company.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.company.entity.AuthPermission}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class AuthPermissionDto implements Serializable {
    Long id;
    String permissionName;
    String description;
}