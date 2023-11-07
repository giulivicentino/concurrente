/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP7.ej1MUSEO;

import java.util.Random;

/**
 *
 * @author giuli
 */
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
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
            }
        }
    }
}
