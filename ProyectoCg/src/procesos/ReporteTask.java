/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import datos.Post;
import javafx.concurrent.Task;
import modelo.Cola;
import modelo.Orquestador;
import static modelo.Tools.*;

/**
 *
 * @author PC
 */
public class ReporteTask extends Task<String>{
    Orquestador []orq;
    public ReporteTask (Orquestador []orq) {
        this.orq = orq;
    }
    @Override
    protected String call() throws Exception{
        Thread.sleep(9600);
        while(!this.isCancelled()){
                updateValue(convertirReporteAHtml(orq));
                Thread.sleep(3000);
            }
        return convertirReporteAHtml(orq);
    }
}
