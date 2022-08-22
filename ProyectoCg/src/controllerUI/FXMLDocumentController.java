/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerUI;

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

/**
 *
 * @author PC
 */
public class FXMLDocumentController implements Initializable {
    
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
        
        String html2 = objTools.colaAHtml();
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
        webEngine1 = wbOrquestadores.getEngine();
        webEngine2 = wbCola.getEngine();
        webEngine3 = wbReporte.getEngine();
        
        webEngine1.load("");
        webEngine2.load("");
        webEngine3.load("");
    }    

}
