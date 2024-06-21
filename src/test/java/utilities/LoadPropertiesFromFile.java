package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadPropertiesFromFile {
    //load the properties file
    public static Properties userData = LoadProperties(System.getProperty("user.dir")+
            "/src/main/java/properties/config/config.properties");


    private static Properties LoadProperties(String path){
        Properties pro = new Properties();
        // stream for reading File
        try {
            FileInputStream stream = new FileInputStream(path);
            pro.load(stream);
        } catch (FileNotFoundException e) {
            System.out.println("Error occured : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error occured while running : " + e.getMessage());
        }
        return pro;
    }

}
