/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

/**
 *
 * @author jose.escobar
 */
public class Contador extends Thread{
    @Override
    public void run(){
        try{
            for (int i = 0; i < 10; i++) {
                System.out.println("hilo4");
                Thread.sleep(3000);                
            }

        }catch(InterruptedException e){
            System.out.println("w");
        }        
    }    
}
