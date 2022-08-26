
package procesos;
import datos.Post;
import javafx.concurrent.Task;
import modelo.Cola;
import modelo.Orquestador;
import static modelo.Tools.*;

/**
* En esta clase se crea la tarea de actualizar el html de Orquestador.
* @author isabella.duran@uao.edu.co Isabella Duran Nagles Código 2210296
* @author jose.escobar@uao.edu.co Jose David Escobar Código 2210172
* @author laura.riascos@uao.edu.co Laura C. Riascos Hernández Código 2211185
* @author juan_jose.viveros@uao.edu.co Juan J. Viveros Delgado Código 2210208
* @date 25 Agosto 2022
* @version 1.0
*/
public class OrquestadorTask extends Task<String>{
    Cola<Post> colaP;
    String name;
    Orquestador orq;
    
    /**
    * Constructor de OrquestadorTask.
    * @param cola cola con objetos de la clase post.
    * @param orques objeto de la clase orquestador.
    */      
    public OrquestadorTask(Cola<Post> cola, Orquestador orques){
        this.colaP = cola;
        this.orq = orques;
        this.name = orq.getTitle();
    }
    
   /**
    * Metodo implementado de la clase Task, este ejecuta la tarea.
    * @return cadena de texto con el cuerpo html del orquestador.
    */     
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
