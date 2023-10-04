package TPO;

public class Main {
    public static void main(String[] args){
        Asignador asignador = new Asignador();
        Letra a = new Letra(0, "A", 1, asignador);
        Letra b = new Letra(1, "B", 2, asignador);
        Letra c = new Letra(2, "C", 3, asignador);
        a.start();
        b.start();
        c.start();
    }
}
