package com.hxgfk.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesFile {
    private final Properties properties = new Properties();

    public String getValue(String filePath,String key) {
        try {
            InputStream in = new BufferedInputStream (Files.newInputStream(Paths.get(filePath)));
            this.properties.load(in);
            return this.properties.getProperty (key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addProperties(String filePath,String parameterName,String parameterValue) {
        try {
            Path path = Paths.get(filePath);
            InputStream fis = Files.newInputStream(path);
            this.properties.load(fis);
            OutputStream fos = Files.newOutputStream(path);
            this.properties.setProperty(parameterName, parameterValue);
            this.properties.store(fos, "Update '" + parameterName + "' value");
        } catch (IOException e) {
            System.err.println("Visit "+filePath+" for updating "+parameterName+" value error");
        }
    }
}

