package TPOtrenes;

/**
 *
 * @author FAI-3240 / FAI-3234
 */
public class Parcial1 {

    public static void main(String[] args) {
        Tren tren = new Tren(5);
        int cantPasajeros = 20;
        Pasajero[] pasajeros = new Pasajero[cantPasajeros];
        MaquinaTickets maquina = new MaquinaTickets(40);
        ControlTren hiloControl = new ControlTren(tren);
        for (int i = 0; i < cantPasajeros; i++) {
            pasajeros[i] = new Pasajero("Pasajero "+i, tren, maquina);
        }
        for (int i = 0; i < cantPasajeros; i++) {
            pasajeros[i].start();
        }
        hiloControl.start();
    }
    
}
