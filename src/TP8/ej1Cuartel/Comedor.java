package TP8.ej1Cuartel;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Giuli Vicentino
 */
public class Comedor {
    //private int cantAlmuerzos,cantPostres,cantAbridores;
    private Random r= new Random();
    private Semaphore semAlmuerzo = new Semaphore(5);
     private Semaphore semPostre = new Semaphore(3);
     private Semaphore semAbridores = new Semaphore(10);
    
    public void pedirBandeja(boolean quiereGaseosa) throws InterruptedException{
        semAlmuerzo.acquire(); //agarra su almuerzo
        System.out.println(Thread.currentThread().getName()+" ya consegui comiddda"); 
        Thread.sleep(200, 500);
        semAlmuerzo.release();
        
        if(quiereGaseosa){
                semAbridores.acquire();
                System.out.println(Thread.currentThread().getName()+"ya encontre abridor juju");
                Thread.sleep(200, 500);
                semAbridores.release();
            }
        
    }
    

    public void pedirPostre() throws InterruptedException{
        semPostre.acquire();
        Thread.sleep(200, 500);
        semPostre.release();
    }
    
}
