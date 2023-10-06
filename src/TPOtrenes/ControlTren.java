package TPOtrenes;

import TPOtrenes.Tren;

public class ControlTren extends Thread {

    private Tren tren;

    public ControlTren(Tren tren) {
        this.tren = tren;
    }

    public void run() {
        while (true) {
            try {
                tren.realizarViaje();
            } catch (InterruptedException ex) {
            }
        }
    }
}
