
package TP4.ej6;

public class Yo extends Thread {
     private Taxi suTaxi;
    //constructor
    public Yo(Taxi unTaxi){
        suTaxi= unTaxi;
    }

    public void run(){
        try { //TOMA EL TAXI
           System.out.println(Thread.currentThread().getName()+" tomo el taxi juju");
            suTaxi.tomarTaxi(); // el permiso de tomar queda en (0) 
            
        } catch (InterruptedException ex) { }
         
        try { //DESPIERTA AL TAXISTA
            System.out.println("amigo despertate!!");
            suTaxi.despiertaTaxista(); 
           
        } catch (InterruptedException ex) { }
       
        try { //resetea el viaje , lo da por terminado
            suTaxi.nuevoViaje();
        } catch (InterruptedException ex) { }
     
        try { //deja de tomar el taxi
             System.out.println(Thread.currentThread().getName()+" me tomo el palo del taxi");
            suTaxi.salirTaxi(); 
           
        } catch (InterruptedException ex) { }
     
     }

    
     
}
