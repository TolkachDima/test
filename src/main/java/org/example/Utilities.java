package org.example;
import com.github.javafaker.Faker;

public class Utilities {

    public static Faker faker = new Faker();
    static String firstName = faker.name().firstName();
    static String lastName = faker.name().lastName();
    static String streetName = faker.address().streetAddress(true);
    static String phoneNumber = faker.phoneNumber().subscriberNumber(10);

//    static String zip = faker.address().zipCodeByState("TX");
    static String zip = "75001";
    static String login;
    static String email = faker.internet().emailAddress();
    static String password = faker.internet().password(8, 32, true, true, true);

    public static String getFirstName() {
        return firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static String getStreetName() {
        return streetName;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static String getZip() {
        return zip;
    }

    public static String getEmail() {
        return email;
    }
    public static String getLogin() {

        return login;
    }
    public static void setLogin(String login) {
        Utilities.login = login;

    }

    public static String getPassword() {
        return password;
    }
}
