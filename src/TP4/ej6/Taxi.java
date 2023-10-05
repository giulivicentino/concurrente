
package TP4.ej6;

import java.util.concurrent.Semaphore;

public class Taxi {
    private Semaphore tomar = new Semaphore(1); //el taxi siempre arranca libre
    private Semaphore dormir = new Semaphore(0); // lo que hace esperar al taxista cuando no hay un cliente
    private Semaphore viajeTermina = new Semaphore(0); //para avisar que termino el viaje

public void tomarTaxi() throws InterruptedException{
    tomar.acquire();
    
}

public void salirTaxi() throws InterruptedException{
    tomar.release();
}

public void descanzaTaxista() throws InterruptedException{
    dormir.acquire();
}

public void despiertaTaxista() throws InterruptedException{
    dormir.release();
}

public void terminaViaje() throws InterruptedException{
    viajeTermina.release();
}
public void nuevoViaje() throws InterruptedException{
    viajeTermina.acquire();
}
}
