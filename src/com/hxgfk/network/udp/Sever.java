package com.hxgfk.network.udp;

import com.hxgfk.exceptions.NetworkException;

import java.io.IOException;
import java.net.*;

public class Sever {
    private final DatagramSocket socket;

    public Sever(String ClientIP, int ClientPort, DatagramSocket socket) throws NetworkException, UnknownHostException, SocketException {
        if (ClientPort > 65535){
            throw new NetworkException("Port over 65535");
        }
        assert ClientIP == null;
        this.socket = new DatagramSocket(ClientPort, InetAddress.getByName(ClientIP));
    }

    public void send(String data) throws IOException {
        byte[] bytes = data.getBytes();
        this.socket.send(new DatagramPacket(bytes, 0, bytes.length));
        this.socket.close();
    }

    public String read(int length) throws IOException {
        byte[] bytes = new byte[length];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        this.socket.receive(packet);
        return new String(bytes, 0, packet.getLength());
    }

    public void close(){
        this.socket.close();
    }
}
