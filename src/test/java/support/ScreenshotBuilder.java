package support;

import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScreenshotBuilder {
    public void createScreenshot (String testName, ChromeDriver driver) {
        String timeStamp;
        String screenshotPath = "src/main/screenshots/";
        try {
            Thread.sleep(120);
            timeStamp = new SimpleDateFormat("dd MM yyyy_HH mm").format(Calendar.getInstance().getTime());
            String path = screenshotPath + testName + " - " + timeStamp + ".png";

            Screenshot screenshot = new AShot().takeScreenshot(driver);
            ImageIO.write(screenshot.getImage(), "png", new File(path));
            System.out.println("Screenshot saved, Test - FAILED");

        } catch (IOException | InterruptedException ex) {
            System.out.println(ex);
        }

    }
}
