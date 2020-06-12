package support;

import com.github.javafaker.Faker;

import java.util.Random;

public class RandomUsers {
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
        return getRandomSymbols() + "@yopmail.com";
    }

    public String setRandomFirstName() {
        return faker.name().firstName();
    }

    public String setRandomPhoneNum() {
        return faker.phoneNumber().phoneNumber();
    }
    public int setRandomWallet () {
        return (int)(Math.random() * 4 + 1);
    }
}
