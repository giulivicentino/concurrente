package TPO.monitores;

public class Main {

    public static void main(String[] args) {
        Sala sala = new Sala();
        Critico[] criticos = new Critico[2];
        Responsable[] responsables = new Responsable[2];
        Visitante[] visitors = new Visitante[20];

        for (int i = 0; i < 20; i++) {
            if (i < 2) {
                criticos[i] = new Critico("cri" + i, sala);
                responsables[i] = new Responsable("resp" + i, sala);
                criticos[i].start();
                responsables[i].start();
            }
            visitors[i] = new Visitante("vis" + i, sala);
            visitors[i].start();
        }
    }
}
