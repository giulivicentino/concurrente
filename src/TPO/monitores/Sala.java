package TPO.monitores;

/**
 *
 * @author nacho
 */
public class Sala {

    private boolean hayResponsable = false;
    private boolean hayCritico = false;
    private int cantVisitantes = 0;
    private final int capacidad = 6;

    public synchronized void visitar() throws InterruptedException {
        while (hayCritico || cantVisitantes == capacidad) {
            this.wait();
        }
        System.out.println(Thread.currentThread().getName() + " ando visitandoooo");
        cantVisitantes++;
    }

    public synchronized void terminarDeVisitar() {
        System.out.println(Thread.currentThread().getName() + " termine de visitar");
        this.notifyAll();
        cantVisitantes--;
    }

    public synchronized void controlar() throws InterruptedException {
        while (hayResponsable || hayCritico) {
            this.wait();
        }
        hayResponsable = true;
        System.out.println(Thread.currentThread().getName() + " ando controlandoooo");

    }

    public synchronized void criticar() throws InterruptedException {
        while (hayCritico || hayResponsable || cantVisitantes > 0) {
            this.wait();
        }
        hayCritico = true;
        System.out.println(Thread.currentThread().getName() + " ando criticando");
    }

    public synchronized void terminarDeControlar() {
        System.out.println(Thread.currentThread().getName() + " termine de controlar");
        hayResponsable = false;
        this.notifyAll();
    }

    public synchronized void terminarDeCriticar() {
        System.out.println(Thread.currentThread().getName() + " termine de criticar");
        hayCritico = false;
        this.notifyAll();
    }

}
