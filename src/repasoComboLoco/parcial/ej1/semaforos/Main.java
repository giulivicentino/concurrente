/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoComboLoco.parcial.ej1.semaforos;

import java.util.Random;

/**
 *
 * @author giuli
 */
public class Main {
    public static void main(String[] args) {
         Planta planta = new Planta();
    Empaquetador empaque = new Empaquetador(planta);
    Transportador transporte = new Transportador(planta);
    Embotellador embotellados[] = new Embotellador[5];   
    Random r= new Random();
    for (int i = 0; i < 5; i++) {
            embotellados[i]= new Embotellador(r.nextBoolean(),planta);
        embotellados[i].start();
    }
    empaque.start();
    transporte.start();
    
    }
   
}


