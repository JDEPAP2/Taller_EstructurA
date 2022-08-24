/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerUI;

import datos.Post;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import modelo.Cola;
import modelo.Orquestador;
import modelo.Tools;
import static modelo.Tools.*;
import procesos.ActualizarReporte;
import procesos.ColaTask;
import procesos.Contador;
import procesos.OrquestadorTask;
import procesos.ReporteTask;

/**
 *
 * @author PC
 */
public class FXMLDocumentController implements Initializable {
    
    Cola<Post> colaP;
    Orquestador orq1;
    Orquestador orq2;
    Orquestador orq3;
    
    @FXML
    private Label label;
    
    @FXML
    private WebView wbReporte, wbCola, wbOrquestador1, wbOrquestador2, wbOrquestador3;
        
    @FXML
    private TextArea contador;
           
    WebEngine webEngine1, webEngine2, webEngine3,  webEngine4,  webEngine5;

    Tools objTools = new Tools();
    
    
        @FXML
    private void iniciarProceso(ActionEvent event) {
        
        invocarCola(true);
        invocarOrq(true);
        invocarReporte(true);
        
    }
    
    @FXML
    private void finalizarProceso(ActionEvent event) {
        invocarCola(false);
        invocarOrq(false);
        invocarReporte(false);
    }    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        colaP = new Cola<>();
        webEngine1 = wbOrquestador1.getEngine();
        webEngine4 = wbOrquestador2.getEngine();
        webEngine5 = wbOrquestador3.getEngine();
        webEngine2 = wbCola.getEngine();
        webEngine3 = wbReporte.getEngine();
        wbCola.setZoom(0.9);
        wbReporte.setZoom(0.8);
        
        webEngine1.load("");
        webEngine3.load("");
        
        orq1 = generarOrquestador("Orquestador 1");
        orq2 = generarOrquestador("Orquestador 2");
        orq3 = generarOrquestador("Orquestador 3");
        
        
        
        
    


//        hiloReporte.start();
//        hiloContador.start();
//        hiloOrquestador.start();
        
    }    
     public void invocarCola(boolean i){
        ColaTask valor = new ColaTask(colaP);
        valor.valueProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            webEngine2.loadContent(newValue);
        });
        Thread th = new Thread(valor);
        th.setDaemon(true);
        if(i){th.start();}
        else{th.interrupt();}
        
     }
     
     public void invocarReporte(boolean i){
        Orquestador []orq = new Orquestador[3];
        orq[0] = orq1;orq[1] = orq2;orq[2] = orq3;

        ReporteTask valor = new ReporteTask(orq);
        valor.valueProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            webEngine3.loadContent(newValue);
        });
        Thread th = new Thread(valor);
        th.setDaemon(true);
        if(i){th.start();}
        else{th.interrupt();}
        
     }
     
    public void invocarOrq(boolean i){
        
        OrquestadorTask valor = new OrquestadorTask(colaP, orq1);
        OrquestadorTask valor1 = new OrquestadorTask(colaP, orq2);
        OrquestadorTask valor2 = new OrquestadorTask(colaP, orq3);
        
        valor.valueProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            webEngine1.loadContent(newValue);
        });
        
        valor1.valueProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            webEngine4.loadContent(newValue);
        });
                
        valor2.valueProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            webEngine5.loadContent(newValue);
        });
        
        Thread th = new Thread(valor);
        if(i){th.start();}
        else{th.interrupt();}
        Thread th1 = new Thread(valor1);  
        if(i){th1.start();}
        else{th1.interrupt();}       
        Thread th2 = new Thread(valor2);
        if(i){th2.start();}
        else{th2.interrupt();}
    }
    
}
        
