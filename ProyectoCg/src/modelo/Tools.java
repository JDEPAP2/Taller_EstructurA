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
    
        
    public static String convertirReporteAHtml(){
        
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
                .append("<td>").append("Cantidad Total de Post: ").append("</td>")
                .append("<td>").append("Cantidad Total de Post: ").append("</td>")
                .append("<td>").append("Cantidad Total de Post: ").append("</td>")
                .append("</tr>");
        
        sb.append("<tr>")
                .append("<td>").append("Tiempo Total: ").append("</td>")
                .append("<td>").append("Tiempo Total: ").append("</td>")
                .append("<td>").append("Tiempo Total: ").append("</td>")
                .append("</tr>");
        
        sb.append("<tr>")
                .append("<td>").append("Tiempo Promedio: ").append("</td>")
                .append("<td>").append("Tiempo Promedio: ").append("</td>")
                .append("<td>").append("Tiempo Promedio: ").append("</td>")
                .append("</tr>");
        
        sb.append("<tr>")
                .append("<td>").append("Post en el que se demoro más tiempo: ").append("</td>")
                .append("<td>").append("Post en el que se demoro más tiempo: ").append("</td>")
                .append("<td>").append("Post en el que se demoro más tiempo: ").append("</td>")
                .append("</tr>");
        
        sb.append("<tr>")
                .append("<td>").append("Post en el que se demoro menos tiempo: ").append("</td>")
                .append("<td>").append("Post en el que se demoro menos tiempo: ").append("</td>")
                .append("<td>").append("Post en el que se demoro menos tiempo: ").append("</td>")
                .append("</tr>");
        
                sb.append("<tr>")
                .append("<td colspan=\"3\">").append("Orquestador más demorado: ").append("</td>")
                .append("</tr>");
                
        sb.append("</table>");
        
//      sb.append("<h1 align=\"center\">").append("Cola Vacia").append("</h1>");
        sb.append("</html>");
        
        return sb.toString();    
    }
    
}
