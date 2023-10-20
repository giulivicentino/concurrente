/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.ej1.Pileta;

import java.util.concurrent.Semaphore;

/**
 *
 * @author giuli
 */
public class Pileta {

    private int capacidadTotal;
    private int cantActual =0;
    private Semaphore usados;
   // private Semaphore libres;
    
private Semaphore mutex = new Semaphore(1);
    public Pileta(int capacidad) {
        capacidadTotal = capacidad;
        usados = new Semaphore(capacidad);
    
    }
    /*public boolean puedeEntrar(){
        return cantActual<capacidadTotal;
    }*/
    
    public void nadar() throws InterruptedException {
        usados.acquire();
        System.out.println(Thread.currentThread().getName()+"me meti a la pilee");
       
        Thread.sleep(50);
        
        usados.release();
        System.out.println(Thread.currentThread().getName()+"termine de chapotear");
        
        
    }

}
