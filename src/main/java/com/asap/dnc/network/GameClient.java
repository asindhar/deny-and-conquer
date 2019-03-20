package com.asap.dnc.network;
import com.asap.dnc.core.GameMessage;

import java.net.*;
import java.io.*;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

class GameClient {
    private DatagramSocket socket;
    private InetAddress address;

    private GameClient() throws UnknownHostException, SocketException {
        socket = new DatagramSocket();
        address = InetAddress.getByName("localhost");
    }

    private void SendMessage() throws Exception {
        int n = 0;
        MessageType type = MessageType.CELL_ACQUIRE;
        while (n <= 20) {
            System.out.println(n);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            System.out.println(timestamp.getTime());
            GameMessage msg = new GameMessage(type, timestamp);
            ByteArrayOutputStream bStream = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bStream);
            oos.writeObject(msg);
            oos.flush();
            byte[] buf = bStream.toByteArray();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 5000);
            socket.send(packet);
            //packet = new DatagramPacket(buf, buf.length);
            //socket.receive(packet);
            // String received = new String(
            //   packet.getData(), 0, packet.getLength());
            // System.out.println(received+"\n");
            n++;
            TimeUnit.SECONDS.sleep(1);

        }
    }

    public static void main(String[] args) throws Exception{
        GameClient client1 = new GameClient();
        //GameClient client2 = new GameClient();
        client1.SendMessage();
    }
}
