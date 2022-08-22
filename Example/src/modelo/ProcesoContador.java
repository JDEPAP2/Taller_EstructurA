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
public class ProcesoContador extends Thread{

    @Override
    public void run(){
        
        try{
            for (int i = 0; i < 10; i++) {
            System.out.println("contador");
            Thread.sleep(1000);
            
        }}catch(InterruptedException e){
                System.out.println("");}  
    }
    
}
