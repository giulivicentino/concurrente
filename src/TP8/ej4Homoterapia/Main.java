/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP8.ej4Homoterapia;

/**
 *
 * @author giuli
 */
public class Main {
    
public static void main(String[] args) {
    SalaEspera salita = new SalaEspera();
    Persona personitas[] = new Persona[15];

    for (int i = 0; i < personitas.length; i++) {
        personitas[i] = new Persona(salita);
        personitas[i].start();
    }
}

}
