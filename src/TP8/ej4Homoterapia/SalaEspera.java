package TP8.ej4Homoterapia;

import java.util.concurrent.Semaphore;

public class SalaEspera {
    private int limite = 4;
    private Semaphore semCamilla = new Semaphore(limite, true);
    private Semaphore semRevista = new Semaphore(9);
    private int camillasUsadas = 0;
    private Semaphore mutexSala = new Semaphore(1);

    public void pedirCamilla() throws InterruptedException {
        if (camillasUsadas <= limite) { // apenas llegas HAY camas disponibles
            semCamilla.acquire();
            // se modifican solo las camillas
            mutexSala.acquire();
            camillasUsadas++;
            mutexSala.release();
        } else {// vas a la sal de espera
            semRevista.acquire(); // pide la revista
            semCamilla.acquire(); // se bloquea pero con una revista
            mutexSala.acquire();
            camillasUsadas++;
            mutexSala.release();
            semRevista.release();// si entra a la camilla suelta la revista
        }
    }

    public void salirCamilla() throws InterruptedException {
        semCamilla.release();
        mutexSala.acquire();
        camillasUsadas--;
        mutexSala.release();

    }

}