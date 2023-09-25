package Impresoria;

/**
 *
 * @author Giuli Vicentino
 */
public class Main {
    public static void main(String[] args){
        GestorImpresoras gestor = new GestorImpresoras();
        Cliente[] clientes = new Cliente[5];
        for (int i = 0; i < 5; i++) {
            clientes[i] = new Cliente(gestor);
        }
        for (int i = 0; i < 5; i++) {
            clientes[i].start();
        }
    }
}
