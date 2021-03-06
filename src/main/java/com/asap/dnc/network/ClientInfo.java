package com.asap.dnc.network;

import com.asap.dnc.core.PenColor;

import java.io.Serializable;
import java.net.InetSocketAddress;
import java.time.Clock;

public class ClientInfo extends InetSocketAddress implements Serializable {

    private boolean isHost;
    private PenColor color;
    private Clock clock;

    public ClientInfo(String address, int port) {
        super(address, port);
    }

    @Override
    public String toString() {
        return "{\n" +
                " address: " + getHostString() + ",\n" +
                " port: " + getPort() + ",\n" +
                " isHost: " + isHost + ",\n" +
                " penColor: " + color + "\n" +
                "}";
    }

    public void setPenColor(PenColor color) {
        this.color = color;
    }

    public PenColor getPenColor() {
        return color;
    }

    public void isHost(boolean b) {
        isHost = b;
    }

    public boolean isHost() {
        return isHost;
    }

    public void setClock(Clock clock) {
        this.clock = clock;
    }

    public long getTimeMillis() {
        return clock.millis();
    }

}
