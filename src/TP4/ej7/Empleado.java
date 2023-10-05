/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp4.ej7;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nacho
 */
public class Empleado extends Thread{
    private Confiteria conf;
    public Empleado(Confiteria unaConf, String nombre){
        conf = unaConf;
        this.setName(nombre);
    }
    
    public void run(){
        try {
            conf.seSienta();
        } catch (InterruptedException ex) {
        }
        conf.avisarMozo();
        System.out.println(Thread.currentThread().getName() + " Llego a los Pollos Hermanos !!!");
        try {
            conf.comer();
        } catch (InterruptedException ex) {
        }
        System.out.println(Thread.currentThread().getName() +" comiendo");
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
        }
        conf.liberaSilla();
    }
}
