/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.ej4PollosHermanos2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giuli
 */
public class Empleado extends Thread {

    private int opcion;
    private Confiteria confi;

    public Empleado(int opcion, Confiteria unaConfiteria) {
        this.opcion = opcion;
        confi = unaConfiteria;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+"quiero sentarme-----------");
            confi.sentarse();
            
            switch (opcion) {
                case 1://si pide bebida
                    System.out.println(Thread.currentThread().getName()+"pedi opcion 1 solo bebida");
                    confi.pedirBebida();
                    confi.tomar();
                    ;
                    break;
                case 2: //si pide comida
                    System.out.println(Thread.currentThread().getName()+"pedi opcion 2 solo comida");
                    confi.pedirComida();
                    confi.comer();
                    break;
                case 3: // si pide ambas
                    System.out.println(Thread.currentThread().getName()+"pedi opcion 3 ambas cosas");
                    confi.pedirBebida();
                    confi.tomar();
                    System.out.println(Thread.currentThread().getName()+"pedi 3 ya tengo bebida quiero comer!!");
                    confi.pedirComida();
                    confi.comer();
                    break;
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
            }
            confi.irse();
            System.out.println(Thread.currentThread().getName()+"me re fuiuiii---------------");
        } catch (InterruptedException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
