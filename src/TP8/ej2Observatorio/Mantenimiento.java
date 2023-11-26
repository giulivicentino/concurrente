package TP8.ej2Observatorio;

import java.util.logging.Level;
import java.util.logging.Logger;



public class Mantenimiento extends Thread {
    Observatorio obs;
    
    public Mantenimiento(Observatorio obs){
        this.obs=obs;
    }
    
    public void run(){
        try {
            obs.entrarMantenimiento();
            Thread.sleep(100,1000);
            obs.salirMantenimiento();
        } catch (InterruptedException ex) {
            Logger.getLogger(Mantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
