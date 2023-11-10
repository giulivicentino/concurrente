package TP8.ej4Homoterapia;

public class main {

public static void main(String[] args) {
    SalaEspera salita = new SalaEspera();
    Persona personitas[] = new Persona[15];

    for (int i = 0; i < personitas.length; i++) {
        personitas[i] = new Persona(salita);
    }
}

}
