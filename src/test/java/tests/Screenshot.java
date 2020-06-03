package tests;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Screenshot {
    String screenshotPath = "src/main/screenshots/";

    public void createScreenshot (String testName) throws IOException {
        String timeStamp;
        try {
            Thread.sleep(120);
            Robot r = new Robot();

            // It saves screenshot to desired path
            timeStamp = new SimpleDateFormat("dd MM yyyy_HH mm").format(Calendar.getInstance().getTime());
            String path = screenshotPath + testName + " - " + timeStamp + ".png";

            // Used to get ScreenSize and capture image
            Rectangle capture =
                    new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage Image = r.createScreenCapture(capture);
            ImageIO.write(Image, "png", new File(path));
            System.out.println("Screenshot saved, Test - FAILED");
        }
        catch (AWTException | IOException | InterruptedException ex) {
            System.out.println(ex);
        }
    }
}
