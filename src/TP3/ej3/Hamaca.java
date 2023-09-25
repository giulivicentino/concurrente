/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.ej3;

/**
 *
 * @author giuli
 */
public class Hamaca {
 public synchronized void usarHamaca(int numeroHamster){
     System.out.println("Hamster: " +numeroHamster+ "esta durmiendo " );  
     try{
         Thread.sleep(1000);
     }catch(InterruptedException e){
     }
     System.out.println("Hamster: " +numeroHamster+ "TERMINO DE DORMIR " );  
 }   
}
