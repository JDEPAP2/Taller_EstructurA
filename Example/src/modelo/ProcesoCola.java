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
public class ProcesoCola extends Thread{

    @Override
    public void run(){
        
        try{
            for (int i = 0; i < 3; i++) {
            System.out.println("html");
            Thread.sleep(3000);
            
        }}catch(InterruptedException e){
                System.out.println("");}  
    }
    
}
