/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.ej6ProductorParte3;

/**
 *
 * @author giuli
 */
public class Main {
    public static void main(String[] args) {
        int i;
        Buffer buffer = new Buffer();

        Consumidor[] consumidores = new Consumidor[5];
        for(i = 0; i < consumidores.length; i++) {
            consumidores[i] = new Consumidor(buffer);
            Thread hiloConsumidor = new Thread(consumidores[i]);
            hiloConsumidor.start();
        }

        Productor[] productores = new Productor[3];
        for(i = 0; i < productores.length; i++) {
            productores[i] = new Productor(buffer);
            Thread hiloProductor = new Thread(productores[i]);
            hiloProductor.start();
        }

    }

}
