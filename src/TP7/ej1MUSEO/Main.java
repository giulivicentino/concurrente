package TP7.ej1MUSEO;

import java.util.Random;

public class Main {
 public static void main(String[] args){
        int cantPersonas = 15;
        int cantJubilados = 0;
        int cantNoJubilados;
        Persona[] personas = new Persona[cantPersonas];
        Random r = new Random();
        GestorSala sala = new GestorSala();
        Medidor medidor = new Medidor(sala);
        for (int i = 0; i < cantPersonas; i++) {
            boolean aux = r.nextBoolean();
            if (aux) {
                 personas[i] = new Persona("Jubilado "+i, aux, sala);
                cantJubilados++;
            }else{
                 personas[i] = new Persona("Persona "+i, aux, sala);
                 
            }
        }
        cantNoJubilados = cantPersonas - cantJubilados;
        System.out.println("Cant. jubilados: "+cantJubilados);
        System.out.println("Cant. no jubilados: "+cantNoJubilados);
        medidor.start();
        for (int i = 0; i < cantPersonas; i++) {
            System.out.println("que pasa+"+ personas[i]);
            personas[i].start();
        }
    }
}
   

