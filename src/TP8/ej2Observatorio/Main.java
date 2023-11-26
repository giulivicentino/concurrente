/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TP8.ej2Observatorio;

import java.util.Random;

/**
 *
 * @author giuli
 */
public class Main {
    public static void main(String[] args) {
        Observatorio obs = new Observatorio();
        int cantI=3,cantM=10,cantV=17;
        Investigador inv[]= new Investigador[cantI];
        Mantenimiento mant[] = new Mantenimiento[cantM];
        Visitante visit[] = new Visitante[cantV];
        Random r = new Random();
        
        for (int i = 0; i < 17; i++) {
            if(i<cantI){
             inv[i]= new Investigador(obs);
             inv[i].start();
            }
            if(i<cantM){
                mant[i] = new Mantenimiento(obs);
                mant[i].start();
            }
            if(i<cantV){
                visit[i]= new Visitante(obs,r.nextBoolean());
                visit[i].start();
            }
        }
        
        
    }
}
