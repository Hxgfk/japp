package com.hxgfk.network.udp;

import com.hxgfk.exceptions.NetworkException;

import java.io.*;
import java.net.*;

public class Client {
    private final DatagramSocket socket;

    public Client(String SeverIP, int SeverPort) throws NetworkException, UnknownHostException, SocketException {
        if (SeverPort > 65535){
            throw new NetworkException("Port over 65535");
        }
        assert SeverIP == null;
        this.socket = new DatagramSocket(SeverPort, InetAddress.getByName(SeverIP));
    }

    public void send(String data) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(data.getBytes())));
        String line;
        while ((line=reader.readLine()) != null){
            byte[] bytes = line.getBytes();
            socket.send(new DatagramPacket(bytes, 0, bytes.length));
        }
    }

    public String read(int length) throws IOException {
        byte[] bytes = new byte[length];
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);
        socket.receive(packet);
        return new String(packet.getData(), 0, packet.getLength());
    }

    public void close(){
        this.socket.close();
    }
}
