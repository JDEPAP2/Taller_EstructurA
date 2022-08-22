/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;
import datos.Post;
import modelo.Cola;
import static modelo.Tools.*;
/**
 *
 * @author jose.escobar
 */
public class ActualizarCola extends Thread{
    @Override
    public void run(){
        try{
            Cola<Post> colaP = new Cola<>();
            while(this.isAlive()){
                Cola<Post> colaAux = crearPosts();                
                while (!colaAux.estaVacia()){
                    Post elemento = colaAux.desencolar();                   
                    colaP.encolar(elemento);
                }
                Thread.sleep(3000);
                System.out.println(colaP);
            }
            

        }catch(InterruptedException e){
            System.out.println("aaaaaa");
        }
    }
}
