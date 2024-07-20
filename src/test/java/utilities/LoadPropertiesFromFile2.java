package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class LoadPropertiesFromFile2 {
    // Load the properties file
    public static Properties userData = loadProperties(Paths.get(System.getProperty("user.dir"),
            "src/main/java/properties/config/config.properties"));

    private static Properties loadProperties(Path path) {
        Properties properties = new Properties();
        try {
            // Read all bytes from the file and load them into the Properties object
            properties.load(Files.newInputStream(path));
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
        return properties;
    }

}
