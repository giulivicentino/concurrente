/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoComboLoco.parcial.ej2.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author giuli
 */
public class Espacio {
    private Lock lock = new ReentrantLock();
    private Condition hidrogeno = lock.newCondition();
    private Condition oxigeno = lock.newCondition();
    private Condition hidroEnEspera = lock.newCondition();
    private Condition oxigEnEspera = lock.newCondition();
    private int cantAguaR=0,cantOxi=0,cantHidro=0, capacidadMax=3;
        private boolean hayOxigeno=false,generado=false;
    
    public void oListo() throws InterruptedException{
        try{
            lock.lock();
            //si ya hay un oxigeno, espera a la siguiente fusion
            while(hayOxigeno){
                oxigeno.await();
            }
            System.out.println("OXIGENO LISTO");
            hayOxigeno=true;
            hidroEnEspera.signalAll(); //le aviso a los hidrogenos que esperaban a un oxigeno
       
            
            while(cantHidro<2){ //si tengo que esperar a que hayan dos hidrogenos
                oxigEnEspera.await();
            }
        
            if(!generado){ //si todavia no lo invoco un hidrogeno lo hace el
                generado=true;
                System.out.println("la fusion la invoco el oxigeno");
                hacerAgua();
            }
            
        }finally{
              lock.unlock();
        }
    }
    
    public void hListo() throws InterruptedException{
         try{
             lock.lock();
            while(cantHidro ==2){ //si ya hay dos hidrogenos, espera afuera
                hidrogeno.await();
            }
            
            cantHidro++;
             System.out.println("nuevo hidrogeno listo");
            
            while(!hayOxigeno){ //se bloquea si no hay oxigeno
                hidroEnEspera.await();
            }
            
            if(cantHidro==2){
                System.out.println("2 HIDROGENOS LISTOS");
                oxigEnEspera.signal();
                if(!generado){
                    generado=true;
                    System.out.println("la fusion la invoco el hidrogeno n"+cantHidro);
                hacerAgua();
                }
            }
            
        }finally{
              lock.unlock();
        }
    }
    
    private void hacerAgua() throws InterruptedException{ //lo llama oxigeno despues de hacer oListo
        try{
            lock.lock();
            cantAguaR++;
            System.out.println(" agua nuevaa ahora hay: "+cantAguaR);
            hayOxigeno=false;
            generado=false;
            cantHidro=0;
            
            if(cantAguaR == capacidadMax){
                cantAguaR=0;
                System.out.println("RECIPIENTE LLENO, AHORA SE VACIO");
            }
            
            oxigeno.signal();
            hidrogeno.signalAll();  
        }finally{
              lock.unlock();
        }
  
        
    }
}
