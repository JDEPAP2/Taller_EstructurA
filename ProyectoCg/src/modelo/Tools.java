/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import datos.Post;
import static modelo.OperacionesPost.*;
import static procesos.Contador.formatSeconds;
import modelo.Orquestador;
/**
 *
 * @author PC
 */
public class Tools {
    
    public static String orquestadoresAHtml(Orquestador orq){
        
        StringBuilder sb = new StringBuilder("<html>");
        
//        sb.append("<noscript>").append("</noscript>");
        
        sb.append("<table>");
        sb.append("<table align=\"center\" border=\"1\" style=\"font-family: sans-serif\">");
            sb.append("<tr>").append("<tr align=\"center\" style=\"background-color: rgb(217, 208, 222)\">")
                .append("<td>").append("<small><b>").append(" ").append(orq.getTitle()).append(" ").append("</b><small>").append("</td>").append("</tr>");        
            sb.append("<tr>").append("<tr>")
                .append("<td>").append("<small>").append(countOrq(Long.parseLong(orq.getTiempopOrq()))).append("</small>").append("</td>").append("</tr>");            
                    if (orq.getState().equals("Ocupado")){
                        sb.append("<tr>").append("<tr style=\"color: red\">")
                        .append("<td>").append("<small>").append(orq.getState()).append("</small>").append("</td>").append("</tr><br>");
                    }else{
                        sb.append("<tr>").append("<tr style=\"color: green\">")
                        .append("<td>").append("<small>").append(orq.getState()).append("</small>").append("</td>").append("</tr><br>");
                    }
                
            
//        }
                        
        sb.append("</table>");
        sb.append("</html>");
        
        return sb.toString(); 
    }
    
    
    public static String colaAHtml(Cola<Post> laCola){
        Cola<Post> colaD = OperacionesCola.colaDuplicada(laCola);
        
        StringBuilder sb = new StringBuilder("<html>");
        
        sb.append("<noscript>").append("</noscript>");
        
        sb.append("<table>");        
        sb.append("<table align=\"center\" border=\"1\" style=\"font-family: sans-serif\">");
        
        sb.append("<tr>").append("<td align='center' style=\"background-color: rgb(217, 208, 222)\">").append("<b>Cola</b>").append("</td>").append("</tr>");
        
        while(!colaD.estaVacia()){
            Post e = colaD.desencolar();
            sb.append("<tr>").append("<td>").append("<div>")
                    .append("<b>").append(e.getUsuario()).append("</b><br>")
                    .append("<small>").append("Contenido: " + e.getContenido()).append("</small><br>")
                    .append("<small>").append("Fecha: " + e.getFecha()).append("</small><br>")
                    .append("<small>").append("Tiempo de Procesamiento: " + e.getTiempoP()).append("</small><br>")
                    .append("</div>").append("</td>").append("</tr>");
        }
        
        sb.append("</table>");
        sb.append("</html>");
                
        return sb.toString();    
    }
    
        
    public static String convertirReporteAHtml(Orquestador orq[]){
        
        StringBuilder sb = new StringBuilder("<html>");
        
        sb.append("<noscript>").append("</noscript>");
        
        sb.append("<table align=\"center\" border=\"1\" style=\"font-family: sans-serif\">");        
        
        sb.append("<tr align='center' style=\"background-color: rgb(217, 208, 222)\">")
                .append("<td>").append("<b>").append(orq[0].getTitle()).append("</b>").append("</td>")
                .append("<td>").append("<b>").append(orq[1].getTitle()).append("</b>").append("</td>")
                .append("<td>").append("<b>").append(orq[2].getTitle()).append("</b>").append("</td>")
                .append("</tr>");
        
        sb.append("<tr>")
                .append("<td>").append("<small>").append("Cantidad Total de Post: ").append(orq[0].getPostsAtendidos()).append("</small>").append("</td>")
                .append("<td>").append("<small>").append("Cantidad Total de Post: ").append(orq[1].getPostsAtendidos()).append("</small>").append("</td>")
                .append("<td>").append("<small>").append("Cantidad Total de Post: ").append(orq[2].getPostsAtendidos()).append("</small>").append("</td>")
                .append("</tr>");
        
        sb.append("<tr>")
                .append("<td>").append("<small>").append("Tiempo Total: ").append(orq[0].getTiempoAtendido()).append("</small>").append("</td>")
                .append("<td>").append("<small>").append("Tiempo Total: ").append(orq[1].getTiempoAtendido()).append("</small>").append("</td>")
                .append("<td>").append("<small>").append("Tiempo Total: ").append(orq[2].getTiempoAtendido()).append("</small>").append("</td>")
                .append("</tr>");
        
        sb.append("<tr>")
                .append("<td>").append("<small>").append("Tiempo Promedio: ").append(orq[0].getTiempoPromedio()).append("</small>").append("</td>")
                .append("<td>").append("<small>").append("Tiempo Promedio: ").append(orq[1].getTiempoPromedio()).append("</small>").append("</td>")
                .append("<td>").append("<small>").append("Tiempo Promedio: ").append(orq[2].getTiempoPromedio()).append("</small>").append("</td>")
                .append("</tr>");
        
        sb.append("<tr>")
                .append("<td>").append("<small>").append("Post en el que se demoro más tiempo: ").append(orq[0].getPostMayor()).append("</small>").append("</td>")
                .append("<td>").append("<small>").append("Post en el que se demoro más tiempo: ").append(orq[1].getPostMayor()).append("</small>").append("</td>")
                .append("<td>").append("<small>").append("Post en el que se demoro más tiempo: ").append(orq[2].getPostMayor()).append("</small>").append("</td>")
                .append("</tr>");
        
        sb.append("<tr>")
                .append("<td>").append("<small>").append("Post en el que se demoro menos tiempo: \n").append(orq[0].getPostMenor()).append("</small>").append("</td>")
                .append("<td>").append("<small>").append("Post en el que se demoro menos tiempo:  \n").append(orq[1].getPostMenor()).append("</small>").append("</td>")
                .append("<td>").append("<small>").append("Post en el que se demoro menos tiempo:  \n").append(orq[2].getPostMenor()).append("</small>").append("</td>")
                .append("</tr>");
        
                sb.append("<tr>")
                .append("<td colspan=\"3\">").append("<small>").append("Orquestador más demorado: ").append(orqMasDemorado(orq).getTitle()).append("</small>").append("</td>")
                .append("</tr>");
                
        sb.append("</table>");
        
//      sb.append("<h1 align=\"center\">").append("Cola Vacia").append("</h1>");
        sb.append("</html>");
        
        return sb.toString();    
    }
    
