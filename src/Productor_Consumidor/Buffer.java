package Productor_Consumidor;

import java.util.concurrent.Semaphore;

public class Buffer {

    private int capacidad = 10;
    private int cantidadU = 0;
    private Semaphore lugaresDisp = new Semaphore(10); // VACIO para agregar
    private Semaphore usados = new Semaphore(0);  // LLENO para sacar elementos
    private Semaphore mutex = new Semaphore(1);

    public synchronized boolean puedeAgregar(int num) {
        return (num <= (capacidad - cantidadU));
    }

    public void agregar(int num ,String nombre) throws InterruptedException {
        System.out.println("-------------SOY"+nombre);
        //primero t fijas si podes agregar todo lo q queres
                    System.out.println("quiero PONER " + num + " lugares para agregar producto");
        lugaresDisp.acquire(num);                            // le saco la cantidad que hay de VACIOS
        //si pudiste, te metes a tu turno del buffer
                    System.out.println("si tengo lugares");
        mutex.acquire();
        System.out.println("SOY re capo estoy en el buffer"+nombre+"-----------------------------");
                    System.out.println("Agrego " + num + "  cosas");
        cantidadU = cantidadU + num;
                    System.out.println("Ahora hay " + this.cantidadU + " cosas en la cinta");
                    System.out.println("no agrego mas nada chau");
        mutex.release();
        //haces que lo que dejaste este como usado
        usados.release(num); //le doy la cantidad de USADOS
    }

    public synchronized boolean puedeSacar(int num) {
        return cantidadU > 0 && num <= cantidadU; //no esta vacia AND no podes sacar mas de lo que hay
    }

    public void sacar(int num,String nombre) throws InterruptedException {
        System.out.println("-------------SOY"+nombre);
                    System.out.println("Quiero SACAR " + num + " lugares para agregar producto");
        usados.acquire(num); //le descuento a la cantidad de USADOS
                    System.out.println("si podes sacar maestro");
        mutex.acquire();
         System.out.println("SOY re capo estoy en el buffer"+nombre+"------------------------------");
        cantidadU = cantidadU - num;
                    System.out.println("Saco " + num + " cosas");
                    System.out.println("Ahora hay " + this.cantidadU + " cosas en la cinta");
        mutex.release();

        lugaresDisp.release(num); //acutalizo cuantos lugares hay VACIOS
    }
}