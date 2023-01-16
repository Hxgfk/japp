package com.hxgfk.sql;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnectionBridge {
    private Connection connection;
    private String user;
    private String password;
    private String url;

    public DataBaseConnectionBridge(String user, String password, String url) throws SQLException {
        this.user = user;
        this.password = password;
        this.url = url;
        this.connection = DriverManager.getConnection(url, user, password);
    }

    public DataBaseConnectionBridge(String url) throws SQLException{
        this.url = url;
        this.connection = DriverManager.getConnection(url);
    }

    public Connection getConnection(){
        return this.connection;
    }

    public Driver getDriver() throws SQLException {
        return DriverManager.getDriver(this.url);
    }

    public int getLoginTimeout(){
        return DriverManager.getLoginTimeout();
    }

    public PrintWriter getLogWriter(){
        return DriverManager.getLogWriter();
    }

    public PrintStream getLogSteam(){
        return DriverManager.getLogStream();
    }
}
