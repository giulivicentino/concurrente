package Impresoria;

/**
 *
 * @author Giuli Vicentino
 */
public class Cliente extends Thread{
    GestorImpresoras gestor = new GestorImpresoras();
    
    public void run(){
        try {
            gestor.buscar();
        } catch (InterruptedException ex) {
        }
    }
}
