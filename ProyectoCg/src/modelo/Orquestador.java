/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import datos.Post;
/**
* En esta clase se crean orquestadores, se administra su estado y genera su reporte.
* @author isabella.duran@uao.edu.co Isabella Duran Nagles Código 2210296
* @author jose.escobar@uao.edu.co Jose David Escobar Código 2210172
* @author laura.riascos@uao.edu.co Laura C. Riascos Hernández Código 2211185
* @author juan_jose.viveros@uao.edu.co Juan J. Viveros Delgado Código 2210208
* @date 25 Agosto 2022
* @version 1.0
*/
public class Orquestador {

    private String state, tiempopOrq, title;
    private long postsAtendidos, tiempoAtendido, tiempoPromedio;
    private Post postMayor, postMenor;

    /**
    * Este metodo actualiza los atributos de tiempoP y state del con base en el Post que el orquestador que recibe.
    * @param post es un objeto de la clase Post.
    */
    public void procesarPost ( Post post ){
        setTiempopOrq(post.getTiempoP());
        setState("Ocupado"); 
    }
    
    /**
    * Este metodo actualiza los demas atributos que no son modificados por procesarPost y es invocado cuando el objeto Post termina de ser procesado.
    * @param post es un objeto de la clase Post.
    */
    public void reporteOrq ( Post post ){
        long tiempoProm = 0;
        if (postsAtendidos != 0){
            tiempoProm = getTiempoAtendido() / getPostsAtendidos();
        }                  
        long tiempoAt = this.tiempoAtendido + Long.parseLong(post.getTiempoP());
        if(Long.parseLong(post.getTiempoP()) > Long.parseLong(this.postMayor.getTiempoP())){
            setPostMayor(post);
        }
        
        if(Long.parseLong(getPostMenor().getTiempoP()) == 0){            
            setPostMenor(getPostMayor());
        }
        
        if(Long.parseLong(post.getTiempoP()) < Long.parseLong(this.postMenor.getTiempoP())){
            setPostMenor(post);
        }
        
        setTiempoAtendido(tiempoAt);
        setTiempoPromedio(tiempoProm);
        setPostsAtendidos(this.getPostsAtendidos() + 1);
        setState("Disponible");
    }
    
    /**
    * Este metodo retorna el valor del atributo title.
    * @return valor del atributo title.
    */    
    public String getTitle() {
        return title;
    }

    /**
    * Este metodo modifica el valor del atributo title.
    * @param title valor actualizado del atributo title.
    */    
    public void setTitle(String title) {
        this.title = title;
    }

    /**
    * Este metodo retorna el valor del atributo state.
    * @return valor del atributo state.
    */    
    public String getState() {
        return state;
    }
    
    /**
    * Este metodo modifica el valor del atributo state.
    * @param state valor actualizado del atributo state.
    */
    public void setState(String state) {
        this.state = state;
    }

    /**
    * Este metodo retorna el valor del atributo tiempopOrq.
    * @return valor del atributo tiempopOrq.
    */
    public String getTiempopOrq() {
        return tiempopOrq;
    }

    /**
    * Este metodo modifica el valor del atributo tiempopOrq.
    * @param tiempoP valor actualizado del atributo tiempopOrq.
    */
    public void setTiempopOrq(String tiempoP) {
        this.tiempopOrq = tiempoP;
    }

    /**
    * Este metodo retorna el valor del atributo postsAtendidos.
    * @return valor del atributo postsAtendidos.
    */    
    public long getPostsAtendidos() {
        return postsAtendidos;
    }
    
    /**
    * Este metodo modifica el valor del atributo postsAtendidos.
    * @param postsAtendidos valor actualizado del atributo postsAtendidos.
    */
    public void setPostsAtendidos(long postsAtendidos) {
        this.postsAtendidos = postsAtendidos;
    }
    
    /**
    * Este metodo retorna el valor del atributo tiempoAtendido.
    * @return valor del atributo tiempoAtendido.
    */    
    public long getTiempoAtendido() {
        return tiempoAtendido;
    }

    /**
    * Este metodo modifica el valor del atributo tiempoAtendido.
    * @param tiempoAtendido valor actualizado del atributo tiempoAtendido.
    */
    public void setTiempoAtendido(long tiempoAtendido) {
        this.tiempoAtendido = tiempoAtendido;
    }
    
    /**
    * Este metodo retorna el valor del atributo tiempoPromedio.
    * @return valor del atributo tiempoPromedio.
    */  
    public long getTiempoPromedio() {
        return tiempoPromedio;
    }

    /**
    * Este metodo modifica el valor del atributo tiempoPromedio.
    * @param tiempoPromedio valor actualizado del atributo tiempoPromedio.
    */
    public void setTiempoPromedio(long tiempoPromedio) {
        this.tiempoPromedio = tiempoPromedio;
    }
    
    /**
    * Este metodo retorna el valor del atributo postMayor.
    * @return valor del atributo postMayor.
    */  
    public Post getPostMayor() {
        return postMayor;
    }

    /**
    * Este metodo modifica el valor del atributo postMayor.
    * @param postMayor valor actualizado del atributo postMayor.
    */    
    public void setPostMayor(Post postMayor) {
        this.postMayor = postMayor;
    }
    
    /**
    * Este metodo retorna el valor del atributo postMenor.
    * @return valor del atributo postMenor.
    */  
    public Post getPostMenor() {
        return postMenor;
    }

    /**
    * Este metodo modifica el valor del atributo postMenor.
    * @param postMenor  valor actualizado del atributo postMenor.
    */    
    public void setPostMenor(Post postMenor) {
        this.postMenor = postMenor;
    }
    
    
    /**
    * Constructor de la clase Orquestador.
    * @param state cadena de texto que describe el estado de lo orquestador, solo puede ser "Ocupado" o "Disponible".
    * @param tiempopOrq cadena de texto que describe el tiempo que el orquestador debe quedarse con cada Post.
    * @param title cadena de texto con el nombre del Orquestador.
    * @param postsAtendidos entero con el valor de post procesados por el orquestador.
    * @param tiempoAtendido entero con el valor total del tiempo en el que proceso post.
    * @param tiempoPromedio entero con el valor del tiempo promedio del tiempo que se demora con cada post.
    * @param postMayor objeto de la clase post que ha sido procesado en el menor tiempo.
    * @param postMenor objeto de la clase post que ha sido procesado en el mayor tiempo.
    */ 
    public Orquestador(String state, String tiempopOrq, String title, long postsAtendidos, long tiempoAtendido, long tiempoPromedio, Post postMayor, Post postMenor) {
        this.state = state;
        this.tiempopOrq = tiempopOrq;
        this.title = title;
        this.postsAtendidos = postsAtendidos;
        this.tiempoAtendido = tiempoAtendido;
        this.tiempoPromedio = tiempoPromedio;
        this.postMayor = postMayor;
        this.postMenor = postMenor;
    }
    
    /**
    * Este metodo organiza en una cadena de texto el objeto orquestador con sus atributos.
    * @return cadena de texto del objeto con Orquestador.
    */  
    @Override
    public String toString() {
        return "Orquestador{" + "state=" + state + ", tiempopOrq=" + tiempopOrq + ", postsAtendidos=" + postsAtendidos + ", tiempoAtendido=" + tiempoAtendido + ", tiempoPromedio=" + tiempoPromedio + ", postMayor=" + postMayor + ", postMenor=" + postMenor + '}';
    }
    
    

}
