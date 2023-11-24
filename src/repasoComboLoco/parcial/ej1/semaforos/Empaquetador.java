/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoComboLoco.parcial.ej1.semaforos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giuli
 */
public class Empaquetador extends Thread{
    private Planta planta;
    
   public Empaquetador(Planta planta){
       this.planta=planta;
   } 
   
   public void run(){
       while(true){
           try {
               planta.reponer();
           } catch (InterruptedException ex) {
               Logger.getLogger(Empaquetador.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
   }
}
