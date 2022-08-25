/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;
import javafx.concurrent.Task;
import modelo.Cola;
import datos.Post;
import static modelo.Tools.*;
/**
* En esta clase se encarga de actualizar el cuerpo HTML de la cola.
* @author isabella.duran@uao.edu.co Isabella Duran Nagles Código 2210296
* @author jose.escobar@uao.edu.co Jose David Escobar Código 2210172
* @author laura.riascos@uao.edu.co Laura C. Riascos Hernández Código 2211185
* @author juan_jose.viveros@uao.edu.co Juan J. Viveros Delgado Código 2210208
* @date 25 Agosto 2022
* @version 1.0
*/
public class ColaTask extends Task<String>{
    Cola<Post> colaP;
    public ColaTask(Cola<Post> cola) {
        this.colaP = cola;
    }
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
