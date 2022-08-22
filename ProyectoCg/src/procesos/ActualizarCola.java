/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;
import datos.Post;
import modelo.Cola;
import static modelo.Tools.*;
/**
 *
 * @author jose.escobar
 */
public class ActualizarCola extends Thread{
     @Override
    public void run() {
        try {
            long i = 0;
            while (this.isAlive()) {
                long count;
                count = i;
                System.out.println("contador " + formatSeconds(i));
                Thread.sleep(1000); 
                i++;
            }
            
<<<<<<< HEAD
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
=======

        }catch(InterruptedException e){
            System.out.println("aaaaaa");
>>>>>>> 0d6691a2f8ef274b8d353b75a40e9f63bf804530
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
