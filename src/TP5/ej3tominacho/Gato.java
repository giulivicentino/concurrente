package TP5.ej3tominacho;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Gato extends Thread{
    
    private Comedor comedor;
    
    public Gato(String nombre, Comedor comedor){
        this.setName(nombre);
        this.comedor = comedor;
    }
    
    public void run(){
        try {
            comedor.comerGato();
        } catch (InterruptedException ex) {
            Logger.getLogger(Gato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
