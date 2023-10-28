/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.ej6ProductorParte3;

/**
 *
 * @author giuli
 */
public class Consumidor implements Runnable{
     private final Buffer bufon;
   
    public Consumidor(Buffer bufon) {
        this.bufon = bufon;
    }
    
    public void run(){
        while(true){
            try {
                bufon.consumir();
            } catch (InterruptedException ex) {
              
            }
        }
        
        
    }
    
}
