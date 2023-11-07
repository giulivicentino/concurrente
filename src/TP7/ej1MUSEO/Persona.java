/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP7.ej1MUSEO;

/**
 *
 * @author giuli
 */

public class Persona extends Thread {

    private boolean jubilado;
    private GestorSala sala;

    public Persona(String nombre, boolean esJubilado, GestorSala sala) {
        super(nombre);
        this.jubilado = esJubilado;
        this.sala = sala;
    }

    public void run() {
        try {
            if (jubilado) {
                sala.entrarSalaJubilado();
            } else {
                sala.entrarSala();
            }
            Thread.sleep(2000);
            sala.salirSala(jubilado);
        } catch (Exception ex) {

        }
    }

}
