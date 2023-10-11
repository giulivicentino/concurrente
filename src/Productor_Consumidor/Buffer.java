package Productor_Consumidor;

import java.util.concurrent.Semaphore;

public class Buffer {

    private int capacidad = 10;
    private int cantidadU = 0;

    private Semaphore lugaresDisp = new Semaphore(capacidad); // para agregar
    private Semaphore usados = new Semaphore(0);  //para sacar elementos
    private Semaphore mutex1 = new Semaphore(1);

    public synchronized boolean puedeAgregar(int num) {
        return (num <= (capacidad - cantidadU));
    }

    public void agregar(int num) throws InterruptedException {
        //para que solo un productor agregue a la vez
        mutex1.acquire();

        cantidadU = cantidadU + num;
        lugaresDisp.acquire(num); // le saco la cantidad que hay total disponible
        usados.release(num); //le doy la cantidad q agregue

        mutex1.release();
    }

    public boolean puedeSacar(int num) {
        return cantidadU > 0 && num <= cantidadU; //no esta vacia AND no podes sacar mas de lo que hay
    }

    public void sacar(int num) throws InterruptedException {
        mutex1.acquire();

        cantidadU = cantidadU - num;
        lugaresDisp.release(num); //le vuelvo a dar el "lugar"
        usados.acquire(num); //le descuento a la cantidad de usados

        mutex1.release();
    }
}
