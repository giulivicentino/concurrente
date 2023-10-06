package parcial1;

public class Pasajero extends Thread {

    private String nombre;
    private Tren tren;
    private MaquinaTickets maquina;
    private boolean tieneTicket;

    public Pasajero(String nombre, Tren tren, MaquinaTickets maquina) {
        this.nombre = nombre;
        this.tren = tren;
        this.maquina = maquina;
        this.tieneTicket = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void subir() throws InterruptedException {
        tren.subir();
    }

    public boolean comprar(){
        return maquina.comprarTicket();
    }
    
    public void run() {
        while (true) { //debe terminar si no hay mas tickets
            try {
                tieneTicket = comprar();
                if (tieneTicket) {
                    System.out.println(nombre + " compre tickeeet");
                    subir();
                    //se sube, ya consumio su ticket
                    tieneTicket = false;
                }else{
                    System.out.println("No hay mas tickets");
                }
            } catch (InterruptedException ex) {
            }
        }
    }
}
