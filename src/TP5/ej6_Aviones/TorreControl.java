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
public class TorreControl extends Thread {

    private Pista pissta;

    public TorreControl(Pista pissta) {
        this.pissta = pissta;
    }
    
    @Override
    public void run(){
        while(true){
          
            try {
                pissta.controlTorre();
            } catch (InterruptedException ex) {
                Logger.getLogger(TorreControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
