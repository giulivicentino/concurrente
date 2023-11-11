package TP8.ej4Homoterapia;

import java.util.concurrent.Semaphore;

public class SalaEspera {
    private int limite = 4;
    private Semaphore semCamilla = new Semaphore(4, true);
    private Semaphore semRevista = new Semaphore(9);
    private int camillasUsadas = 0;
    private Semaphore mutexSala = new Semaphore(1);
private Semaphore mutexCamilla = new Semaphore(1);
    public void pedirCamilla() throws InterruptedException {
        System.out.println("---------------------------------");
        mutexCamilla.acquire();
        if (camillasUsadas != limite) { // apenas llegas HAY camas disponibles
            mutexCamilla.release();
            semCamilla.acquire();
            // se modifican solo las camillas
            mutexSala.acquire();
            camillasUsadas++;
            System.out.println(Thread.currentThread().getName()+" consegui lugar de una me mandooo ,ahora hay" +(camillasUsadas-limite)+" camillas disponibles");
            mutexSala.release();
        } else {// vas a la sal de espera
      mutexCamilla.release();
            System.out.println(Thread.currentThread().getName()+"no hay lugar miro cronica");
            semRevista.acquire(); // pide la revista
            System.out.println(Thread.currentThread().getName()+" tengo revista premium jujuuu");
            semCamilla.acquire(); // se bloquea pero con una revista
            mutexSala.acquire();
            System.out.println(Thread.currentThread().getName()+" consegui lugar en la sala suelto todoo,ahora hay" +(camillasUsadas-limite)+" camillas disponibles");
            camillasUsadas++;
            mutexSala.release();
            semRevista.release();// si entra a la camilla suelta la revista
        }
       
    }

    public void salirCamilla() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" me tomo el palooo, ahora hay"+(camillasUsadas-limite)+" camillas disponibles");
        semCamilla.release();
        mutexSala.acquire();
        camillasUsadas--;
        mutexSala.release();

    }

}