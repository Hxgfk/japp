package com.hxgfk.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64 {
    /**
     * Encode string to base64
     */
    public static String encode(String text){
        return new BASE64Encoder().encode(text.getBytes());
    }

    /**
     * Decode base64 string
     */
    public static String decode(String text) throws Exception{
        return new String(new BASE64Decoder().decodeBuffer(text));
    }
}
