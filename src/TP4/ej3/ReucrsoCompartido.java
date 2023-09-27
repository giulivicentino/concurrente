/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.ej3;

import java.util.concurrent.Semaphore;

/**
 *
 * @author giuli
 */
public class ReucrsoCompartido {

    //atributos
    private Semaphore sem1;
    private Semaphore sem2;
    private Semaphore sem3;

    //CONSTRUCTOR
    public ReucrsoCompartido() {
        sem1 = new Semaphore(1); //un semaforo para cada letra por que quiero darle un 
        sem2 = new Semaphore(0); //orden a la impresion, si fuera aleatorio podria usar solo un semaforo
        sem3 = new Semaphore(0);
    }

    public void imprimir(char unCaracter, int cantVeces) throws InterruptedException {
        switch (unCaracter) {
            case 'A':
                this.imprimirA(cantVeces);
                break;
            case 'B':
                this.imprimirB(cantVeces);
                break;
            case 'C':
                this.imprimirC(cantVeces);
                break;
        }
    }

        private void imprimirA(int cantVeces) throws InterruptedException{
            sem1.acquire(); //utiliza el permiso (1) del sem1 ahora tiene(0)
            for (int i = 0; i < cantVeces; i++) {
                System.out.print("A"); 
            }
            sem2.release(); // le "devuelve" el permiso a sem2 enotnces ahora tiene (1)
        }
         private void imprimirB(int cantVeces) throws InterruptedException{
            sem2.acquire(); //utiliza el permiso (1) del sem2 ahora tiene(0)
            for (int i = 0; i < cantVeces; i++) {
                System.out.print("B"); 
            }
            sem3.release(); // le "devuelve" el permiso a sem3 enotnces ahora tiene (1)
        }
          private void imprimirC(int cantVeces) throws InterruptedException{
            sem3.acquire(); //utiliza el permiso (1) del sem3 ahora tiene(0)
            for (int i = 0; i < cantVeces; i++) {
                System.out.print("C"); 
            }
            sem1.release(); // le "devuelve" el permiso a sem1 enotnces ahora tiene (1)
        }
}
