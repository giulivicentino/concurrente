package BarberoDormilon;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giuli Vicentino
 */
public class Cliente extends Thread{
    
    private Asiento sillon;
    private int numero;
    
    public Cliente(Asiento sillon, int numero){
        this.sillon = sillon;
        this.numero = numero;
    }
    
    public void run(){
        try {
            sillon.ocuparLugar();
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Bro "+numero+" toma el asiento");
        sillon.despertarBarbero();
        System.out.println("Bro "+numero+" despierta al barbero");
        try {
            sillon.salir();
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        sillon.liberarLugar();
    }
}
