/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.ej1.Pileta;

/**
 *
 * @author giuli
 */
public class Main {

    public static void main(String[] args) {
        int cant = 5;
        Pileta pile = new Pileta(cant);
        GestorPiscina gestor = new GestorPiscina(pile);
        Persona[] arrPer = new Persona[8];

        for (int i = 0; i < 8; i++) {

            arrPer[i] = new Persona(gestor);
            arrPer[i].start();
        }
        gestor.start();
    }
}
