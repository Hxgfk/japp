package com.hxgfk.audio;

import com.hxgfk.util.DecodePath;
import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;

import java.io.File;

public class Formater {
    private String format = "mp3";
    private String codec = "libmp3lame";
    private int samplingrate = 44100;
    private int bitrate = 64000;

    public Formater(int bitrate, int samplingrate, String codec, String format){
        this.bitrate = bitrate;
        this.samplingrate = samplingrate;
        this.codec = codec;
        this.format = format;
    }

    public Formater(){}

    public void format(File file) throws EncoderException {
        AudioAttributes audioAttributes = new AudioAttributes();
        audioAttributes.setBitRate(this.bitrate);
        audioAttributes.setSamplingRate(this.samplingrate);
        audioAttributes.setCodec(this.codec);
        EncodingAttributes attributes = new EncodingAttributes();
        attributes.setFormat(format);
        attributes.setAudioAttributes(audioAttributes);
        Encoder encoder = new Encoder();
        String[] pths = new DecodePath().decodePathToStringArray(file);
        StringBuilder pth = new StringBuilder();
        for (int i=0;i<pths.length-1;i++){
            pth.append(pths[i]).append("\\");
        }
        encoder.encode(file, new File(pth.append(file.getName()).append(".").append(this.format).toString()), attributes);
    }
}
