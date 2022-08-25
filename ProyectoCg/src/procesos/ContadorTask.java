/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import datos.Post;
import javafx.concurrent.Task;
import modelo.Cola;
import static modelo.Tools.colaAHtml;
import static modelo.Tools.crearPosts;

/**
 *
 * @author jose.escobar
 */
public class ContadorTask extends Task<String>{
    public ContadorTask(){}
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