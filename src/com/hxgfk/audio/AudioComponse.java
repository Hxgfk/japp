package com.hxgfk.audio;

import java.io.*;
import java.nio.file.Files;

public class AudioComponse {
    public void componse(File f1, File f2, File output) throws IOException {
        InputStream is1 = Files.newInputStream(f1.toPath());
        InputStream is2 = Files.newInputStream(f2.toPath());

        OutputStream os = Files.newOutputStream(output.toPath());

        byte[]b1=new byte[128];
        byte[]b2=new byte[ 128 ];
        int len1 =0;
        int len2 =0;
        int index = 0;

        while((len1 = is1.read(b1))!=-1){
            index++;
            if(index==1){
                continue ;
            }
            os.write(b1, 0, len1 ) ;
        }
        index=0;
        while((len2 = is2.read(b2))!=-1){
            index++ ;
            os.write(b2, 0, len2 ) ;
        }

        is1.close() ;
        is2.close() ;
        os.flush();
        os.close() ;
    }
}
