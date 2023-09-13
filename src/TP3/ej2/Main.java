package TP3.ej2;
public class Main {
    public static void main(String[] args){
        Energia energia = new Energia();
        System.out.println(energia.getEnergia());
        Mago magonegro = new Mago(energia, 1);
        Mago hombrebueno = new Mago(energia, 0);
        Thread h1 = new Thread(magonegro, "Raneibol");
        Thread h2 = new Thread(hombrebueno, "Logitech");
        h1.start();
        h2.start();
    }
}
