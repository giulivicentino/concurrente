package TPO;

public class Asignador {
    private int turno = 0;
    
    public int getTurno(){
        return turno;
    }
    public synchronized void asignarSigTurno(){
        turno = (turno + 1) % 3;
    }
}
