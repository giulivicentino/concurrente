package TP8.ej4Homoterapia;

import java.util.Random;

import javax.naming.InterruptedNamingException;

public class Persona extends Thread {
    private SalaEspera salita = new SalaEspera();
    private Random r = new Random();

    public Persona (SalaEspera salita){
        this.salita=salita;
    }
    
public void run(){
    try{
        salita.pedirCamilla();
        Thread.sleep(r.nextInt(100,1000));
        salita.salirCamilla();  
    }catch(InterruptedException e){
}
}
}