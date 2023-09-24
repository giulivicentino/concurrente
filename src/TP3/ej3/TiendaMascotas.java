/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP3.ej3;

/**
 *
 * @author giuli
 */
public class TiendaMascotas {
    Jaula jaula1 = new Jaula();
    int numeroHamsters = 3;
    
    Hamster ham1 = new Hamster(1,jaula1);
    Hamster ham2 = new Hamster(2,jaula1);
    Hamster ham3 = new Hamster(3,jaula1);
    
    Thread hilo1 = new Thread(ham1);
    Thread hilo2 = new Thread(ham2);
    Thread hilo3 = new Thread(ham3);
    
    ham1.start();
   
  
}
