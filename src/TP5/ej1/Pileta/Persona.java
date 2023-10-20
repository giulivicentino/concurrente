/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.ej1.Pileta;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giuli
 */
public class Persona extends Thread {

    private GestorPiscina elGestor;

    public Persona(GestorPiscina unGestor) {
        elGestor = unGestor;

    }

    @Override
    public void run() {
        elGestor.usarPileta();
    }
}
