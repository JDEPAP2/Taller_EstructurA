/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;
import datos.Post;
import modelo.Cola;
import modelo.Orquestador;
import static modelo.Tools.*;
/**
 *
 * @author jose.escobar
 */
public class ActualizarOrquestador extends Thread{
    Cola<Post> colaP;
    
    public void cola(Cola<Post> cola){
        this.colaP = cola;
    }
    public ActualizarOrquestador(String msg){
        super(msg);
    }
    public void esperar(){
        try{
            Thread.sleep(10000); 
            this.start();
        }catch(InterruptedException e){
            System.out.println("n");
        }

    }
    
    @Override
    public void run(){
        Orquestador orq = generarOrquestador();
//        try{
//            while(this.isAlive()){
                System.out.println(orq.getState());
                if(orq.getState().equals("Disponible")){
                    Post elemento = colaP.desencolar();
                    orq.procesarPost(elemento);
                    long tiempo = 1000 * Integer.parseInt(orq.getTiempopOrq());
                    orq.reporteOrq(elemento);
                }
                System.out.println(orq.toString());
//            }
            
//        }catch(InterruptedException e){
//            System.out.println("w");
//        }              
  
    }    
}
