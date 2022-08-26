
package procesos;

import javafx.concurrent.Task;


/**
* En esta clase se crea la tarea de actualizar el Contador.
* @author isabella.duran@uao.edu.co Isabella Duran Nagles Código 2210296
* @author jose.escobar@uao.edu.co Jose David Escobar Código 2210172
* @author laura.riascos@uao.edu.co Laura C. Riascos Hernández Código 2211185
* @author juan_jose.viveros@uao.edu.co Juan J. Viveros Delgado Código 2210208
* @date 25 Agosto 2022
* @version 1.0
*/
public class ContadorTask extends Task<String>{
    
    /**
    * Constructor vacio
    */
    public ContadorTask(){}
    
    /**
    * Metodo implementado de la clase Task, este ejecuta la tarea.
    * @return cadena de texto con el valor del contador.
    */    
    @Override
    protected String call() throws Exception{
        long i = 0;
        try {
            while (!this.isCancelled()) {
                updateValue(formatSeconds(i));
                i++;
                Thread.sleep(1000); 
            }
            
        } catch (InterruptedException e) {
            System.out.println("");
        }
        return formatSeconds(i);
    }    
    
    
    /**
    * Este metodo crea el formato de tiempo.
    * @param timeInSeconds entero con un numero de segundos.
    * @return cadena con formato de tiempo de un "reloj".
    */      
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