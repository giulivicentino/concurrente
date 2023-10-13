/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Productor_Consumidor;

/**
 *
 * @author giuli
 */
public class Productor extends Thread{

    private Buffer bufon;
    private int cantidad;
    private String nombre;

    public Productor(Buffer bufon,int cantidad,String nombre) {
        this.bufon = bufon;
        this.cantidad =cantidad;
        this.nombre=nombre;
    }

    
    public void run() {
       // while(true) {
            try {
                
                
                if (bufon.puedeAgregar(cantidad)) {
                    bufon.agregar(cantidad,nombre);
                }
            } catch (Exception ex) {
            }
     //   }
        
    }

}
