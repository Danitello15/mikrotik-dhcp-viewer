package com.mikrotik;

import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.MikrotikApiException;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        try {
            ApiConnection conn = ApiConnection.connect("192.168.40.24");
            conn.login("admin", "009981");

            List<Map<String, String>> responses = conn.execute("/ip/dhcp-server/lease/print");

            for (Map<String,String> response : responses) {
                System.out.println(response);
            }

            conn.close();
        } catch (MikrotikApiException e) {
            System.err.println("Error al conectar: " + e.getMessage());
        }
    }
}