    public static Orquestador orqMasDemorado(Orquestador orq[]){
        if(orq[0].getTiempoAtendido() > orq[1].getTiempoAtendido()){
            return orq[0];
        } else if ((orq[1].getTiempoAtendido() > orq[2].getTiempoAtendido())){
            return orq[1];
        } else {
            return orq[2];
        }
    }
    
    public static Cola<Post> crearPosts(){
        int num = (int) ( Math.random()*(1 + 6));
        while (num == 0){
            num = (int) ( Math.random()*(1 + 6));
        }
        Cola<Post> colaAux = new Cola<>();
        for (int i = 0; i < num; i++) {            
            colaAux.encolar(generarPost());            
        }
        return colaAux;
    }
    
    public static Orquestador generarOrquestador(String name){
        
        
        Post post = new Post("0", "0", "0", "0");
        String state = "Disponible";
        String tiempopOrq = "0";        
        long postsAtendidos = 0;
        long tiempoAtendido = 0;
        long tiempoPromedio = 0;
        Post postMayor = post;
        Post postMenor = post;
        
        return new Orquestador(state, tiempopOrq, name, postsAtendidos, tiempoAtendido, tiempoPromedio, postMayor, postMenor);
    }
    
        public static String countOrq(long time) {
        long i = time;
        boolean contando = true;
        String contador = "00:00:00";
        contador = formatSeconds(i); 
        return contador;
    }
    
    public static String formatSeconds(long timeInSeconds) {
        long hours = timeInSeconds / 3600;
        long secondsLeft = timeInSeconds - hours * 3600;
        long minutes = secondsLeft / 60;
        long seconds = secondsLeft - minutes * 60;
        
        String formattedTime = "";
        if (hours < 10) {
            formattedTime += "0";
        }
        formattedTime += hours + ":";
        
        if (minutes < 10) {
            formattedTime += "0";
        }
        formattedTime += minutes + ":";
        
        if (seconds < 10) {
            formattedTime += "0";
        }
        formattedTime += seconds;
        
        return formattedTime;
    }
}    
    
