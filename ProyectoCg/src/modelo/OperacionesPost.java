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


public class OperacionesPost {
    public static Post generarPost(){
        String usuario;
        String fecha;        
        String contenido = generarContenido();
        
        return new Post("","", "", "");
    }
    
    public static String generarContenido(){
        String ref = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRsTtUuVvWwXxYyZz";
        String palabra = "", res = "";
        char letra;    
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 6; i++) {
                letra = ref.charAt((int) (Math.random()* (0 + ref.length()-1)));
                palabra += letra;
            }
            res += palabra + " ";
            palabra = "";
        }
        
        return res;
    }
}
