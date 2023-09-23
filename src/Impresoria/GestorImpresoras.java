package Impresoria;

/**
 *
 * @author Giuli Vicentino
 */
public class GestorImpresoras {
    private Impresora[] colImpresoras = new Impresora[5];
    private int i = 0;

    public void buscar() throws InterruptedException {
        boolean banderita;
        do {
            Impresora impAux = colImpresoras[i];
            banderita = impAux.estaEnUso();
            if (!impAux.estaEnUso()) {
                impAux.usar();
            }
            i = (i + 1)%8;
        } while (!banderita);
    }
}
