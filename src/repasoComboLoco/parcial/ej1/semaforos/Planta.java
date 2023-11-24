/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoComboLoco.parcial.ej1.semaforos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author giuli
 */
public class Planta {

    //son la cantidad de lugares que quedan de botellas en una caja y de lugares para cajas
    private Semaphore semAgua = new Semaphore(10);
    private Semaphore semVinos = new Semaphore(10);
    private Semaphore semLugarAlmacen = new Semaphore(10);
    //aseguran que solo un hilo modifique la cantidad de botellas x caja
    private Semaphore mutexAgua = new Semaphore(1);
    private Semaphore mutexVino = new Semaphore(1);
    //dependen de que otra accion suceda para que tengan el permiso
    private Semaphore mutexEmpaquetador = new Semaphore(0);
    private Semaphore mutexTransportar = new Semaphore(0);
    //contadores
    private int cantAguas = 0, cantVinos = 0, cantCajas = 0;

    public void ponerAgua() throws InterruptedException {
        semAgua.acquire(); //si hay lugar en la caja entra, sino se bloquea esperando lugar
        System.out.println(Thread.currentThread().getName()+" hay lugar en la caja de agua, intento agarrarla ");
        mutexAgua.acquire(); //se mete en la caja de agua UN SOLO EMBOTELLLADOR
        cantAguas++;
        System.out.println(Thread.currentThread().getName() + " puse un agua ahora hay "+cantAguas);

        if (cantAguas == 10) {
            System.out.println("hay que cambiar caja agua");
            mutexEmpaquetador.release(); // le suelta el permiso para que cambie la caja
        }
        mutexAgua.release();

    }

    public void ponerVino() throws InterruptedException {
        semVinos.acquire(); //si hay lugar en la caja entra, sino se bloquea esperando lugar
        System.out.println(Thread.currentThread().getName()+" hay lugar en la caja de vino, intento agarrarla ");
        mutexVino.acquire(); //se mete en la caja de agua UN SOLO EMBOTELLLADOR
        cantVinos++;
        System.out.println(Thread.currentThread().getName() + " puse un vino ahora hay"+cantVinos);

        if (cantVinos == 10) {
            System.out.println("hay que cambiar caja vino");
            mutexEmpaquetador.release(); // le suelta el permiso para que cambie la caja
        }
        mutexAgua.release();

    }
    
    public void reponer() throws InterruptedException{
        semLugarAlmacen.acquire();
        System.out.println("-------Empaquetador: puedo agarrar una caja por que hay lugar en el almacen");
        mutexEmpaquetador.acquire();
        cantCajas++;
        System.out.println("------Empaquetador: me pidieron que cambie una caja, ahora en el almacen hay "+cantCajas);
        
        if(cantCajas ==10){
            mutexTransportar.release(); //le suelta el permiso al transportista
            System.out.println("-------hay que vaciar el almacen");
        }
       if(cantVinos==10){
           cantVinos=0;
           semVinos.release(10); //deesbloquea al embotellador
           System.out.println("-----caja de vinos nueva");
       }else  if(cantAguas==10){
           cantAguas=0;
           semAgua.release(10); //deesbloquea al embotellador
           System.out.println("-------caja de agua nueva");
       }
    }
    
    public void despachar() throws InterruptedException{
        mutexTransportar.acquire();
        System.out.println("__________Transportista se va de locuraaa");
        cantCajas=0;
        semLugarAlmacen.release(10); 
        System.out.println("________almacen vaciado");
    }
}
