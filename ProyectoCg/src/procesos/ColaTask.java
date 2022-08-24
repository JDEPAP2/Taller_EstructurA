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
 *
 * @author PC
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
