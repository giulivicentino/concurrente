package TP5.ej6_Aviones;
//RECURSO COMPARTIDO

import java.util.concurrent.Semaphore;

public class Pista {

    private Semaphore mutexPista = new Semaphore(1);
    private Semaphore semAterrizaje = new Semaphore(10);
    private Semaphore semDespegue = new Semaphore(1);
    private int cantAterrizajes = 0;
    private boolean huboDespegue =false;

    public void despegar() throws InterruptedException {
         System.out.println("Intento DESPEGAR "+Thread.currentThread().getName());
        semDespegue.acquire();
        mutexPista.acquire(); //pido la pista
        
            System.out.println(Thread.currentThread().getName() + " despegoooo ");
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + " termine el despegoooo");
          huboDespegue=true;
          System.out.println("aterrizajes actuales: "+cantAterrizajes+" hubo despegue?   "+huboDespegue);
            mutexPista.release();
        semDespegue.release();
    }
    
    public void controlTorre(){
          if(huboDespegue || cantAterrizajes == 10){
              
           //reseteo la los permisos de aterrizajes a que vuela a ser 10
            semAterrizaje.release(cantAterrizajes); //con que despegue alguno ya pueden aterrizar hasta 10 mas
           cantAterrizajes=0;   
           huboDespegue=false;
          }

    }
    
    public void aterrizar() throws InterruptedException {
         System.out.println("Intento ATERRIZAR "+Thread.currentThread().getName());
       
        semAterrizaje.acquire(); //puede aterrizar hasta 10 veces y sino espera a un depegue q le da los permisos

        mutexPista.acquire(); //EXCLUSION MUTUA
            System.out.println(Thread.currentThread().getName() + " aterrizooooo");
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + " aterrizooooo");
            cantAterrizajes++;
            System.out.println("aterrizajes actuales: "+cantAterrizajes+" hubo despegue?   "+huboDespegue);
        mutexPista.release();

    }

}
