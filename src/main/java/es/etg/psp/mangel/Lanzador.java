package es.etg.psp.mangel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Lanzador {

    private static final String[] COMANDO_LS = {
        "java", "-cp", "/media/sf_Dam_2/PsP/Proyectos/lsgrep/target/classes", "es.etg.psp.mangel.LS"
    };
    private static final String[] COMANDO_GREP = {
        "java", "-cp", "/media/sf_Dam_2/PsP/Proyectos/lsgrep/target/classes", "es.etg.psp.mangel.Grep"
    };

    public static void main(String[] args) throws IOException {
        Process procesoLS = Runtime.getRuntime().exec(COMANDO_LS);
        BufferedReader salidaLS = new BufferedReader(new InputStreamReader(procesoLS.getInputStream()));

        Process procesoGREP = Runtime.getRuntime().exec(COMANDO_GREP);
        PrintWriter entradaGREP = new PrintWriter(new OutputStreamWriter(procesoGREP.getOutputStream()), true);
        BufferedReader salidaGREP = new BufferedReader(new InputStreamReader(procesoGREP.getInputStream()));

        String linea;
        while ((linea = salidaLS.readLine()) != null) {
            entradaGREP.println(linea);
        }
        entradaGREP.close();

        String resultado;
        while ((resultado = salidaGREP.readLine()) != null) {
            System.out.println(resultado);
        }

        try {
            procesoLS.waitFor();
            procesoGREP.waitFor();
        } catch (InterruptedException e) {
            // Silenciado
        }
    }
}