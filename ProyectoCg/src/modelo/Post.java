/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author PC
 */
public class Post {
    String usuario, fecha, contenido, tiempoP;

    public Post() {
        
    }

    public Post(String usuario, String fecha, String contenido, String tiempoP) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.contenido = contenido;
        this.tiempoP = tiempoP;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTiempoP() {
        return tiempoP;
    }

    public void setTiempoP(String tiempoP) {
        this.tiempoP = tiempoP;
    }

    @Override
    public String toString() {
        return "Post(" + "usuario:" + usuario + ", fecha:" + fecha + ", contenido:" + contenido + ", tiempoP:" + tiempoP + ')';
    }
    
    
    // creo que deberian ir en tools los siguientes metodos, pero son operaciones de los posts
    
    
    
    
}
