
package TP7.ej1MUSEO;

import java.util.Random;

public class Medidor extends Thread{
    private GestorSala sala;
    private Random r;
    
    public Medidor(GestorSala sala){
        this.sala = sala;
        r = new Random();
    }
    
    public void run(){
        while(true){
            sala.notificarTemperatura(r.nextInt(25, 50));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }
}
