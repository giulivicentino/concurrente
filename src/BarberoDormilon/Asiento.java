package BarberoDormilon;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Giuli Vicentino
 */
public class Asiento {
    private Semaphore sillon = new Semaphore(1);
    private Semaphore barbero = new Semaphore(0);
    private Semaphore salida = new Semaphore(0);
    
    public void ocuparLugar() throws InterruptedException{
        sillon.acquire();
    }
    
    public void liberarLugar(){
        sillon.release();
    }
    
    public void despertarBarbero(){
        barbero.release();
    }
    
    public void barbroMimir() throws InterruptedException{
        barbero.acquire();
    }
    
    public void indicarSalida(){
        salida.release();
    }
    
    public void salir() throws InterruptedException{
        salida.acquire();
    }
}
