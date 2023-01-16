package com.hxgfk.util;

import java.util.regex.Pattern;

public class RegExpTemplates {
    public interface Templates{
        String CheckTelephoneNumber = "^1[3-9]\\d{9}$";
        String CheckUrl = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";
        String CheckEmail = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        String CheckIP = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
    }

    private final String string;

    public RegExpTemplates(String string){
        this.string = string;
    }

    public boolean isTelephoneNumber(){
        return Pattern.matches(Templates.CheckTelephoneNumber, this.string);
    }

    public boolean isUrl(){
        return Pattern.matches(Templates.CheckUrl, this.string);
    }

    public boolean isEmail(){
        return Pattern.matches(Templates.CheckEmail, this.string);
    }

    public boolean isIP(){
        return Pattern.matches(Templates.CheckIP, this.string);
    }

    public boolean hasTargetString(String tg){
        return Pattern.matches("("+tg+")", this.string);
    }

    public boolean hasTargetString(String tg, String str){
        return Pattern.matches("("+tg+")", str);
    }

    public String replace(String[] checkStrings, String replaced){
        String newstr = this.string;
        for (String str : checkStrings){
            if (this.hasTargetString(str)){
                StringBuilder rs = new StringBuilder();
                for (int i=0;i<replaced.length();i++){
                    rs.append(replaced);
                }
                newstr = newstr.replace(str, rs.toString());
            }
        }
        return newstr;
    }
}
