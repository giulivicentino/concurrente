package BarberoDormilon;

/**
 *
 * @author Giuli Vicentino
 */
public class Main {
    public static void main(String[] args){
        Asiento sillon = new Asiento();
        Barbero joni = new Barbero(sillon);
        Cliente[] bros = new Cliente[10];
        for (int i = 0; i < 10; i++) {
            bros[i] = new Cliente(sillon, i);
        }
        joni.start();
        for (int i = 0; i < 10; i++) {
            bros[i].start();
        }
    }
}
