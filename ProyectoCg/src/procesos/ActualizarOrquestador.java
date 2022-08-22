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
        Orquestador orq[] = new Orquestador[3];
        orq[0] = generarOrquestador();
        orq[1] = generarOrquestador();
        orq[2] = generarOrquestador();
        
//        try{
            while(this.isAlive()){
                if(orq[0].getState().equals("Disponible")){
                    Post elemento = colaP.desencolar();
                    orq[0].procesarPost(elemento);
                    long tiempo = Integer.parseInt(orq[0].getTiempopOrq());
                    countOrq(tiempo);
                    orq[0].reporteOrq(elemento);
                    System.out.println(this.getName() + orq[0].toString());
                }
                else if (orq[1].getState().equals("Disponible")){
                    Post elemento = colaP.desencolar();
                    orq[1].procesarPost(elemento);
                    long tiempo = Integer.parseInt(orq[1].getTiempopOrq());
                    countOrq(tiempo);
                    orq[1].reporteOrq(elemento);
                    System.out.println(this.getName() + orq[1].toString());
                }
                else{
                    Post elemento = colaP.desencolar();
                    orq[2].procesarPost(elemento);
                    long tiempo = Integer.parseInt(orq[2].getTiempopOrq());
                    countOrq(tiempo);
                    orq[2].reporteOrq(elemento);
                    System.out.println(this.getName() + orq[2].toString());
                }
                                
            }
            
//        }catch(InterruptedException e){
//            System.out.println("w");
//        }              
  
    }    
}
