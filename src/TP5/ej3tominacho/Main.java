/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.ej3tominacho;

/**
 *
 * @author nacho
 */
public class Main {
    public static void main(String[] args){
        Perro[] perros = new Perro[50];
        Gato[] gatos = new Gato[50];
        Comedor comedor = new Comedor(50, 50);
        for (int i = 0; i < 50; i++) {
            perros[i] = new Perro("Perro "+i, comedor);
            gatos[i] = new Gato("Gato "+i, comedor);
            perros[i].start();
            gatos[i].start();
        }
    }
}
