package TPO.monitores;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nacho
 */
public class Responsable extends Thread {

    private Sala sala;

    public Responsable(String name, Sala sala) {
        this.sala = sala;
        this.setName(name);
    }

    public void run() {
        try {
            sala.controlar();
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }
        sala.terminarDeControlar();
    }
}
