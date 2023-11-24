/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoComboLoco.parcial.ej1.semaforos;

/**
 *
 * @author giuli
 */
public class Transportador extends Thread{
       private Planta planta;
    
   public Transportador(Planta planta){
       this.planta=planta;
   } 
   
   public void run(){
       while(true){
           try {
               planta.despachar();
           } catch (InterruptedException ex) {
           }
       }
   }
}

