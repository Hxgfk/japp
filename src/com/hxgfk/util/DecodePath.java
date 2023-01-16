package com.hxgfk.util;

import java.io.File;
import java.net.URI;
import java.nio.file.Path;

public class DecodePath {
    public static String regex = "/|\\\\";

    public String[] decodePathToStringArray(String path){
        return path.split(regex);
    }

    public String[] decodePathToStringArray(URI path){
        return path.getPath().split(regex);
    }

    public String[] decodePathToStringArray(File path){
        return path.getPath().split(regex);
    }

    public String[] decodePathToStringArray(Path path){
        return path.toString().split(regex);
    }
}
