package TPO.monitores;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nacho
 */
public class Critico extends Thread {

    private Sala sala;

    public Critico(String name, Sala sala) {
        this.sala = sala;
        this.setName(name);
    }

    public void run() {
        try {
            sala.criticar();
            Thread.sleep(600);
        } catch (InterruptedException ex) {
        }
        sala.terminarDeCriticar();
    }
}
