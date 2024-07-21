package DataProviderTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class DataProviderTestMan {

    @DataProvider(name = "DataForMan")
    public Object[][] DataForMan() {
        return new Object[][]{
                {"John", "Doe", 30, false},
                {"Big", "Boy", 55, false},
                {"John", "Little", 66, true},
                {"Orest", "Golf", 77, true}
        };
    }

    @DataProvider(name = "ManHasBike")
    public Object[][] ManHasBike() {
        return new Object[][]{
                {"John", "Doe", 30, true},
                {"Big", "Boy", 40, false}
        };
    }

    public static boolean isDataMan(String firstName, String lastName, int age) {
        return age > 65;
    }

    public static boolean isHasBike(String firstName, String lastName, boolean hasBike) {
        return hasBike;
    }

    @Test(dataProvider = "DataForMan", description = "Test to check if the person is considered a man based on age")
    public void testDataMan(String firstName, String lastName, int age, boolean expected) {
        assertEquals(isDataMan(firstName, lastName, age), expected);
    }

    @Test(dataProvider = "ManHasBike", description = "Test to check if the person has a bike based on provided data")
    public void testManHasBike(String firstName, String lastName, int age, boolean hasBike) {
        assertEquals(isHasBike(firstName, lastName, hasBike), hasBike);
    }
}
