/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.ej4.Impresoria;

/**
 *
 * @author giuli
 */
public class Main {
        public static void main(String[] args){
        GestorImpresoras gestor = new GestorImpresoras();
        Cliente[] clientes = new Cliente[5];
        for (int i = 0; i < 5; i++) {
            clientes[i] = new Cliente(gestor);
        }
        for (int i = 0; i < 5; i++) {
            clientes[i].start();
        }
    }
}

