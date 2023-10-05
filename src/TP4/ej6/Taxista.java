
package TP4.ej6;

public class Taxista extends Thread {
    private Taxi suTaxi;
    //constructor
    public Taxista(Taxi unTaxi){
        suTaxi= unTaxi;
    }
    
    public void run(){
        try{ //arranca durmiendo el tachero
            System.out.println(" estoy mimiendo mimimi");
            suTaxi.descanzaTaxista();
            
        } catch(InterruptedException ex) { }
        
        try{
            System.out.println("Viajandoo rrey");
            Thread.sleep(1000); //viajandoo
            
        } catch(InterruptedException ex) { }
        
        try{ 
            System.out.println("Termino el viaje papito baja");
           suTaxi.terminaViaje();
          
        }catch(InterruptedException ex){ }
    
    }
    
}
