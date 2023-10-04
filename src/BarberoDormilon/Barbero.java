package BarberoDormilon;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giuli Vicentino
 */
public class Barbero extends Thread {

    private Asiento sillon;

    public Barbero(Asiento sillon) {
        this.sillon = sillon;
    }

    public void run() {
        while (true) {
            try {
                sillon.barbroMimir();
            } catch (InterruptedException ex) {
                Logger.getLogger(Barbero.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Ya me desperté paaaaaaaaaa");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Barbero.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Ya te corté paaaaaaaaaaa. ahora andate");
            sillon.indicarSalida();
            System.out.println("Me duermo mimimimimi");
        }
    }
}
