package com.hxgfk.sql;

import com.hxgfk.exceptions.SQLDriverMissingException;

public class LoadSQLDataBaseDriver {
    @SuppressWarnings(value = "The development version is 8.0.25, other versions may not be compatible")
    public static void load() throws SQLDriverMissingException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException exception){
            exception.printStackTrace();
            throw new SQLDriverMissingException();
        }
    }

    public static void load(String DriverClassPath) throws SQLDriverMissingException {
        try {
            Class.forName(DriverClassPath);
        }catch (ClassNotFoundException exception){
            exception.printStackTrace();
            throw new SQLDriverMissingException();
        }
    }
}
