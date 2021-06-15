package com.automation.api.models.user;

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
public class AssignedProjectsDTO {

    @JsonProperty("superadmin_personal")
    private SuperAdminPersonalDTO superadmin_personal;

}