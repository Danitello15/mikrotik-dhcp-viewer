package com.mikrotik;
import java.net.InetAddress;

public class TestHost {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("192.168.91.1");
            System.out.println("IP encontrada: " + address.getHostAddress());
        } catch (Exception e) {
            System.out.println("Host desconocido: " + e.getMessage());
        }
    }
}
