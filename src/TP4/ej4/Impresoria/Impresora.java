/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.ej4.Impresoria;

import java.util.concurrent.Semaphore;

/**
 *
 * @author giuli
 */
public class Impresora {

    private int idImpresora;

    private Semaphore sem;
    private GestorImpresoras elGestor;

    public Impresora(int idImpresora, GestorImpresoras elGestor) {
        this.idImpresora = idImpresora;
        sem = new Semaphore(1);
        this.elGestor = elGestor;
    }

    public int getId() {
        return idImpresora;
    }

    public void usar() throws InterruptedException {
        sem.acquire();
        System.out.println("CLIENTE " + Thread.currentThread().getName() + " USANDO IMPRESORA " + this.getId());
        System.out.println("Imprimiendo...");
    }

    public void liberar() {
        sem.release();
        System.out.println("CLIENTE " + Thread.currentThread().getName() + " LIBERA IMPRESORA " + this.getId());
        //me libero, voy a colaLibre
        
    }
}
