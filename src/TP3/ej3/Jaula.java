/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.ej3;

/**
 *
 * @author giuli
 */
public class Jaula {
   
    //que se hace en la jaula
    
 public synchronized void usarPlato(int numeroHamster){
     System.out.println("Hamster: " +numeroHamster+ "esta comiendo " );  
     try{
         Thread.sleep(1000);
     }catch(InterruptedException e){
         
     }
 }   
    
  public synchronized void usarRueda(int numeroHamster){
     System.out.println("Hamster: " +numeroHamster+ "esta corriendo " );  
     try{
         Thread.sleep(1000);
     }catch(InterruptedException e){
         
     }
 }   
  
   public synchronized void usarHamaca(int numeroHamster){
     System.out.println("Hamster: " +numeroHamster+ "esta descanzando " );  
     try{
         Thread.sleep(1000);
     }catch(InterruptedException e){
         
     }
 }   
 
}
