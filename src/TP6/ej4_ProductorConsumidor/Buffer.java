
package TP6.ej4_ProductorConsumidor;

public class Buffer {
    private int cantUsando =0;
    private final int capacidad;

    public Buffer(int cantTotal){
        this.capacidad = cantTotal;
    }

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
//bloqueado si ya esta lleno
    while(cantUsando>=capacidad){
        this.wait();
    }
    System.out.println(Thread.currentThread().getName()+" ya produje jiji");
    cantUsando++;
     System.out.println("--------------Ahora en la cinta hay "+cantUsando+ "  productos--------------------");
    this.notifyAll();
}
}
