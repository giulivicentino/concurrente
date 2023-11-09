package TP8.ej1Cuartel;

import TP8.ej1Cuartel.Comedor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giuli Vicentino
 */
public class Soldado extends Thread {
private boolean quierePostre;
    private boolean quiereGaseosa;
    private Comedor comedor;

    public Soldado(Comedor unComedor, boolean quiereGas,boolean quierePos) {
        quiereGaseosa = quiereGas;
        comedor = unComedor;
        quierePostre= quiereGas;
    }

    public void run() {
        System.out.println("soy "+Thread.currentThread().getName()+" quiero gaseosa: "+quiereGaseosa+"  quiero postre: "+quierePostre);
        try {
            comedor.pedirBandeja(quiereGaseosa);
        } catch (InterruptedException ex) {}
        
        if(quierePostre){
            try {
                comedor.pedirPostre();
            } catch (InterruptedException ex) {}
        }
    }
}
