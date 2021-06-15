package com.automation.ui.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MenuItem {
    PROFILE("Profile"),
    LOGOUT("Logout");
    String value;
}