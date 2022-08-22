/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author jose.escobar
 */
public class OperacionesCola {

//    public OperacionesCola() {
//    }
    
    public static <T extends Base> Cola<T> colaDuplicada(Cola<T> ColaOriginal){
        Cola<T> ColaDuplicada = new Cola<>();
        Cola<T> ColaAuxiliar = new Cola<>();
        
        while (!ColaOriginal.estaVacia()){
            T elemento = ColaOriginal.desencolar();
            ColaAuxiliar.encolar(elemento);
        }
        while (!ColaAuxiliar.estaVacia()){
            T elemento = ColaAuxiliar.desencolar();
            T elemento2 = (T) elemento.copy();
            
            ColaOriginal.encolar(elemento);
            ColaDuplicada.encolar(elemento2);
        }
        return ColaDuplicada;
    }
    
    public static <T extends Base> Cola<T> colaInvertida(Cola<T> ColaOriginal){
        Cola<T> ColaInvertida = new Cola<>();
        Cola<T> ColaAuxiliar = colaDuplicada(ColaOriginal);
        
        while (!ColaAuxiliar.estaVacia()){
            ColaInvertida.encolar(ColaAuxiliar.desencolar());
        }
        return ColaInvertida;
    }
    
    
}
