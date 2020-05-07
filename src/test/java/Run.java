import client_App.Login;

public class Run {
    public static void main(String[] args) {
        Login login_Test = new Login();
        login_Test.LoginTest_Positive();
        login_Test.LoginTest_Negative_1();
        login_Test.LoginTest_Negative_2();
        login_Test.LoginTest_Negative_3();
        login_Test.LoginTest_Negative_4();
        login_Test.LoginTest_Negative_5();
    }
}
