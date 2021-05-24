package com.automation.api.models.user;

import com.automation.api.models.userConstants.EntryType;
import com.automation.api.models.userConstants.ProjectRole;
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
public class SuperAdminPersonalDTO {

    @JsonProperty("projectRole")
    private ProjectRole projectRole;

    @JsonProperty("entryType")
    private EntryType entryType;

}