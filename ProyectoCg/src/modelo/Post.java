/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * Descripción:
 * @author isabella.duran@uao.edu.co Isabella Duran Cód. 2210296
 * @author jose.escobar@uao.edu.co Jose D. Escobar Cód. 2210172
 * @author laura.riascos@uao.edu.co Laura C. Riascos Cód. 2211185
 * @author Juan_jose.viveros@uao.edu.co Juan J. Viveros Cód. 2210208
 * @date 25 de Agosto de 2022
 * @version 1.8
 */
public class Post {
    private String usuario, fecha, contenido, tiempoP;
    
    /**
    * Constructor vacio.
    */
    public Post() {
        
    }
    
    /**
    * Constructor del objeto post.
    * @param usuario atributo perteneciente al nombre del usuario que genera el post.
    * @param fecha atributo perteneciente a la fecha en la cual se genera el post.
    * @param contenido atributo perteneciente al contenido del post que se va a generar.
    * @param tiempoP atributo perteneciente al tiempo que necesita ser procesado el post que se va a generar.
    */
    public Post(String usuario, String fecha, String contenido, String tiempoP) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.contenido = contenido;
        this.tiempoP = tiempoP;
    }
    
    /**
    * Recupera el valor del atributo usuario.
    * @return valor del atributo usuario.
    */
    public String getUsuario() {
        return usuario;
    }
    
    /**
    * Modifica el valor del atributo usuario.
    * @param usuario nuevo valor del atributo usuario.
    */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    /**
    * Recupera el valor del atributo fecha.
    * @return valor del atributo fecha.
    */
    public String getFecha() {
        return fecha;
    }
    
    /**
    * Modifica el valor del atributo fecha.
    * @param fecha nuevo valor del atributo fecha.
    */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    /**
    * Recupera el valor del atributo contenido.
    * @return valor del atributo contenido.
    */
    public String getContenido() {
        return contenido;
    }
    
    /**
    * Modifica el valor del atributo contenido.
    * @param contenido nuevo valor del atributo contenido.
    */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    /**
    * Recupera el valor del atributo tiempoP.
    * @return valor del atributo tiempoP.
    */
    public String getTiempoP() {
        return tiempoP;
    }
    
    /**
    * Modifica el valor del atributo tiempoP.
    * @param tiempoP nuevo valor del atributo tiempoP.
    */
    public void setTiempoP(String tiempoP) {
        this.tiempoP = tiempoP;
    }
    
    /**
    * Genera una cadena de texto del objeto.
    * @return cadena de tipo texto, con los atributos del objeto de la Clase Post.
    */
    @Override
    public String toString() {
        return "Post(" + "usuario:" + usuario + ", fecha:" + fecha + ", contenido:" + contenido + ", tiempoP:" + tiempoP + ')';
    }
    
}
