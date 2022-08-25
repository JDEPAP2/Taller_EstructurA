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
    String name;
    Orquestador orq;
    
    public OrquestadorTask(Cola<Post> cola, Orquestador orques){
        this.colaP = cola;
        this.orq = orques;
        this.name = orq.getTitle();
    }
    
    @Override
    protected String call(){
        
        try{
            if(name.equals("Orquestador 1")){
                Thread.sleep(9000);
        }else if(name.equals("Orquestador 2")){
                Thread.sleep(9200);
        }else{
                Thread.sleep(9400);            
        }
        while(!this.isCancelled()){
                if(orq.getState().equals("Disponible")){
                    Post elemento = colaP.desencolar();
                    orq.procesarPost(elemento);
                    int tiempo = Integer.parseInt(orq.getTiempopOrq());
                    updateValue(orquestadoresAHtml(orq));
                    while(tiempo != 0){
                        Thread.sleep(1000);
                        tiempo--;
                        orq.setTiempopOrq(""+ tiempo);
                        updateValue(orquestadoresAHtml(orq));    
                    }
                    orq.setTiempopOrq(""+ tiempo);
                    orq.reporteOrq(elemento);
                    updateValue(orquestadoresAHtml(orq));
                    Thread.sleep(1000);
                }
        }}catch(Exception e){
            System.out.println("");
        }
        return orquestadoresAHtml(orq);
    }
    

    
}
