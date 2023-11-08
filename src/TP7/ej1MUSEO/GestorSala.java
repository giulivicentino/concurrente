package TP7.ej1MUSEO;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GestorSala { //monitooooor

    private int jubiladosEsperando = 0;
    private int limite = 5; //si tUmbral es +30   limite = 35
    private int tUmbral = 30;
    private int tempActual = 0;
    private int cantPersonasActual = 0;

//locks
    private Lock museo = new ReentrantLock();
    //condiciones
    private Condition jubilados = museo.newCondition();
    private Condition personas = museo.newCondition();

//metodo de persona
    public void entrarSala() {
        museo.lock();
        try {
            while (cantPersonasActual >= limite || jubiladosEsperando != 0) {
                personas.await();
            }
            System.out.println(Thread.currentThread().getName() + "  COMUN  entre a la salaa");
            cantPersonasActual++;

        } catch (InterruptedException ex) {
        } finally {
            museo.unlock();
        }
    }

    //metodo de jubilado
    public void entrarSalaJubilado() {
        museo.lock();

        try {
            jubiladosEsperando++;

            while (cantPersonasActual >= limite) {
                jubilados.await();
            }
            System.out.println(Thread.currentThread().getName() + "  JUBILADOOOO  entre a la salaa");
            cantPersonasActual++;
            jubiladosEsperando--;
        } catch (InterruptedException ex) {
        } finally {
            museo.unlock();
        }
    }
    //metodo de persona/jubilado

    public void salirSala(boolean esJubilado) {
        museo.lock();
        try {
            if (esJubilado) {
                System.out.println(Thread.currentThread().getName() + "  JUBILADOOO me voooy de la salaa");
                jubilados.signalAll();
            } else {
                System.out.println(Thread.currentThread().getName() + "  COMUUUN  me voooy de la salaa");
                personas.signalAll();
            }
            cantPersonasActual--;
        } finally {
            museo.unlock();
        }
    }
    //metodo de medidor

    public void notificarTemperatura(int temperatura) {
        museo.lock();
        try {
            tempActual = temperatura;
            if (tempActual > tUmbral) {
                limite = 3;
            } else {
                limite = 5;
            }
            System.out.println("                                           La Temperatura Actual es de " + tempActual + "°C");
            System.out.println("                                           La Sala tiene una Capacidad Maxima de " + limite + " personas");
        } catch (Exception ex) {
        } finally {
            museo.unlock();
        }

    }
}
