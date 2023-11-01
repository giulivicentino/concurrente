
package TP6.ej2SalaEstudio;

public class Sala {
    private int limite;
    private int usados=0;
    
    public Sala(int capacidad){
        limite=capacidad;
    }
    
    public synchronized void entrarSala() throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+ "quiero entraaar");
        /*if(usados==limite){
            System.out.println("SALA LLENA PA");
        }*/
        while(usados>=limite){
            this.wait();
            System.out.println(Thread.currentThread().getName()+"baanco");
        }
         System.out.println(Thread.currentThread().getName()+"ya entre jiji");
        usados++;
    }
    
    public synchronized void salirSala(){
        usados--;
        this.notify();
        System.out.println(Thread.currentThread().getName()+"me tomo el buquee");
    }
}
