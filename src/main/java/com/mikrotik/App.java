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
            Socket socket = new Socket("192.168.91.1", 8728);

            // Usar el socket para crear la conexión
            ApiConnection conn = ApiConnection.connect(String.valueOf(socket));
            conn.login("admin", "009981");

            List<Map<String, String>> responses = conn.execute("/system/clock/print ");

            for (Map<String, String> response : responses) {
                System.out.println(response);
            }

            conn.close();
        } catch (Exception e) {
            System.err.println("Error al conectar: " + e.getMessage());
        }
    }
}


// Prueba funcionando, no me conecta al puerto del mikrotik....