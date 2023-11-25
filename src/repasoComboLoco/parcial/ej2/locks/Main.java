/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoComboLoco.parcial.ej2.locks;

import java.util.Random;

/**
 *
 * @author giuli
 */
public class Main {
    public static void main(String[] args) {
        Espacio espacio = new Espacio();
        Random r = new Random();
        Atomo atomos[] = new Atomo[15];
        for (int i = 0; i < 15; i++) {
            atomos[i] = new Atomo(r.nextBoolean(),espacio);
            atomos[i].start();
        }
    }
}
