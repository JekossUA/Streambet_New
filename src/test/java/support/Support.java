package support;

import com.github.javafaker.Faker;

import java.util.Random;

public class Support {
    Faker faker = new Faker();


    public String getRandomSymbols() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public String setRandomEmail() {
        String randomMail = getRandomSymbols() + "@yopmail.com";
        return randomMail;
    }

    public String setRandomFirstName() {
        String randomName = faker.name().firstName();
        return randomName;
    }

    public String setRandomPhoneNum() {
        String randomPhoneNumber = faker.phoneNumber().phoneNumber();
        return randomPhoneNumber;
    }
}
