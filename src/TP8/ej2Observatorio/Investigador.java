package TP8.ej2Observatorio;

/**
 *
 * @author Giuli Vicentino
 */
public class Investigador extends Thread {
     Observatorio obs;
    
    public Investigador(Observatorio obs){
        this.obs=obs;
    }
    
    public void run(){
        try {
            obs.entrarInvestigador();
            Thread.sleep(100,1000);
            obs.salirInvestigador();
        } catch (InterruptedException ex) {
           
        }
    }
}
