/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import datos.Post;
import java.util.Calendar;

/**
* En esta clase se estan se crean los metodos que permiten realizar un objeto de la clase Post.
* @author jose.escobar@uao.edu.co Jose David Escobar Código 2210172
* @author jose.escobar@uao.edu.co Jose David Escobar Código 2210172
* @author jose.escobar@uao.edu.co Jose David Escobar Código 2210172
* @author jose.escobar@uao.edu.co Jose David Escobar Código 2210172
* @date 20 Agosto 2022
* @version 1.0
*/

public class OperacionesPost {
    /**
    * Genera un objeto de la clase Post.
    * @return objeto de la clase Post.
    */
    public static Post generarPost(){
        String usuario = "@" + generarTexto(7,1);
        String fecha = generarFecha();        
        String contenido = generarTexto(6,5);
        String tiempoT = "" + ((int) (Math.random()* (1 + 6)));
        while (tiempoT.equals("0")){
            tiempoT = "" + ((int) (Math.random()* (1 + 6)));
        }      
        return new Post(usuario, fecha, contenido, tiempoT);
    }
    
    /**
    * Este metodo crea un parrafo o una palabra con caracteres aleatorios.
    * @param num Define el numero de letras que se desean generar en cada palabra presente en el parrafo de respuesta.
    * @param nom Define el numero de palabras que se desean generar en el parrafo de respuesta.
    * @return cadena de texto con una palabra o  un parrafo.
    */
    public static String generarTexto(int num, int nom){
        String ref = "abcdefghijklmnopqstuvwxyz";
        String palabra = "", res = "";
        char letra;    
        for (int j = 0; j < nom; j++) {
            for (int i = 0; i < num; i++) {
                letra = ref.charAt((int) (Math.random()* (0 + ref.length()-1)));
                palabra += letra;
            }
            res += palabra + " ";
            palabra = "";
        }
        
        return res;
    }
    /**
    * Genera una fecha y hora del momento preciso en el cual se invoca.
    * @return cadena de texto con la fecha y hora del momento preciso en el cual se invoca.
    */
    public static String generarFecha(){
        Calendar fecha = Calendar.getInstance();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DATE);
        int hora = fecha.get(Calendar.HOUR);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
        String res = año +"/"+ mes +"/"+ dia +" - "+ hora +":"+ minuto +":"+ segundo;
        return res;
    }
}
