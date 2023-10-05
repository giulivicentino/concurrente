/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.ej4.Impresoria;

import java.util.concurrent.Semaphore;

/**
 *
 * @author giuli
 */
public class Impresora {
      private boolean enUso = false;
    private Semaphore sem = new Semaphore(1);
    
    public void usar() throws InterruptedException{
        enUso = true;
        sem.acquire();
    }
    
    public void liberar(){
        enUso = false;
        sem.release();
    }
    
    public boolean estaEnUso(){
        return enUso;
    }
}
