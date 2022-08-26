
package procesos;

import javafx.concurrent.Task;
import modelo.Orquestador;
import static modelo.Tools.*;

/**
* En esta clase se crea la tarea de actualizar el html de Reporte.
* @author isabella.duran@uao.edu.co Isabella Duran Nagles Código 2210296
* @author jose.escobar@uao.edu.co Jose David Escobar Código 2210172
* @author laura.riascos@uao.edu.co Laura C. Riascos Hernández Código 2211185
* @author juan_jose.viveros@uao.edu.co Juan J. Viveros Delgado Código 2210208
* @date 25 Agosto 2022
* @version 1.0
*/
public class ReporteTask extends Task<String>{
    Orquestador []orq;
    
    /**
    * Constructor de ReporteTask.
    * @param orq[] lista con objetos de la clase Orquestador
    */     
    public ReporteTask (Orquestador []orq) {
        this.orq = orq;
    }
    
    /**
    * Metodo implementado de la clase Task, este ejecuta la tarea.
    * @return cadena de texto con el cuerpo html del reporte.
    */
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
