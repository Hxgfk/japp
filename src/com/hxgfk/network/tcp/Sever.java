package com.hxgfk.network.tcp;

import com.hxgfk.exceptions.NetworkException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever {
    private final ServerSocket severSocket;
    private Socket socket;
    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;

    public Sever(int port) throws IOException, NetworkException {
        if (port > 65535){
            throw new NetworkException("Port over 65535");
        }
        this.severSocket = new ServerSocket(port);
        this.inputStream = new DataInputStream(socket.getInputStream());
        this.outputStream = new DataOutputStream(socket.getOutputStream());
    }

    public ServerSocket getSeverSocket(){
        return this.severSocket;
    }

    public Socket accept() throws IOException {
        return this.severSocket.accept();
    }

    public void acceptInThis() throws IOException{
        this.socket = this.severSocket.accept();
    }

    public InputStream getInputStream(){
        return this.inputStream;
    }

    public OutputStream getOutputStream(){
        return this.outputStream;
    }

    public void sendString(String data) throws IOException {
        this.outputStream.writeUTF(data);
    }

    public void send(byte[] bytes) throws IOException {
        this.outputStream.write(bytes);
    }

    public byte[] readBytes() throws IOException {
        byte[] bytes = new byte[]{};
        this.inputStream.read(bytes);
        return bytes;
    }

    public static class Sender {
        private final Socket socket;
        private BufferedWriter stream;

        public Sender(Socket request) throws IOException{
            this.socket = request;
            this.initstream();
        }

        private void initstream() throws IOException {
            this.stream = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()/*, StandardCharsets.UTF_8*/));
        }

        public void addTextToStream(String send) throws IOException {
            this.stream.write(send);
        }

        public void newLineInSendDataStream() throws IOException {
            this.stream.newLine();
        }

        public void setStream(BufferedWriter stream){
            this.stream = stream;
        }

        public void sendAllAndCloseRequest() throws IOException {
            this.stream.flush();
            this.socket.close();
        }
    }
}
