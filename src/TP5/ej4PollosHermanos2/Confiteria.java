/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.ej4PollosHermanos2;

import java.util.concurrent.Semaphore;

/**
 *
 * @author giuli
 */
public class Confiteria {
    private Semaphore mutexMozo = new Semaphore(1);
    private Semaphore mutexCocinero = new Semaphore(1);
   
    
   private Semaphore semComedor = new Semaphore(2);
    private Semaphore comer = new Semaphore(0);
   private Semaphore tomar = new Semaphore(0);
   
    //modulos de empleado
   public void sentarse() throws InterruptedException{
       semComedor.acquire();
   }
   public void irse(){
       semComedor.release();
   }
   public void pedirBebida() throws InterruptedException{
       System.out.println("intento pedir para tommar");
      mutexMozo.release(); 
   
   }
   public void pedirComida() throws InterruptedException{
       System.out.println("intento pedir para comerr");
       mutexCocinero.release();
   }
   
   public void entregarBebida(){
       comer.release();
   }
   public void entregarComida(){
       tomar.release();
   }
   
   public void tomar() throws InterruptedException{
       tomar.acquire();
   }
   public void comer() throws InterruptedException{
       comer.acquire(); 
   }
   //modulo de mozo
   public void hobby() throws InterruptedException{ //te bloqueas hasta que tengas un mozo que t puede atender
        mutexMozo.acquire(); 
   }
   
   //modulo de cocinero
public void hacerRecetas() throws InterruptedException{ //termino de cocinar se va de joda
     mutexCocinero.acquire();
}


}
