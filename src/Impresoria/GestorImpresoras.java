package Impresoria;

/**
 *
 * @author Giuli Vicentino
 */
public class GestorImpresoras {
    private Impresora[] colImpresoras = new Impresora[cantImpresoras];
    private static final int cantImpresoras = 5;

    public GestorImpresoras(){
        for (int j = 0; j < cantImpresoras; j++) {
            colImpresoras[j] = new Impresora(j);
        }
    }
    
    public void buscar() throws InterruptedException {
        boolean encontro;
        int i = 0;
        do {
            Impresora impAux = colImpresoras[i];
            encontro = impAux.usar();
            if (encontro) {
                System.out.println("CLIENTE " + Thread.currentThread().getName() +" USANDO IMPRESORA "+ impAux.getId());
                impAux.liberar();
            }else{
                System.out.println((i + 1) % 3);
                i = (i + 1) % 3;
            }
        } while (!encontro);
    }
}
