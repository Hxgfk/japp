package com.hxgfk.response;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GET {
    private final String ua;
    private final URL url;
    private final HttpURLConnection connection;

    public GET(String USER_AGENT, String url) throws IOException {
        this.url = new URL(url);
        this.ua = USER_AGENT;
        this.connection = (HttpURLConnection) this.url.openConnection();
        this.connection.setRequestMethod("GET");
    }

    public URL getUrl(){
        return this.url;
    }

    public void addParam(String param, String value){
        this.connection.addRequestProperty(param, value);
    }

    public int getStatus() throws IOException {
        return this.connection.getResponseCode();
    }

    public StringBuffer send() throws IOException {
        this.connection.addRequestProperty("User-Agent", this.ua);
        BufferedReader reader = new BufferedReader(new InputStreamReader(this.connection.getInputStream()));
        String line;
        StringBuffer buffer = new StringBuffer();
        while ((line = reader.readLine()) != null){
            buffer.append(line);
        }
        reader.close();
        return buffer;
    }
}
