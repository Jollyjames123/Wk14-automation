package resources.testdata;

import org.testng.annotations.DataProvider;

public class TestData1 {

    @DataProvider(name = "credentials")
    public Object[][] getData(){
        Object[][] data = new Object[][]{
                {"","123456"},
                {"abcd@gmail.com",""},
                {"adfdfgfg","123456"},
                {"abcd@gmail.com","123456"},

        };
    return data;
    }

}
