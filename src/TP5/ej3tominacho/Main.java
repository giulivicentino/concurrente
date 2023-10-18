package TP5.ej3tominacho;

public class Main {

    public static void main(String[] args) {
        int cantPerros = 6;
        int cantGatos = 19;
        int max = Math.max(cantPerros, cantGatos);
        
        Perro[] perros = new Perro[cantPerros];
        Gato[] gatos = new Gato[cantGatos];
        Comedor comedor = new Comedor(cantPerros, cantGatos);
        for (int i = 0; i < cantPerros; i++) {
            perros[i] = new Perro("Perro "+i, comedor);
        }
        for (int i = 0; i < cantGatos; i++) {
            gatos[i] = new Gato("Gato "+i, comedor);
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
