package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HelperClass2 {
    // Make a Screenshot when the Test Case fails
    public static void captureScreenShot(WebDriver driver, String screenShotName) throws IOException, IOException {
        Path dest = Paths.get("./screenshots", screenShotName + ".png");
        System.out.println("Creating directories if they don't exist...");
        Files.createDirectories(dest.getParent());
        System.out.println("Directories created: " + dest.getParent().toString());

        byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        System.out.println("Screenshot bytes length: " + screenshotBytes.length);

        try (FileOutputStream out = new FileOutputStream(dest.toString())) {
            out.write(screenshotBytes);
            out.flush();
            System.out.println("Screenshot saved at: " + dest.toString());
        } catch (IOException e) {
            System.err.println("Failed to write screenshot bytes to file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
