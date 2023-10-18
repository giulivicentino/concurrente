
package TP5ej3.harryGiuli;

import java.util.concurrent.Semaphore;

/**
 *
 * @author giuli y harry
 */
public class Comedor {

    private int cuentaActual = 0, capacidad = 5;
    private char tipoActual;
    private int totalGatos, totalPerros;
    private Semaphore mutexIngreso = new Semaphore(1);
    private Semaphore mutexComer = new Semaphore(1);
    private Semaphore semPlatos;

    private Semaphore semPerros = new Semaphore(capacidad);
    private Semaphore semGatos = new Semaphore(capacidad);

    public Comedor(int totalG, int totalP) {

        tipoActual = ' ';

        totalGatos = totalG;
        totalPerros = totalP;

    }

    public void cambiarTipo(char tipo) {
        tipoActual = tipo;
    }

    public void Ingresar(char tipoMascota) throws InterruptedException {
        mutexIngreso.acquire();
        if (tipoActual == ' ') {
            cambiarTipo(tipoMascota);
        }
        mutexIngreso.release();
    }

    public void comer(char tipoMascota) throws InterruptedException {
        mutexComer.acquire();
        if (tipoMascota == tipoActual) {
            if (tipoMascota == 'p') {
                semGatos.acquire(totalGatos); //bloqueo para que no entren gatos 
                semPerros.acquire();
                totalPerros--;
                cuentaActual++;
                System.out.println(Thread.currentThread().getName() + " esta comiendo un perro.");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " termino de comer un perro");
                semPerros.release();

                //verifica si ya puede cambiar a que entren gatos a comer
                if ((cuentaActual == capacidad && totalGatos != 0) || (totalPerros == 0 && cuentaActual < capacidad)) {
                    tipoActual = 'g';
                    //como ya puede cambiar libero todos los permisos de gato
                    semPerros.acquire(capacidad);
                    cuentaActual =0;
                    semGatos.release(capacidad);
                }
            } else if (tipoMascota == 'g') {
                semPerros.acquire(totalPerros); //bloqueo para que no entren perros 
                semGatos.acquire();
                totalGatos--;
                cuentaActual++;
                System.out.println(Thread.currentThread().getName() + " esta comiendo un gato.");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " termino de comer un gato");
                semGatos.release();

                //verifica si ya puede cambiar a que entren perros a comer
                if ((cuentaActual == capacidad && totalPerros != 0) || (totalGatos == 0 && cuentaActual < capacidad)) {
                    tipoActual = 'p';
                    //como ya puede cambiar libero todos los permisos de perro
                    semGatos.acquire(capacidad);
                    cuentaActual =0;
                    semPerros.release(capacidad);
                }
            }

        }

        mutexComer.release();
    }

}
