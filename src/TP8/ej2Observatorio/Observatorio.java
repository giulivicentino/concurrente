package TP8.ej2Observatorio;

public class Observatorio {
private int cantMant=0,cantActual=0,capacidad=5,cantVisi=0,cantDisc=0,cantInve=0;

public synchronized void entrarVisitante(boolean tieneSilla) throws InterruptedException{
    System.out.println(" soy visitante "+Thread.currentThread().getName()+", tengo silla? "+tieneSilla+ "quiero entrar wachoo");
    if(tieneSilla){
        while(cantActual>3 || cantMant >0 || cantInve>0){
            this.wait();
        }
        capacidad=30;
        cantDisc++; //me sirva saber cuantos hay para poder cambiar la capacidad de la sala
        cantActual++;
        System.out.println(" ENTRA visitante "+Thread.currentThread().getName()+", SI TENGO silla (capacidad: "+capacidad+")");
        System.out.println(" visitantes: "+cantVisi+" discapacitados: "+cantDisc+" mantenimiento: "+cantMant+" investigadores: "+cantInve);
    }else{
        while(cantActual >capacidad && cantMant >0 && cantInve>0 ){
            this.wait();
        }
        System.out.println(" ENTRA  visitante "+Thread.currentThread().getName()+", NO TENGO silla (capacidad: "+capacidad+")");
        cantVisi++;
        cantActual++;
         System.out.println(" visitantes: "+cantVisi+" discapacitados: "+cantDisc+" mantenimiento: "+cantMant+" investigadores: "+cantInve);
    }
}

public synchronized void entrarMantenimiento() throws InterruptedException{
    System.out.println(" soy de mantenimiento "+Thread.currentThread().getName()+" dejenme barrer");
    while(cantMant >capacidad || cantInve>0 || cantVisi>0 || cantDisc>0){
        this.wait();
    } 
    cantMant++;
    cantActual++;
     System.out.println(" ENTRA  mantenimiento "+Thread.currentThread().getName());
     System.out.println(" visitantes: "+cantVisi+" discapacitados: "+cantDisc+" mantenimiento: "+cantMant+" investigadores: "+cantInve);
    }

public synchronized void entrarInvestigador() throws InterruptedException{
    System.out.println(" soy investigador "+Thread.currentThread().getName()+" dejenme barrer");
    while(cantActual>0){
        this.wait();
    }
    cantInve++;
    cantActual++;
     System.out.println(" ENTRA  investigador "+Thread.currentThread().getName());
     System.out.println(" visitantes: "+cantVisi+" discapacitados: "+cantDisc+" mantenimiento: "+cantMant+" investigadores: "+cantInve);
}




}
