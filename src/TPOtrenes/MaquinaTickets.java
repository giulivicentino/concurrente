package TPOtrenes;

public class MaquinaTickets {

    private int cantTickets = 0;
    private int cantMax = 40;

    public MaquinaTickets(int cantMax) {
        this.cantMax = cantMax;
    }

    public synchronized boolean comprarTicket() {
        boolean res = false;
        if (cantTickets < cantMax) {
            cantTickets++;
            res = true;
        }
        System.out.println("Cantidad de tickets actual: " + cantTickets);
        return res;
    }

}
