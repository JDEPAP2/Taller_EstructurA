/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;
import modelo.Orquestador;

/**
 *
 * @author jose.escobar
 */
public class ActualizarReporte extends Thread{
    
    Orquestador orq[] = new Orquestador[3];
    
    public void hola(Orquestador orq[]){
        for (int i = 0; i < orq.length; i++) {
            Orquestador orquestador = orq[i];
            this.orq[i] = orq[i];
        }
    }
    
    @Override
    public void run(){
        try{
            for (int i = 0; i < 4; i++) {
                System.out.println("hilo3");
                Thread.sleep(6000);                
            }

        }catch(InterruptedException e){
            System.out.println("w");
        }        
    }    
}
