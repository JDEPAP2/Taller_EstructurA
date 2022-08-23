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
public class Orquestador {

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
    
}
