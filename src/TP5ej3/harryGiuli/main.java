
package TP5ej3.harryGiuli;

/**
 *
 * @author giuli y harry
 */
public class main {
    
    public static void main(String[] args) {
        int cantPerros = 15;
        int cantGatos = 25;
        int max = cantPerros + cantGatos;
        
        Mascota[] perros = new Mascota[cantPerros];
        Mascota[] gatos = new Mascota[cantGatos];
        Comedor comedor = new Comedor(cantPerros, cantGatos);
        for (int i = 0; i < cantPerros; i++) {
            perros[i] = new Mascota("Perro "+i,'p', comedor);
        }
        for (int i = 0; i < cantGatos; i++) {
            gatos[i] = new Mascota("Gato "+i,'g', comedor);
        }
        
        for (int i = 0; i < max; i++) {
            if (i < cantPerros) {
                perros[i].start();
            }
            if (i < cantGatos) {
                gatos[i].start();
            }
        }
    }
}
