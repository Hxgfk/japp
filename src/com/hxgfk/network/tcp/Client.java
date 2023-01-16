package com.hxgfk.network.tcp;

import com.hxgfk.exceptions.NetworkException;

import java.io.*;
import java.net.Socket;

public class Client {
    private final String ip;
    private final int port;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public Client(String SeverIP, int SeverPort) throws NetworkException, IOException {
        if (SeverPort > 65535){
            throw new NetworkException("Port over 65535");
        }
        this.ip = SeverIP;
        this.port = SeverPort;
        assert ip == null;
        Socket socket = new Socket(this.ip, this.port);
        this.inputStream = new DataInputStream(socket.getInputStream());
        this.outputStream = new DataOutputStream(socket.getOutputStream());
    }

    public byte[] readByte() throws IOException {
        byte[] bytes = new byte[]{};
        this.inputStream.read(bytes);
        return bytes;
    }

    public String readString() throws IOException {
        return this.inputStream.readUTF();
    }

    public InputStream getInputStream(){
        return this.inputStream;
    }

    public void sendString(String data) throws IOException {
        this.outputStream.writeUTF(data);
    }

    public void send(byte[] bytes) throws IOException {
        this.outputStream.write(bytes);
    }

    public OutputStream getOutputStream(){
        return this.outputStream;
    }
}
