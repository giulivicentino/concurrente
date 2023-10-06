/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP4.ej4.Impresoria;

/**
 *
 * @author giuli
 */
public class Cliente extends Thread{
    GestorImpresoras gestor;
    
    public Cliente(GestorImpresoras gestor){
        this.gestor = gestor;
    }
    
    public void run(){
        try {
            gestor.buscar();
        } catch (InterruptedException ex) {
        }
        System.out.println(Thread.currentThread().getName() +" TERMINEEEEEEE");
    }
}