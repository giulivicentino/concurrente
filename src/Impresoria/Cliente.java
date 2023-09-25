package Impresoria;

/**
 *
 * @author Giuli Vicentino
 */
public class Cliente extends Thread{
    GestorImpresoras gestor;
    
    public Cliente(GestorImpresoras gestor){
        this.gestor = gestor;
    }
    
    public void run(){
        try {
            gestor.buscar();
        } catch (InterruptedException ex) {
        }
        System.out.println(Thread.currentThread().getName() +" TERMINEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
    }
}
