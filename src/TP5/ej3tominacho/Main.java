package TP5.ej3tominacho;

public class Main {

    public static void main(String[] args) {
        Perro[] perros = new Perro[50];
        Gato[] gatos = new Gato[23];
        Comedor comedor = new Comedor(50, 23);
        for (int i = 0; i < 50; i++) {
            if (i < 23) {
                perros[i] = new Perro("Perro " + i, comedor);

                gatos[i] = new Gato("Gato " + i, comedor);
                perros[i].start();

                gatos[i].start();
            } else {
                perros[i] = new Perro("Perro " + i, comedor);
                perros[i].start();
            }
        }
    }
}
