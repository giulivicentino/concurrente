/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Productor_Consumidor;

/**
 *
 * @author giuli
 */
public class Main {
     public static void main(String[] args) {
        Buffer bufon = new Buffer();
        
        Productor metro1 = new Productor(bufon,3,"metroT3");
        metro1.start();
        Consumidor cayu = new Consumidor(bufon,2,"cayuT2");
        cayu.start();
         Productor metro2 = new Productor(bufon,6,"metroT6");
        metro2.start();
        Consumidor cayu2 = new Consumidor(bufon,1,"cayuT1");
        cayu2.start();
         
    }
}