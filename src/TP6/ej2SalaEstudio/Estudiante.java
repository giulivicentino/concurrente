
package TP6.ej2SalaEstudio;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Estudiante extends Thread {
private Sala salita;
   
public Estudiante(Sala salitaa) {
    salita=salitaa;
    }
    
    
    public void run(){
        try {
            System.out.println("entroo");
            salita.entrarSala();
        } catch (InterruptedException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            System.out.println("laburoo");
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("nos vimoo");
        salita.salirSala();
    }
}
