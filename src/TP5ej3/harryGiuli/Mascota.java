
package TP5ej3.harryGiuli;

/**
 *
 * @author giuli y harry
 */
public class Mascota extends Thread{
    private char tipo;
    private Comedor comedor;
    
    public Mascota(String nombre,char tipoMascota, Comedor comedor){
        this.setName(nombre);
        this.comedor = comedor;
        this.tipo = tipoMascota;
    }
    
    public void run(){
        try {
            comedor.Ingresar(tipo);
            comedor.comer(tipo);
        } catch (InterruptedException ex) {
           
        }
    }
    
}

