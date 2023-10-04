package tp4.ej7;

import java.util.concurrent.Semaphore;

public class Confiteria {
    private Semaphore llegaEmpleado = new Semaphore(0);
    private Semaphore comer = new Semaphore(0);
    private Semaphore silla = new Semaphore(2, true);
    
    public void seSienta() throws InterruptedException{
        silla.acquire();
    }
    
    public void avisarMozo(){
        llegaEmpleado.release();
        System.out.println("Permisos disponibles: "+ llegaEmpleado.availablePermits());
    }
    
    public void hobby() throws InterruptedException{
        llegaEmpleado.acquire();
    }
    
    public void comer() throws InterruptedException{
        comer.acquire();
    }
    
    public void entregaComida(){
        comer.release();
    }
    
    public void liberaSilla(){
        silla.release();
    }
}
