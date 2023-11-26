/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP8.ej2Observatorio;

/**
 *
 * @author giuli
 */
public class Visitante extends Thread {
    private boolean esSilla;
     Observatorio obs;
    
    public Visitante(Observatorio obs,boolean esSilla){
        this.obs=obs;
        this.esSilla=esSilla;
    }
    
    public void run(){
        try {
                obs.entrarVisitante(esSilla);
                Thread.sleep(100,1000);
                obs.salirVisitante(esSilla);
        } catch (InterruptedException ex) {
           
        }
    }
}
