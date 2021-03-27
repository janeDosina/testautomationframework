package com.automation.ui.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.testng.annotations.DataProvider;

import static com.automation.ui.utils.dataProviders.DataProviders.massToDataProviderArray;

@Getter
@AllArgsConstructor
public enum SideBarButtons {
    DASHBOARD("Dashboard"),
    LAUNCHES("Launches"),
    FILTERS("Filters"),
    DEBUG("Debug");
    String value;

    @DataProvider(name = "sideBarButtons")
    public static Object[][] getSideBarButtons() {
        return massToDataProviderArray(DASHBOARD.getValue(), LAUNCHES.getValue(), FILTERS.getValue(),
                DEBUG.getValue());
    }
}