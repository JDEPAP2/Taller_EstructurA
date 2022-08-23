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
import modelo.Tools;
import static modelo.Tools.*;
import procesos.ActualizarCola;
import procesos.ActualizarOrquestador;
import procesos.ActualizarReporte;
import procesos.ColaTask;
import procesos.Contador;

/**
 *
 * @author PC
 */
public class FXMLDocumentController implements Initializable {
    
    Cola<Post> colaP;
    
    @FXML
    private Label label;
    
    @FXML
    private WebView wbReporte, wbCola, wbOrquestador, wbOrquestador1, wbOrquestador2;
        
    @FXML
    private TextArea contador;
           
    WebEngine webEngine1, webEngine2, webEngine3, webEngine4, webEngine5;

    Tools objTools = new Tools();
    
    
        @FXML
    private void iniciarProceso(ActionEvent event) {
        
//        ActualizarCola hiloCola = new ActualizarCola();
//        ActualizarOrquestador hiloOrquestador1 = new  ActualizarOrquestador("hiloOrquestador1");
//        ActualizarOrquestador hiloOrquestador2 = new  ActualizarOrquestador("hiloOrquestador2");
//        ActualizarOrquestador hiloOrquestador3 = new  ActualizarOrquestador("hiloOrquestador3");
//        ActualizarReporte hiloReporte = new ActualizarReporte();
//        Contador hiloContador = new Contador();
//
//        hiloCola.cola(colaP);        
//        hiloCola.start();
//        
//
//
//        
//        hiloOrquestador1.cola(colaP);
//        hiloOrquestador2.cola(colaP);
//        hiloOrquestador3.cola(colaP);
//        hiloOrquestador1.esperar();
//        hiloOrquestador2.esperar();
//        hiloOrquestador3.esperar();
        
        invokeCola();
        String html = objTools.orquestadoresAHtml();
        webEngine1.loadContent(html);

    }
    
    @FXML
    private void finalizarProceso(ActionEvent event) {
        String html = objTools.convertirReporteAHtml();
        webEngine3.loadContent(html);
    }    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        colaP = new Cola<>();
        webEngine1 = wbOrquestador.getEngine();
        webEngine4 = wbOrquestador1.getEngine();
        webEngine5 = wbOrquestador2.getEngine();
        webEngine2 = wbCola.getEngine();
        webEngine3 = wbReporte.getEngine();
        wbCola.setZoom(0.9);
        
        webEngine1.load("");
        webEngine3.load("");
        
        
        
        
    


//        hiloReporte.start();
//        hiloContador.start();
//        hiloOrquestador.start();
        
    }    
     public void invokeCola(){
        ColaTask valor = new ColaTask(colaP);
        valor.valueProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
                webEngine2.loadContent(newValue);
            }
        });
        Thread th = new Thread(valor);
        th.setDaemon(true);
        th.start();
        
     }
}
