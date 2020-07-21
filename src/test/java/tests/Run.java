package tests;

public class Run {
    public static void main(String[] args) throws Exception {
        LoginTest loginTest = new LoginTest();
        MainPageTest mainPageTest = new MainPageTest();
        ProfileTests profileTests = new ProfileTests();
        RegistrationTest registrationTest = new RegistrationTest();

        //run positive cases
        loginTest.LoginTest_Positive();
        registrationTest.RegistrationTest_Positive();
        mainPageTest.MainPage_Positive();
        profileTests.ProfileTest_BetHistory();
        profileTests.ProfileTest_Deposit_Withdrawal();
        profileTests.ProfileTest_PaymentHistory();

    }
}
