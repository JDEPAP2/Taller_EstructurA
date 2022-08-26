
package procesos;
import javafx.concurrent.Task;
import modelo.Cola;
import datos.Post;
import static modelo.Tools.*;

/**
* En esta clase se crea la tarea de actualizar el html de Cola.
* @author isabella.duran@uao.edu.co Isabella Duran Nagles Código 2210296
* @author jose.escobar@uao.edu.co Jose David Escobar Código 2210172
* @author laura.riascos@uao.edu.co Laura C. Riascos Hernández Código 2211185
* @author juan_jose.viveros@uao.edu.co Juan J. Viveros Delgado Código 2210208
* @date 25 Agosto 2022
* @version 1.0
*/
public class ColaTask extends Task<String>{
    Cola<Post> colaP;
    
    /**
    * Constructor de ColaTask.
    * @param cola cola con objetos de la clase post.
    */     
    public ColaTask(Cola<Post> cola) {
        this.colaP = cola;
    }
    
    /**
    * Metodo implementado de la clase Task, este ejecuta la tarea.
    * @return cadena de texto con el cuerpo html de la cola.
    */  
    @Override
    protected String call() throws Exception{
        while(!this.isCancelled()){
                Cola<Post> colaAux = crearPosts();                
                while (!colaAux.estaVacia()){
                    Post elemento = colaAux.desencolar();                   
                    colaP.encolar(elemento);
                }
                updateValue(colaAHtml(colaP));
                Thread.sleep(3000);
                
            }
        return colaAHtml(colaP);
    }
}
