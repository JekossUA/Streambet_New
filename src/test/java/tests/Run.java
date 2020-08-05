package tests;

import support.Domains;

public class Run implements Domains {
    public static void main(String[] args) throws Exception {
        LoginTest loginTest = new LoginTest();
        MainPageTest mainPageTest = new MainPageTest();
        RegistrationTest registrationTest = new RegistrationTest();

        loginTest.runLoginTests();
        registrationTest.runRegistrationTests();
        mainPageTest.runMainPageTests();
    }
}
