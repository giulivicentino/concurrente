package TP3.ej2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Mago extends Thread {

    private final Energia energia;
    private int tipo;

    public Mago(Energia energia, int tipo) {
        this.energia = energia;
        this.tipo = tipo;
    }

    public void usarMagia() throws InterruptedException {
        synchronized(energia) {
            String accion;
            if (tipo == 0) {
                energia.hacerAlgo(3);
                accion = "curó";
            } else {
                energia.hacerAlgo(-3);
                accion = "drenó";
            }
            System.out.println(Thread.currentThread().getName() + ": " + accion + " 3 de vida. Energía actual: " + energia.getEnergia());
        }
    }

    public void run() {
        while (energia.getEnergia() < 100 && energia.getEnergia() > 0) {
            try {
                /*
                try {
                Thread.sleep(1000);
                } catch (InterruptedException ex) {
                Logger.getLogger(Sanador.class.getName()).log(Level.SEVERE, null, ex);
                }
                 */
                usarMagia();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mago.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
