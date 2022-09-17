package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigFile {

    public Properties ReadConfigData() {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
        File file = new File(filePath);
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
        } catch (Exception e) {
            System.out.println("No such file available");
        }
        return properties;
    }
}
