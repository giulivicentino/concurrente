package tp4.ej7;

public class TP4EJ7 {

    public static void main(String[] args) {
        int k = 10000;
        Confiteria confiteria = new Confiteria();
        Empleado[] empleados = new Empleado[k];
        Mozo mozo = new Mozo(confiteria);
        for (int i = 0; i < k; i++) {
            empleados[i] = new Empleado(confiteria, "Empleado "+i);
        }
        mozo.start();
        for (int i = 0; i < k; i++) {
            empleados[i].start();
        }
        
    }
    
}
