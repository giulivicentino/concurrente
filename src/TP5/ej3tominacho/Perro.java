package TP5.ej3tominacho;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Perro extends Thread{
    private Comedor comedor;
    
    public Perro(String nombre, Comedor comedor){
        this.setName(nombre);
        this.comedor = comedor;
    }
    
    public void run(){
        try {
            comedor.comerPerro();
        } catch (InterruptedException ex) {
            Logger.getLogger(Gato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean esGato(){
        return false;
    }
}
