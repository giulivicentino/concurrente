package parcial1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author nacho
 */
public class Tren {
    private int cantMaximaPasajeros = 5;
    private int cantActualPasajeros;
    private Semaphore semSubida;
    private Semaphore enViaje;
    
    public Tren(int cantMaxima){
        cantActualPasajeros = 0;
        semSubida = new Semaphore(1, true);
        enViaje = new Semaphore(0);
    }
    
    public void subir() throws InterruptedException{
        //mutex para realizar subida atomica
        semSubida.acquire();
        if (cantActualPasajeros == cantMaximaPasajeros) {
            System.out.println("Tren lleno, podes empezar el viaje");
            //libera permiso para que el hiloControl empiece el viaje
            enViaje.release();
        }else{
            System.out.println(Thread.currentThread().getName() + " se subióoooooo");
            cantActualPasajeros++;
            semSubida.release();
        }
    }
    
    public void realizarViaje() throws InterruptedException{
        enViaje.acquire();
        System.out.println("Empieza viaje, CHUCHHUUUUUUUU");
        Thread.sleep(1000);
        //se reinicia el viaje simulando que se termina el recorrido
        cantActualPasajeros = 0;
        //se habilita la subida de los pasajeros que quedaron esperando
        semSubida.release();
        System.out.println("Pueden volver a subirse todos !!!!");
    }
    
}
