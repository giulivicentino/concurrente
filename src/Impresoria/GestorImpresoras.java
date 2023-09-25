package Impresoria;

/**
 *
 * @author Giuli Vicentino
 */
public class GestorImpresoras {

    private Impresora[] colImpresoras = new Impresora[cantImpresoras];
    private static final int cantImpresoras = 5;

    public GestorImpresoras() {
        for (int j = 0; j < cantImpresoras; j++) {
            colImpresoras[j] = new Impresora(j+1);
        }
    }

    public void buscar() throws InterruptedException {
        boolean encontro;
        int i = 0;
        do {
            Impresora impAux = colImpresoras[i];
            encontro = impAux.usar();
            if (encontro) {
                //System.out.println(Thread.currentThread().getName() + " encontró impresora "+impAux.getId());
                Thread.sleep(1000);
                impAux.liberar();
                //System.out.println(Thread.currentThread().getName() + " liberó impresora "+impAux.getId());
            } else {
                System.out.println(Thread.currentThread().getName() + " en imp "+(i+1));
                i = (i + 1) % 5;
            }
        } while (!encontro);
    }
}
