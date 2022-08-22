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
public class Example {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ProcesoHTML hilo1 = new ProcesoHTML();
        ProcesoCola hilo2 = new  ProcesoCola();
        ProcesoContador hilo3 = new ProcesoContador();
        ProcesoReporte hilo4 = new ProcesoReporte();
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
    }
    
}
