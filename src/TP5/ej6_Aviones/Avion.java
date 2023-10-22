/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.ej6_Aviones;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giuli
 */
public class Avion extends Thread{
    private Pista pissta;
    private boolean aterriza;
    
    public Avion(Pista pissta,boolean aterriza){
        this.pissta=pissta;
        this.aterriza=aterriza;
    }
    

    public void run(){
        if(aterriza){
            try {
                pissta.aterrizar();
            } catch (InterruptedException ex) {
                Logger.getLogger(Avion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                pissta.despegar();
            } catch (InterruptedException ex) {
                Logger.getLogger(Avion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
