package com.mikrotik;

import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.MikrotikApiException;
import java.net.Socket;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        try {
            // Crear socket personalizado en el puerto 8729
            Socket socket = new Socket("192.168.40.24", 8729);

            // Usar el socket para crear la conexión
            ApiConnection conn = ApiConnection.connect(String.valueOf(socket));
            conn.login("admin", "009981");

            List<Map<String, String>> responses = conn.execute("/ip/dhcp-server/lease/print");

            for (Map<String, String> response : responses) {
                System.out.println(response);
            }

            conn.close();
        } catch (Exception e) {
            System.err.println("Error al conectar: " + e.getMessage());
        }
    }
}
