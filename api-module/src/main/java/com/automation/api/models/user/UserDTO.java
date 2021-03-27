package com.automation.api.models.user;

import com.automation.api.models.enums.AccountType;
import com.automation.api.models.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;

@Data
@Accessors(chain = true)
@SuperBuilder
@NoArgsConstructor
@Component
public class UserDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("email")
    private String email;

    @JsonProperty("photoId")
    private String photoId;

    @JsonProperty("fullName")
    private String fullName;

    @JsonProperty("accountType")
    private AccountType accountType;

    @JsonProperty("userRole")
    private UserRole userRole;

    @JsonProperty("photoLoaded")
    private Boolean photoLoaded;

    @JsonProperty("metadata")
    private MetaDataDTO metadata;

    @JsonProperty("assignedProjects")
    private AssignedProjectsDTO assignedProjects;
}