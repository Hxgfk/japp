package com.hxgfk.response;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class POST {
    private final String ua;
    private final URL url;
    private final HttpURLConnection connection;
    private String al;
    private ResponseParams params;

    public POST(String USER_AGENT, String url, String accept_language, ResponseParams params) throws IOException {
        this.url = new URL(url);
        this.ua = USER_AGENT;
        this.al = accept_language;
        this.connection = (HttpURLConnection) this.url.openConnection();
        this.connection.setRequestMethod("POST");
        this.params = params;
    }

    public URL getUrl(){
        return this.url;
    }

    public StringBuffer send() throws IOException {
        this.connection.addRequestProperty("User-Agent", this.ua);
        this.connection.addRequestProperty("Accept-Language", this.al);
        this.connection.setDoOutput(true);
        DataOutputStream stream = new DataOutputStream(this.connection.getOutputStream());
        stream.writeBytes(this.params.build());
        stream.flush();
        stream.close();
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
