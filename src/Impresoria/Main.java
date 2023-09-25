package Impresoria;

/**
 *
 * @author Giuli Vicentino
 */
public class Main {
    public static void main(String[] args){
        Cliente[] clientes = new Cliente[4];
        for (int i = 0; i < 4; i++) {
            clientes[i] = new Cliente();
        }
        for (int i = 0; i < 4; i++) {
            clientes[i].start();
        }
    }
}
