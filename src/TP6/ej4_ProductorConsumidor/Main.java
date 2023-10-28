/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.ej4_ProductorConsumidor;

/**
 *
 * @author giuli
 */
public class Main {
    public static void main(String[] args) {
    Buffer bufon= new Buffer(10);
    Productor prod = new Productor(bufon);
    Consumidor cons = new Consumidor(bufon);
    Thread productor = new Thread(prod);
    Thread consumidor = new Thread(cons);
    productor.start();
    consumidor.start();
    
}
}