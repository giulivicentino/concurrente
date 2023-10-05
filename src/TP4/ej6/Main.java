package TP4.ej6;

public class Main {

    public static void main(String[] args) {
        Taxi taxiloko = new Taxi();
        Yo giuli = new Yo(taxiloko);
        Taxista tachero = new Taxista(taxiloko);
 giuli.start();
        tachero.start();
       

    }
}
