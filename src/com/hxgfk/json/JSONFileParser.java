package com.hxgfk.json;

import com.alibaba.fastjson2.JSONObject;

import java.io.*;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class JSONFileParser {
    public final File file;

    public JSONFileParser(String path){
        this.file = new File(path);
    }

    public JSONFileParser(URI path) {
        this.file = new File(path);
    }

    public JSONFileParser(File file){
        this.file = file;
    }

    private JSONObject parse() throws IOException {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(this.file.toPath()), StandardCharsets.UTF_8))){
            String line;
            while ((line = reader.readLine()) != null){
                builder.append(line);
            }
        }
        return com.hxgfk.json.JSONParser.parse(builder.toString());
    }
}
