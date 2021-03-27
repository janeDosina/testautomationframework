package com.automation.ui.utils.dataProviders;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DataProviders {

    public static Object[][] massToDataProviderArray(Object... mass) {
        if (mass.length == 0) {
            return new Object[][]{};
        }
        Object[][] data = new Object[mass.length][1];
        for (int i = 0; i < mass.length; i++) {
            data[i][0] = mass[i];
        }
        return data;
    }
}