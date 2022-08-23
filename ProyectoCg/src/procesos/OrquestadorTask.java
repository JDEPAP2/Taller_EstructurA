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
    Orquestador orq = generarOrquestador("Orquestador1");
    
    public OrquestadorTask(Cola<Post> cola){
        this.colaP = cola;

    }
    
    @Override
    protected String call() throws Exception{
        Thread.sleep(9000);
        while(!this.isCancelled()){
                if(orq.getState().equals("Disponible")){
                    Post elemento = colaP.desencolar();
                    orq.procesarPost(elemento);
                    int tiempo = Integer.parseInt(orq.getTiempopOrq());
                    while(tiempo != 0){
                        updateValue(orquestadoresAHtml(orq));                        
                        tiempo = tiempo -1;
                        orq.setTiempopOrq(""+tiempo);
                        Thread.sleep(1000);
                    }
                    orq.reporteOrq(elemento);
                    updateValue(orquestadoresAHtml(orq));
                    Thread.sleep(1000);
                    
                }        
        }return orquestadoresAHtml(orq);
    }
    

    
}
