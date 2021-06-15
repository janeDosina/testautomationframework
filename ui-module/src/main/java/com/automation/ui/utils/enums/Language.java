package com.automation.ui.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.testng.annotations.DataProvider;

import static com.automation.ui.utils.dataProviders.DataProviders.massToDataProviderArray;

@Getter
@AllArgsConstructor
public enum Language {
    ENGLISH("English (United States)", "Project role"),
    BELARUSIAN("Belarusian", "Праектная роля");
    String type;
    String value;

    @DataProvider(name = "languages")
    public static Object[][] getSideBarButtons() {
        return massToDataProviderArray(ENGLISH, BELARUSIAN);
    }
}