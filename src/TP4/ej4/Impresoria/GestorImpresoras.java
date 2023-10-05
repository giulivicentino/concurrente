/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.ej4.Impresoria;

/**
 *
 * @author giuli
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
