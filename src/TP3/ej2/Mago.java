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

    public boolean usarMagia() throws InterruptedException {
        boolean sigue = true;
        synchronized (energia) {
            if (energia.getEnergia() < 100 && energia.getEnergia() > 0) {
                String accion;
                if (tipo == 0) {
                    energia.hacerAlgo(3);
                    accion = "curó";
                } else {
                    energia.hacerAlgo(-3);
                    accion = "drenó";
                }
                System.out.println(Thread.currentThread().getName() + ": " + accion + " 3 de vida. Energía actual: " + energia.getEnergia());
                //Thread.sleep(50);
            } else {
                sigue = false;
            }
        }
        return sigue;
    }

    public void run() {
        boolean sigue = true;
        while (sigue) {
            try {
                /*
                try {
                Thread.sleep(1000);
                } catch (InterruptedException ex) {
                Logger.getLogger(Sanador.class.getName()).log(Level.SEVERE, null, ex);
                }
                 */
                sigue = usarMagia();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mago.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
