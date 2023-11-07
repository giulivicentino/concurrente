
package TP7.ej1MUSEO;

import java.util.Random;

public class Main {
  public static void main(String[] args) {
        GestorSala sala = new GestorSala();
Random r = new Random();
        Medidor medidor = new Medidor(sala);
        medidor.start();

        for(int i = 1; i < 60; i++) {
            boolean tipo = r.nextBoolean();
            if(i % 5 == 0) {
                Persona persona = new Persona("Jubilado " + i, tipo, sala);
                persona.start();
            } else {
                Persona persona = new Persona("Persona " + i, tipo, sala);
                persona.start();
            }
        }
    }
    
}
