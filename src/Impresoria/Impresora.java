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
        boolean exito = false;
        if (!enUso) {
            sem.acquire();
            exito = true;
            enUso = true;
            
            System.out.println("CLIENTE " + Thread.currentThread().getName() + " USANDO IMPRESORA " + this.getId());
            System.out.println("Imprimiendo...");
        }
        mutex.release();
        return exito;
    }

    public boolean liberar() {
        enUso = false;
        sem.release();
        System.out.println("CLIENTE " + Thread.currentThread().getName() + " LIBERA IMPRESORA " + this.getId());
        return enUso;
    }
}
