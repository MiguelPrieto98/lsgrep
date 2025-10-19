package es.etg.psp.mangel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Grep {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains("a")) {
                    System.out.println(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}