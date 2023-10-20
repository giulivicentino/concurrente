/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.ej1.Pileta;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giuli
 */
public class GestorPiscina extends Thread{

    private Pileta pile;

    public GestorPiscina(Pileta pile) {
        this.pile = pile;
    }

    public void usarPileta (){
        //System.out.println("________Soy " + Thread.currentThread().getName() + " tratando de ir a la pile____________");
       
        try {
            pile.nadar();
        } catch (InterruptedException ex) {
            Logger.getLogger(GestorPiscina.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
      //  System.out.println("__________" + Thread.currentThread().getName() + "  termine flacco_____________");
    }

}
