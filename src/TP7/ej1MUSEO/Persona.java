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
                System.out.println("soy "+Thread.currentThread().getName()+" jubilado quiero entraa");
                sala.entrarSalaJubilado();
            } else {
                System.out.println("soy "+Thread.currentThread().getName()+" persona quiero entraa");

                sala.entrarSala();
            }
            Thread.sleep(200);
            sala.salirSala(jubilado);
        } catch (Exception ex) {

        }
    }

}
