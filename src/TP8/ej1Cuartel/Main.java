package TP8.ej1Cuartel;

import TP8.ej1Cuartel.Comedor;
import java.util.Random;

/**
 *
 * @author Giuli Vicentino
 */
public class Main {
    public static void main(String[] args) {
        Comedor comedor= new Comedor();
        Soldado soldados[]= new Soldado[10];
        Random r = new Random();
        Random r2 = new Random();
        for (int i = 0; i < 10; i++) {
            soldados[i] = new Soldado(comedor,r.nextBoolean(),r2.nextBoolean());
        }
        
        for (int i = 0; i < 10; i++) {
            soldados[i].start();
        }
    }
}
