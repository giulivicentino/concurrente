package TPO.monitores;

/**
 *
 * @author nacho
 */
public class Sala {

    private boolean hayResponsable = false;
    private boolean hayCritico = false;
    private int cantVisitantes = 0;

    public void visitar() throws InterruptedException {
        while (hayCritico) {
            this.wait();
        }
        System.out.println(Thread.currentThread().getName() + " ando visitandoooo");
        synchronized(this){
            cantVisitantes++;
        }
        Thread.sleep(200);
        
    }

    public void controlar() throws InterruptedException {
        while (hayResponsable || hayCritico) {
            this.wait();
        }
        System.out.println(Thread.currentThread().getName() + " ando controlandoooo");
        Thread.sleep(400);
        this.notifyAll();
    }

    public void criticar() throws InterruptedException {
        while (hayCritico || hayResponsable || cantVisitantes > 0) {
            this.wait();
        }
        System.out.println(Thread.currentThread().getName() + " ando criticando");
        Thread.sleep(400);
        this.notifyAll();
    }
    
    public void entraResponsable(){
        hayResponsable = true;
    }
    
    public void entraCritico(){
        hayCritico = true;
    }
}
