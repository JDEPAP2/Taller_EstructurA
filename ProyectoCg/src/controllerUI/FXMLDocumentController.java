/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerUI;

import datos.Post;
import java.net.URL;
import java.util.ResourceBundle;
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
    private WebView wbOrquestadores;
    
    @FXML
    private WebView wbCola;
        
    @FXML
    private WebView wbReporte;
    
    @FXML
    private TextArea contador;
           
    WebEngine webEngine1;
    WebEngine webEngine2;
    WebEngine webEngine3;

    Tools objTools = new Tools();
    
    
        @FXML
    private void iniciarProceso(ActionEvent event) {
        String html = objTools.orquestadoresAHtml();
        webEngine1.loadContent(html);
        String html2 = objTools.colaAHtml(colaP);
        webEngine2.loadContent(html2);

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
        webEngine1 = wbOrquestadores.getEngine();
        webEngine2 = wbCola.getEngine();
        webEngine3 = wbReporte.getEngine();
        
        webEngine1.load("");
        webEngine2.load("");
        webEngine3.load("");
        
        ActualizarCola hiloCola = new ActualizarCola();
        ActualizarOrquestador hiloOrquestador1 = new  ActualizarOrquestador("hiloOrquestador1");
        ActualizarOrquestador hiloOrquestador2 = new  ActualizarOrquestador("hiloOrquestador2");
        ActualizarOrquestador hiloOrquestador3 = new  ActualizarOrquestador("hiloOrquestador3");
        ActualizarReporte hiloReporte = new ActualizarReporte();
        Contador hiloContador = new Contador();

        hiloCola.cola(colaP);        
        hiloCola.start();

        
        hiloOrquestador1.cola(colaP);
        hiloOrquestador2.cola(colaP);
        hiloOrquestador3.cola(colaP);
        hiloOrquestador1.esperar();
        hiloOrquestador2.esperar();
        hiloOrquestador3.esperar();
        
        
    


//        hiloReporte.start();
//        hiloContador.start();
//        hiloOrquestador.start();
        
    }    

}
