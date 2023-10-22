package TP5.ej6_Aviones;

public class Main {

    public static void main(String[] args) {
        Pista pistin = new Pista();
        Avion[] aviones = new Avion[15];

        TorreControl torre = new TorreControl(pistin);
        System.out.println("wtf");
        aviones[0] = new Avion(pistin, false);
        aviones[1] = new Avion(pistin, true);
        aviones[2] = new Avion(pistin, true);
        aviones[3] = new Avion(pistin, false);
        aviones[4] = new Avion(pistin, true);
        aviones[5] = new Avion(pistin, true);
        aviones[6] = new Avion(pistin, true);
        aviones[7] = new Avion(pistin, true);
        aviones[8] = new Avion(pistin, true);
        aviones[9] = new Avion(pistin, false);
        aviones[10] = new Avion(pistin, true);
        aviones[11] = new Avion(pistin, true);
        aviones[12] = new Avion(pistin, true);
        aviones[13] = new Avion(pistin, true);
        aviones[14] = new Avion(pistin, false);
        torre.start();
        for (int i = 0; i < 14; i++) {
            aviones[i].start();
        }
    }
}
