package Impresoria;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Giuli Vicentino
 */
public class Impresora {
    private boolean enUso = false;
    private Semaphore sem = new Semaphore(1);
    
    public void usar() throws InterruptedException{
        enUso = true;
        sem.acquire();
    }
    
    public void liberar(){
        enUso = false;
        sem.release();
    }
    
    public boolean estaEnUso(){
        return enUso;
    }
}
