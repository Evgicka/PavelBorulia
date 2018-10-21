package dataProviders;


import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider
    public Object[][] headerDataProvider() {
        return new Object[][] {
                {"HOME", 1},
                {"CONTACT FORM", 2},
                {"SERVICE", 3},
                {"METALS & COLORS", 4},

        };
    }
}
