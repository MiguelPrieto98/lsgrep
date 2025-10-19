package es.etg.psp.mangel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LS {
    public static void main(String[] args) {
        try {
            // Obtener el directorio home del usuario como ruta relativa
            String homeRelativa = System.getProperty("user.home");

            // Ejecutar 'ls' sobre esa ruta
            Process proceso = Runtime.getRuntime().exec(new String[]{"ls", homeRelativa});

            try ( 
                    BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
            }
            proceso.waitFor();
        } catch (IOException | InterruptedException e) {
            System.exit(1);
        }
    }
}