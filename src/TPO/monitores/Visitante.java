package TPO.monitores;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nacho
 */
public class Visitante extends Thread {

    private Sala sala = new Sala();

    public Visitante(String name, Sala sala) {
        this.setName(name);
        this.sala = sala;
    }

    public void run() {
        try {
            sala.visitar();
            Thread.sleep(200);
        } catch (InterruptedException ex) {
        }
        sala.terminarDeVisitar();
    }
}
