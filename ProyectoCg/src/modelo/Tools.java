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
    
    public static String orquestadoresAHtml(){
        
        StringBuilder sb = new StringBuilder("<html>");
        
        sb.append("<noscript>").append("</noscript>");
        
        sb.append("<table>");
        sb.append("<table align=\"center\" border=\"1\" ");
        
        sb.append("<tr>").append("<tr style=\"background-color: rgb(217, 208, 222)\">")
                .append("<td>").append("<b>").append("Orquestador #01").append("</b>").append("</td>")
                .append("<td>").append("<b>").append("Orquestador #02").append("</b>").append("</td>")
                .append("<td>").append("<b>").append("Orquestador #03").append("</b>").append("</td>")
                .append("</tr>");
        
        sb.append("<tr>")
                .append("<td>").append("LLAMAR METODO QUE DEFINE ESTADO").append("</td>")
                .append("<td>").append("LLAMAR METODO QUE DEFINE ESTADO").append("</td>")
                .append("<td>").append("LLAMAR METODO QUE DEFINE ESTADO").append("</td>")
                .append("</tr>");
        
        sb.append("<tr>")
                .append("<td>").append("LLAMAR METODO TIEMPO RESTANTE").append("</td>")
                .append("<td>").append("LLAMAR METODO TIEMPO RESTANTE").append("</td>")
                .append("<td>").append("LLAMAR METODO TIEMPO RESTANTE").append("</td>")
                .append("</tr>");
        
        sb.append("</table>");
        sb.append("</html>");
        
        return sb.toString(); 
    }
    
    
    public static String colaAHtml(){
        
        StringBuilder sb = new StringBuilder("<html>");
        
        sb.append("<noscript>").append("</noscript>");
        
        sb.append("<table>");        
        sb.append("<table align=\"center\" border=\"1\">");
        
        sb.append("<tr>").append("<td>").append("USUARIO").append("</td>").append("</tr>")
                .append("<tr>").append("<td>").append("CONTENIDO").append("</td>").append("</tr>")
                .append("<tr>").append("<td>").append("FECHA").append("</td>").append("</tr>")
                .append("<tr>").append("<td>").append("TIEMPO PARA SER PROCESADOS").append("</td>").append("</tr>");
        
        sb.append("</table>");
        sb.append("</html>");
                
        return sb.toString();    
    }
    
        
    public static String convertirReporteAHtml(Orquestador orq[]){
        
        StringBuilder sb = new StringBuilder("<html>");
        
        sb.append("<noscript>").append("</noscript>");
        
        sb.append("<table>");
        sb.append("<table align=\"center\" border=\"1\" ");        
        
        sb.append("<tr>").append("<tr style=\"background-color: rgb(217, 208, 222)\">")
                .append("<td>").append("<b>").append(orq[0].getTitle()).append("</b>").append("</td>")
                .append("<td>").append("<b>").append(orq[1].getTitle()).append("</b>").append("</td>")
                .append("<td>").append("<b>").append(orq[2].getTitle()).append("</b>").append("</td>")
                .append("</tr>");
        
        sb.append("<tr>")
                .append("<td>").append("Cantidad Total de Post: " + orq[0].getPostsAtendidos()).append("</td>")
                .append("<td>").append("Cantidad Total de Post: " + orq[1].getPostsAtendidos()).append("</td>")
                .append("<td>").append("Cantidad Total de Post: " + orq[2].getPostsAtendidos()).append("</td>")
                .append("</tr>");
        
        sb.append("<tr>")
                .append("<td>").append("Tiempo Total: " + orq[0].getTiempoAtendido()).append("</td>")
                .append("<td>").append("Tiempo Total: " + orq[1].getTiempoAtendido()).append("</td>")
                .append("<td>").append("Tiempo Total: " + orq[2].getTiempoAtendido()).append("</td>")
                .append("</tr>");
        
        sb.append("<tr>")
                .append("<td>").append("Tiempo Promedio: " + orq[0].getTiempoPromedio()).append("</td>")
                .append("<td>").append("Tiempo Promedio: " + orq[1].getTiempoPromedio()).append("</td>")
                .append("<td>").append("Tiempo Promedio: " + orq[2].getTiempoPromedio()).append("</td>")
                .append("</tr>");
        
        sb.append("<tr>")
                .append("<td>").append("Post en el que se demoro más tiempo: " + orq[0].getPostMayor()).append("</td>")
                .append("<td>").append("Post en el que se demoro más tiempo: " + orq[1].getPostMayor()).append("</td>")
                .append("<td>").append("Post en el que se demoro más tiempo: " + orq[2].getPostMayor()).append("</td>")
                .append("</tr>");
        
        sb.append("<tr>")
                .append("<td>").append("Post en el que se demoro menos tiempo: " + orq[0].getPostMenor()).append("</td>")
                .append("<td>").append("Post en el que se demoro menos tiempo: " + orq[1].getPostMenor()).append("</td>")
                .append("<td>").append("Post en el que se demoro menos tiempo: " + orq[2].getPostMenor()).append("</td>")
                .append("</tr>");
        
                sb.append("<tr>")
                .append("<td colspan=\"3\">").append("Orquestador más demorado: " + orqMasDemorado(orq).getTitle()).append("</td>")
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
        int num = (int) ( Math.random()*(1 + 5));
        while (num == 0){
            num = (int) ( Math.random()*(1 + 5));
        }
        Cola<Post> colaAux = new Cola<>();
        for (int i = 0; i < num; i++) {            
            colaAux.encolar(generarPost());            
        }
        return colaAux;
    }
    
    public static Orquestador generarOrquestador(){
        
        int num = 0;
        
        Post post = new Post("0", "0", "0", "0");
        String state = "Disponible";
        String title = "Orquestador" + num++;
        String tiempopOrq = "0";        
        long postsAtendidos = 0;
        long tiempoAtendido = 0;
        long tiempoPromedio = 0;
        Post postMayor = post;
        Post postMenor = post;
        
        return new Orquestador(state, tiempopOrq, title, postsAtendidos, tiempoAtendido, tiempoPromedio, postMayor, postMenor);
    }
    
    public static void countOrq() {
        long i = 5;
        boolean contando = true;
        String contador = "00:00:00";
        try {
            while (i != -1) {
                long count;
                count = i;
                contador = "contador " + formatSeconds(i);
                System.out.println(contador);
                Thread.sleep(1000); 
                i--;
            }
            
        } catch (InterruptedException e) {
            System.out.println("w");
        }
        
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
