
package TP3.ej3;

public class Hamster implements Runnable {
    //atributos de hamster
    private int numHamster;
    private Jaula jaula1;
    
    //constructor de hamster
    public Hamster(int numero, Jaula jaula2){
        this.numHamster= numero;
        this.jaula1= jaula2;
    }
    
    public void run(){
        jaula1.usarPlato(numHamster);
        jaula1.usarRueda(numHamster);
        jaula1.usarHamaca(numHamster);
    }
    
}
