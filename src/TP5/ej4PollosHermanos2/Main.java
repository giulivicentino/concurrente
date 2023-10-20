/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP5.ej4PollosHermanos2;

/**
 *
 * @author giuli
 */
public class Main {
      
    public static void main(String[] args) {
        int k = 4;
        Confiteria confiteria = new Confiteria();
        Empleado[] empleados = new Empleado[k];
        Mozo mozo = new Mozo(confiteria);
       
        empleados[0] = new Empleado(1,confiteria);
        empleados[1] = new Empleado(3,confiteria);
        empleados[2] = new Empleado(2,confiteria);
        empleados[3] = new Empleado(1,confiteria);
        mozo.start();
        for (int i = 0; i < k; i++) {
            empleados[i].start();
        }
        
    }
    
    
}
