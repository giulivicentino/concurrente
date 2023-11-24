/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoComboLoco.parcial.ej1.semaforos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giuli
 */
public class Embotellador extends Thread {

    private boolean esAgua;
    Planta planta;

    public Embotellador(boolean agua, Planta planta) {
        esAgua = agua;
        this.planta = planta;
    }

    public void run() {
        while (true) {
            if (esAgua) {
                try {
                    System.out.println(Thread.currentThread().getName() + " quiero poner agua ");
                    planta.ponerAgua();
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            } else {
                try {
                    System.out.println(Thread.currentThread().getName() + " quiero poner vino ");
                    planta.ponerVino();
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
        }
    }
}
