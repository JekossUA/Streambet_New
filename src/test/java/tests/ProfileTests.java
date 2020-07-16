package tests;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.ProfilePage;
import support.Domains;
import support.TestSettings;

public class ProfileTests extends ProfilePage implements Domains {
    TestSettings testSettings = new TestSettings();

    @BeforeClass
    public void runBeforeTest () {

    }

    @Test
    public void ProfileTest_Positive () {
        testSettings.runMaximizeWindow();

    }
}
