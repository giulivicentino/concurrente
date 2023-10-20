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
            confi.sentarse();
            
            switch (opcion) {
                case 1://si pide bebida
                    confi.pedirBebida();
                    confi.tomar();
                    ;
                    break;
                case 2: //si pide comida
                    confi.pedirComida();
                    confi.comer();
                    break;
                case 3: // si pide ambas
                    confi.pedirBebida();
                    confi.tomar();
                    confi.pedirComida();
                    confi.comer();
                    break;
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
            }
            confi.irse();
        } catch (InterruptedException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
