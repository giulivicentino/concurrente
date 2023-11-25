/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoComboLoco.parcial.ej2.locks;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giuli
 */
public class Atomo extends Thread {
    private boolean esOxigeno;
    private Espacio espacio;
    
    public Atomo(boolean oxigeno,Espacio espacio){
        this.espacio=espacio;
        esOxigeno=oxigeno;
    }
    
    public void run(){
        try {
            Thread.sleep(1000,2000);
            if(esOxigeno){
                try {
                    espacio.oListo();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Atomo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                try {
                    espacio.hListo();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Atomo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Atomo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
