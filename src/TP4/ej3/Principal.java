/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.ej3;

/**
 *
 * @author giuli
 */
public class Principal {

    public static void main(String[] args) throws InterruptedException {
        //creo el objeto
        ReucrsoCompartido recursito = new ReucrsoCompartido();
        Hilo cosa1 = new Hilo('A', 3,recursito);
        Hilo cosa2 = new Hilo('B', 1,recursito);
        Hilo cosa3 = new Hilo('C', 6,recursito);
        //creo el hilo a partir del objeto
        Thread hilo1 = new Thread(cosa1);
        Thread hilo2 = new Thread(cosa2);
        Thread hilo3 = new Thread(cosa3);
        // starteo los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}
