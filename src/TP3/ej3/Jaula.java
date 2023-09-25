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
   
  Hamaca hamaquita = new Hamaca();
   Plato platito = new Plato();
   Rueda ruedita = new Rueda();
    //que se hace en la jaula
    
 public  void comer(int numeroHamster){ //no es SYNCHRONIZED por que sino seguiria pasando que hay un solo hamster en la jaula
   platito.usarPlato(numeroHamster);
   
 }   
    
  public void correr(int numeroHamster){
    ruedita.usarRueda(numeroHamster);
 }   
  
   public void dormir(int numeroHamster){
    hamaquita.usarHamaca(numeroHamster);
 }   
}
