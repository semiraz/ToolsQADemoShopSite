package test_components;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Utilities {

    public static String title = "ToolsQA Demo Site";
    public static String searchedWord = "MAXI DRESS";
    public static String productName = "RED SATIN ROUND NECK BACKLESS MAXI DRESS";
    public static String color = "Mauve";
    public static String size = "Large";
    public static String country= "Bosnia and Herzegovina";
    public static String street = "My Street" + getRandomNumbers(3);
    public static String city = "Sarajevo";

    public static String errorFilterMsg = "Products are not filtered properly!";
    public static String errorAddToCartMsg = "Something went wrong. Product is not added to the cart.";
    public static String errorOrderMsg = "Something went wrong. Order has not been received!";
    public static String errorBillingAddress = "Something went wrong. Billing address is not the same as previously entered one.";
    public static String errorOrderNumber = "Something went wrong. It is not the same order!";

    public static String pageLoadFail(String page) {
        return "Title " + page + " is not as expected!";
    }

    public static String generateRandomEmail(int length, String name, String lastName) {
        String allowedChars = "1234567890" + "_-.";
        String email;
        String temp = RandomStringUtils.random(length, allowedChars);
        email = name + temp + lastName + "@gmail.com";
        return email;
    }

    public static String generateRandomPassword() {
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String symbols = "!?$%^&\"";
        String number = "1234567890";

        String c = RandomStringUtils.random(5, symbols);
        String u = RandomStringUtils.random(2, lower);
        String l = RandomStringUtils.random(3, lower.toUpperCase());
        String n = RandomStringUtils.random(2, number);
        return c.concat(u).concat(l).concat(n);
    }

    public static String generateFirstName() {
        List<String> firstNames = Arrays.asList("Malika", "Buba", "Anna", "Jane", "Lana", "Maximilian", "Benjamin", "Andrea", "Bella", "Bili");
        String nameF = "";
        for (String name : firstNames) {
            Collections.shuffle(firstNames);
            nameF = name;
        }
        return nameF;
    }

    public static String generateLastName() {
        List<String> lastNames = Arrays.asList("Sehet", "Lover", "Smith", "Miller", "Jones", "Kikic", "Anderson", "Lost", "Spakis", "Banda");
        String last = "";
        for (String name : lastNames) {
            Collections.shuffle(lastNames);
            last = name;
        }
        return last;
    }

    public static String getRandomNumbers(int length) {
        return RandomStringUtils.random(length, "0123456789");
    }
}
