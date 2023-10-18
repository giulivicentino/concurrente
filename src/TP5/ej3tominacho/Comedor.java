package TP5.ej3tominacho;

import java.util.concurrent.Semaphore;

public class Comedor {

    private int k = 5;
    private int limitePorEspecie = 5;
    private int cuentaActual = 0;
    private boolean cambio = false;
    private int cantGatos, cantPerros;

    private Semaphore mutex = new Semaphore(1);
    private Semaphore mutex1 = new Semaphore(1);
    private Semaphore comederosPerros = new Semaphore(k);
    private Semaphore comederosGatos = new Semaphore(0);

    public Comedor(int cantPerros, int cantGatos) {
        this.cantGatos = cantGatos;
        this.cantPerros = cantPerros;
    }

    public void comerPerro() throws InterruptedException {
        mutex.acquire();
        comederosPerros.acquire();
        cantPerros--;
        cuentaActual++;
        if ((cuentaActual == limitePorEspecie && cantGatos != 0) || (cantPerros == 0 && cuentaActual < limitePorEspecie)) {
            cambio = true;
        }
        System.out.println(Thread.currentThread().getName() + " ESTA COMIENDOO. + CANT: " + cuentaActual + ", cantPerros: " + cantPerros + ", cantGatos: " + cantGatos);
        Thread.sleep(200);
        System.out.println(Thread.currentThread().getName() + " TERMINO DE COMER");
        comederosPerros.release();
        if (cambio) {
            System.out.println("SE LLEGO A LIMITE CAMBIOO A GATO");
            comederosPerros.acquire(k);
            cuentaActual = 0;
            comederosGatos.release(k);
            cambio = false;
        }
        mutex.release();
    }

    public void comerGato() throws InterruptedException {
        mutex1.acquire();
        comederosGatos.acquire();
        cantGatos--;
        cuentaActual++;
        if ((cuentaActual == limitePorEspecie && cantPerros != 0) || (cantGatos == 0 && cuentaActual < limitePorEspecie)) {
            cambio = true;
        }
        System.out.println(Thread.currentThread().getName() + " ESTA COMIENDOO. + CANT: " + cuentaActual + ", cantPerros: " + cantPerros + ", cantGatos: " + cantGatos);
        Thread.sleep(200);
        System.out.println(Thread.currentThread().getName() + " TERMINO DE COMER");
        comederosGatos.release();
        if (cambio) {
            System.out.println("SE LLEGO A LIMITE CAMBIOO A PERRO");
            comederosGatos.acquire(k);
            cuentaActual = 0;
            comederosPerros.release(k);
            cambio = false;
        }
        mutex1.release();
    }
}
