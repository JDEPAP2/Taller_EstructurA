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
public class Orquestador {

<<<<<<< HEAD
    private String state, tiempopOrq;
    private long postsAtendidos, tiempoAtendido, tiempoPromedio;
    private Post postMayor, postMenor;

=======
    private String state, tiempoP, postsAtendidos, tiempoAtendido, tiempoPromedio, postMayor, postMenor;

    public Orquestador(String state, String tiempoP, String postsAtendidos, String tiempoAtendido, String tiempoPromedio, String postMayor, String postMenor) {
        this.state = state;
        this.tiempoP = tiempoP;
        this.postsAtendidos = postsAtendidos;
        this.tiempoAtendido = tiempoAtendido;
        this.tiempoPromedio = tiempoPromedio;
        this.postMayor = postMayor;
        this.postMenor = postMenor;
    }
    
    public static Orquestador generarOrquestador(){
        String state = "Disponible";
        String tiempoP = "0";        
        String postsAtendidos = "0";
        String tiempoAtendido = "0";
        String tiempoPromedio = "0";
        String postMayor = "0";
        String postMenor = "0";
        
        return new Orquestador(state, tiempoP, postsAtendidos, tiempoAtendido, tiempoPromedio, postMayor, postMenor);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTiempoP() {
        return tiempoP;
    }

    public void setTiempoP(String tiempoP) {
        this.tiempoP = tiempoP;
    }

    public String getPostsAtendidos() {
        return postsAtendidos;
    }

    public void setPostsAtendidos(String postsAtendidos) {
        this.postsAtendidos = postsAtendidos;
    }

    public String getTiempoAtendido() {
        return tiempoAtendido;
    }

    public void setTiempoAtendido(String tiempoAtendido) {
        this.tiempoAtendido = tiempoAtendido;
    }

    public String getTiempoPromedio() {
        return tiempoPromedio;
    }

    public void setTiempoPromedio(String tiempoPromedio) {
        this.tiempoPromedio = tiempoPromedio;
    }

    public String getPostMayor() {
        return postMayor;
    }

    public void setPostMayor(String postMayor) {
        this.postMayor = postMayor;
    }

    public String getPostMenor() {
        return postMenor;
    }

    public void setPostMenor(String postMenor) {
        this.postMenor = postMenor;
    }

    @Override
    public String toString() {
        return "Orquestador{" + "state=" + state + ", tiempoP=" + tiempoP + ", postsAtendidos=" + postsAtendidos + ", tiempoAtendido=" + tiempoAtendido + ", tiempoPromedio=" + tiempoPromedio + ", postMayor=" + postMayor + ", postMenor=" + postMenor + '}';
    }
>>>>>>> 6b959026e84f639c3263c4a18ec7893fc2b40c40
    
    public Orquestador generarOrquestador(){
        
        Post post = new Post("0", "0", "0", "0");
        String state = "Disponible";
        String tiempopOrq = "0";        
        long postsAtendidos = 0;
        long tiempoAtendido = 0;
        long tiempoPromedio = 0;
        Post postMayor = post;
        Post postMenor = post;
        
        return new Orquestador(state, tiempopOrq, postsAtendidos, tiempoAtendido, tiempoPromedio, postMayor, postMenor);
    }
    
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
