package DataProviderTests;

import org.example.Person;
import org.example.Woman;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class DataProviderTestWoman {

    @DataProvider(name = "DataForWoman")
    public Object[][] DataForWoman() {
        return new Object[][]{
                {"Jane", "Smith", 61, true},
                {"May", "Joe", 66, true},
                {"Name", "Woman", 76, true},
        };
    }

    @DataProvider(name = "WomanHasLorry")
    public Object[][] WomanHasLorry() {
        return new Object[][]{
                {"May", "Joe", 44, true},
                {"Name", "Woman", 76, false}
        };
    }

    @DataProvider(name = "PartnershipData")
    public Object[][] PartnershipData() {
        return new Object[][]{
                {"John", "Doe", 30, "Jane", "Smith", 25, true, "Doe", true}, // Register partnership
                {"John", "Doe", 30, "Jane", "Smith", 25, true, "Smith", false} // Deregister partnership
        };
    }

    public static boolean isDataWoman(String firstName, String lastName, int age) {
        return age > 60;
    }

    public static boolean isHasLorry(String firstName, String lastName, boolean hasLorry) {
        return hasLorry;
    }

    @Test(dataProvider = "DataForWoman", description = "Test to check if the person is considered a woman based on age")
    public void testDataWoman(String firstName, String lastName, int age, boolean expected) {
        assertEquals(isDataWoman(firstName, lastName, age), expected);
    }

    @Test(dataProvider = "WomanHasLorry", description = "Test to check if the person has a lorry based on provided data")
    public void testWomanHasLorry(String firstName, String lastName, int age, boolean hasLorry) {
        assertEquals(isHasLorry(firstName, lastName, hasLorry), hasLorry);
    }

    @Test(dataProvider = "PartnershipData", description = "Test to register and deregister partnership")
    public void testPartnership(String manFirstName, String manLastName, int manAge,
                                String womanFirstName, String womanLastName, int womanAge,
                                boolean womanHasLorry, String expectedLastName, boolean isRegister) {
        Person man = new Person(manFirstName, manLastName, manAge);
        Woman woman = new Woman(womanFirstName, womanLastName, womanAge, womanHasLorry);

        if (isRegister) {
            man.registerPartnership(woman);
        } else {
            man.deregisterPartnership(true);
        }

        if (isRegister) {
            Assert.assertEquals(man.getPartner(), woman);
            Assert.assertEquals(woman.getPartner(), man);
            Assert.assertEquals(woman.getLastName(), expectedLastName);
        } else {
            Assert.assertNull(man.getPartner());
            Assert.assertNull(woman.getPartner());
            Assert.assertEquals(woman.getLastName(), womanLastName);
        }
    }
}
