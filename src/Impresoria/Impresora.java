package Impresoria;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Giuli Vicentino
 */
public class Impresora {

    private boolean enUso;
    private int idImpresora;
    private Semaphore mutex;
    private Semaphore sem;

    public Impresora(int idImpresora) {
        this.idImpresora = idImpresora;
        enUso = false;
        mutex = new Semaphore(1);
        sem = new Semaphore(1);
    }

    public int getId() {
        return idImpresora;
    }

    public boolean usar() throws InterruptedException {
        mutex.acquire();
        if (!enUso) {
            enUso = true;
            sem.acquire();
        }
        mutex.release();
        return !enUso;
    }

    public void liberar() {
        enUso = false;
        sem.release();
    }
}
