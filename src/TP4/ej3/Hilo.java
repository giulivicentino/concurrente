/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.ej3;

/**
 *
 * @author giuli
 */
public class Hilo implements Runnable {

    //ATRIBUTOS
    private char unCaracter;
    private int cantVeces;
    private ReucrsoCompartido recursito;

    //CONSTRUCTOR
    public Hilo(char otroCaracter, int otraCant,ReucrsoCompartido recursito ) {
        unCaracter = otroCaracter;
        cantVeces = otraCant;
        this.recursito = recursito;
    }

    public void run() {
        try{
            recursito.imprimir(unCaracter, cantVeces);
        }catch(InterruptedException e){
            
        }
    }

}
