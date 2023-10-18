/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.ej4.Impresoria;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 *
 * @author giuli
 */
public class GestorImpresoras {
    private Semaphore semVacio = new Semaphore(0);
    private Impresora[] colImpresoras = new Impresora[10];
    private Queue<Impresora> colaLibre; //es cola por que no importa que impresora uses
    private LinkedList <Impresora> listaOcupada; //es lista por que si queres saber que impresora termino de usarse para devolver ESA a la de libres
    private int i = 0;

    public GestorImpresoras() {
        for (int j = 0; j < 10; j++) {
             colaLibre.add(colImpresoras[j]);
        }
       
    }

    public void buscar() throws InterruptedException {
        boolean banderita;

        Impresora impAux = colaLibre.peek();
            banderita = (impAux == null);
            if (!banderita) {
                //tengo q sacar la impresora de colaLIbre
                colaLibre.remove();
                //TENGO Qponerlo en colaOcupada
                listaOcupada.add(impAux);
                
                impAux.usar();
                //imprimiendoo
                impAux.liberar();
                //lo saco de la cola ocupada
                listaOcupada.remove(impAux);
                
                //lo pongo en la de libres
                colaLibre.add(impAux);
            }else{
                semVacio.acquire();
            }
           
        
    }
    
}
