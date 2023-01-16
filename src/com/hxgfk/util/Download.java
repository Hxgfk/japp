package com.hxgfk.util;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Download {
    public String SavePath;
    public String url;

    public Download(String SavePath, String Url) {
        this.SavePath = SavePath;
        this.url = Url;
    }

    public void run() throws IOException{
        int byteread;
        URL url = new URL(this.url);
        URLConnection conn = url.openConnection();
        conn.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
        InputStream inStream = conn.getInputStream();
        FileOutputStream fs = new FileOutputStream(this.SavePath);
        byte[] buffer = new byte[2048];
        while ((byteread = inStream.read(buffer)) != -1) {
            fs.write(buffer, 0, byteread);
        }
    }

    public String getUrl(){
        return this.url;
    }

    public String getSavePath(){
        return this.SavePath;
    }
}
