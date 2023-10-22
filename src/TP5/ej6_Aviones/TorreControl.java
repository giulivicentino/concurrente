/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.ej6_Aviones;

/**
 *
 * @author giuli
 */
public class TorreControl extends Thread {

    private Pista pissta;

    public TorreControl(Pista pissta) {
        this.pissta = pissta;
    }
    
    @Override
    public void run(){
        while(true){
            pissta.controlTorre();
        }
    }
}
