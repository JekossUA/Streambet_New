package tests;

import support.Domains;

public class Run implements Domains {
    public static void main(String[] args) throws Exception {
        LoginTest loginTest = new LoginTest();
        MainPageTest mainPageTest = new MainPageTest();
        ProfileTests profileTests = new ProfileTests();
        RegistrationTest registrationTest = new RegistrationTest();

        loginTest.runLoginTests();
        mainPageTest.runMainPageTests();
        registrationTest.runRegistrationTests();
//        profileTests.runProfileTests();
    }
}
