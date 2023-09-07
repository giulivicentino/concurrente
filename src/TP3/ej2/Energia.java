package TP3.ej2;

public class Energia {
    private int energia = 10;
    
    public Energia(){
        
    }
    
    public int getEnergia(){
        return energia;
    }
    
    public void hacerAlgo(int unaEnergia){
        energia = energia + unaEnergia;
    }
}
