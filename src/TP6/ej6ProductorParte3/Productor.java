/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.ej6ProductorParte3;

/**
 *
 * @author giuli
 */

public class Productor implements Runnable {
     private final Buffer bufon;
   
    public Productor(Buffer bufon) {
        this.bufon = bufon;
    }
    
    public void run(){
        while(true){
            try {
                bufon.producir();
            } catch (InterruptedException ex) {
              
            }
        }
    }
}