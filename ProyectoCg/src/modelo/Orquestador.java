/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import datos.Post;
/**
 *
 * @author PC
 */
public class Orquestador {

    private String state, tiempopOrq;
    private long postsAtendidos, tiempoAtendido, tiempoPromedio;
    private Post postMayor, postMenor;

    
    public void procesarPost ( Post post ){
        setTiempopOrq(post.getTiempoP());
        setState("Ocupado");
    }
    
    public void reporteOrq ( Post post ){
        long tiempoProm = getPostsAtendidos() / getTiempoAtendido();
        long tiempoAt = tiempoAtendido + Long.parseLong(post.getTiempoP());
        
        if(Long.parseLong(post.getTiempoP()) > Long.parseLong(postMayor.getTiempoP())){
            setPostMayor(post);
        }
        
        if(Long.parseLong(post.getTiempoP()) < Long.parseLong(postMenor.getTiempoP())){
            setPostMenor(post);
        }
        
        setTiempoAtendido(tiempoAt);
        setTiempoPromedio(tiempoProm);
        setPostsAtendidos(postsAtendidos++);
    }   

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTiempopOrq() {
        return tiempopOrq;
    }

    public void setTiempopOrq(String tiempoP) {
        this.tiempopOrq = tiempoP;
    }

    public long getPostsAtendidos() {
        return postsAtendidos;
    }

    public void setPostsAtendidos(long postsAtendidos) {
        this.postsAtendidos = postsAtendidos;
    }

    public long getTiempoAtendido() {
        return tiempoAtendido;
    }

    public void setTiempoAtendido(long tiempoAtendido) {
        this.tiempoAtendido = tiempoAtendido;
    }

    public long getTiempoPromedio() {
        return tiempoPromedio;
    }

    public void setTiempoPromedio(long tiempoPromedio) {
        this.tiempoPromedio = tiempoPromedio;
    }

    public Post getPostMayor() {
        return postMayor;
    }

    public void setPostMayor(Post postMayor) {
        this.postMayor = postMayor;
    }

    public Post getPostMenor() {
        return postMenor;
    }

    public void setPostMenor(Post postMenor) {
        this.postMenor = postMenor;
    }

    public Orquestador(String state, String tiempopOrq, long postsAtendidos, long tiempoAtendido, long tiempoPromedio, Post postMayor, Post postMenor) {
        this.state = state;
        this.tiempopOrq = tiempopOrq;
        this.postsAtendidos = postsAtendidos;
        this.tiempoAtendido = tiempoAtendido;
        this.tiempoPromedio = tiempoPromedio;
        this.postMayor = postMayor;
        this.postMenor = postMenor;
    }

}
