
package TP6.ej2SalaEstudio;

public class Main {
    public static void main(String[] args) {
        Sala salita = new Sala(6);
        Estudiante[] palas = new Estudiante[10];
        for (int i = 0; i < 10; i++) {
            palas[i] = new Estudiante(salita);
        }
        for (int i = 0; i < 10; i++) {
            palas[i].start();
        }
        
    }
}
