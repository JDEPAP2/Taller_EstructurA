/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;
import datos.Post;
import javafx.concurrent.Task;
import modelo.Cola;
import modelo.Orquestador;
import static modelo.Tools.*;

/**
 *
 * @author PC
 */
public class OrquestadorTask extends Task<String>{
    Cola<Post> colaP;
    
    public OrquestadorTask(Cola<Post> cola){
        this.colaP = cola;
    }
    
    @Override
    protected String call() throws Exception{
        Orquestador orq[] = new Orquestador[3];
        orq[0] = generarOrquestador();
        orq[1] = generarOrquestador();
        orq[2] = generarOrquestador();
        
        while(!this.isCancelled()){
                if(orq[0].getState().equals("Disponible")){
                    Post elemento = colaP.desencolar();
                    orq[0].procesarPost(elemento);
                    long tiempo = Integer.parseInt(orq[0].getTiempopOrq());
                    countOrq(tiempo);
                    orq[0].reporteOrq(elemento);
                }
                else if (orq[1].getState().equals("Disponible")){
                    Post elemento = colaP.desencolar();
                    orq[1].procesarPost(elemento);
                }
                else if (orq[2].getState().equals("Disponible")){
                    Post elemento = colaP.desencolar();
                    orq[2].procesarPost(elemento);
                    long tiempo = Integer.parseInt(orq[2].getTiempopOrq());
                    countOrq(tiempo);
                    orq[2].reporteOrq(elemento);
                }
                                
            }
        return colaAHtml(colaP);
    }

    
}
