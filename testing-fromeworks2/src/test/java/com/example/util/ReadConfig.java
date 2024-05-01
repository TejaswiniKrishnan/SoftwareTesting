package com.example.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    // to read the data from the properties file(config properties)
    Properties pro;

    public ReadConfig() {
        File src = new File("C:\\Users\\Tejaswini\\OneDrive\\Documents\\hybrid\\Configuration\\Config.properties");
        try {

            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public String getURL() {
        String url = pro.getProperty("baseURL");
        return url;
    }

    public String getName() {
        String name = pro.getProperty("username");
        return name;
    }

    public String getPassword() {
        String pwd = pro.getProperty("password");
        return pwd;
    }
}
