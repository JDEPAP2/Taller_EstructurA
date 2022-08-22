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
public class ProcesoHTML extends Thread{

    @Override
    public void run(){
        
        try{
            for (int i = 0; i < 6; i++) {
            System.out.println("eeeem");
            Thread.sleep(2000);
            
        }}catch(InterruptedException e){
                System.out.println("");}  
    }
    
}
