package TPO;

public class Letra extends Thread {

    private String letra;
    private Asignador asignador;
    private int turno;
    private int cantRep;

    public Letra(int turno, String letra, int cantRep, Asignador asignador) {
        this.turno = turno;
        this.letra = letra;
        this.asignador = asignador;
        this.cantRep = cantRep;
    }

    public void run() {
        while (true) {
            if (asignador.getTurno() == turno) {
                for (int i = 0; i < cantRep; i++) {
                    System.out.print(letra);
                }
                asignador.asignarSigTurno();
            }
        }
    }
}
