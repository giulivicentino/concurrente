/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP6.ej6ProductorParte3;

/**
 *
 * @author giuli
 */
public class Buffer {
    private int cantUsando =0;
    


public synchronized void consumir() throws InterruptedException{
    System.out.println(Thread.currentThread().getName()+"  quiero consumiir locoo");    
//bloqueado si no hay nada
    while(cantUsando==0){
        this.wait();
    }
    System.out.println(Thread.currentThread().getName()+" ya consumi jiji");
    cantUsando--;
    System.out.println("--------------Ahora en la cinta hay "+cantUsando+ "  productos--------------------");
    this.notifyAll();
}

public synchronized void producir() throws InterruptedException{
    System.out.println(Thread.currentThread().getName()+"  quiero produciir locoo");    
//nunca se bloquea por que nunca se llena
    System.out.println(Thread.currentThread().getName()+" ya produje jiji");
    cantUsando++;
     System.out.println("--------------Ahora en la cinta hay "+cantUsando+ "  productos--------------------");
    this.notifyAll(); //para aviasarle a los otros hilos q esten bloqueados que algo se produjo
}
}