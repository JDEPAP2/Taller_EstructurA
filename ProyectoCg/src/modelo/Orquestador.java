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

    private String state;
    long tiempoP, postsAtendidos, tiempoAtendido, tiempoPromedio, postMayor, postMenor;

    
    public Orquestador generarOrquestador(){
        String state = "Disponible";
        long tiempoP = "0";        
        long postsAtendidos = "0";
        long tiempoAtendido = "0";
        long tiempoPromedio = "0";
        long postMayor = "0";
        long postMenor = "0";
        
        return new Orquestador(state, tiempoP, postsAtendidos, tiempoAtendido, tiempoPromedio, postMayor, postMenor);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getTiempoP() {
        return tiempoP;
    }

    public void setTiempoP(long tiempoP) {
        this.tiempoP = tiempoP;
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

    public long getPostMayor() {
        return postMayor;
    }

    public void setPostMayor(long postMayor) {
        this.postMayor = postMayor;
    }

    public long getPostMenor() {
        return postMenor;
    }

    public void setPostMenor(long postMenor) {
        this.postMenor = postMenor;
    }

    public Orquestador(String state, long tiempoP, long postsAtendidos, long tiempoAtendido, long tiempoPromedio, long postMayor, long postMenor) {
        this.state = state;
        this.tiempoP = tiempoP;
        this.postsAtendidos = postsAtendidos;
        this.tiempoAtendido = tiempoAtendido;
        this.tiempoPromedio = tiempoPromedio;
        this.postMayor = postMayor;
        this.postMenor = postMenor;
    }

}
