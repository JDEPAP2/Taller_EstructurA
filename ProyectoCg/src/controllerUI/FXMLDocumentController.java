/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerUI;

import datos.Post;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JOptionPane;
import modelo.Cola;
import modelo.Orquestador;
import static modelo.Tools.*;
import static modelo.Utilidad.*;
import procesos.ColaTask;
import procesos.ContadorTask;
import procesos.OrquestadorTask;
import procesos.ReporteTask;
/**
* En esta clase se emplean tanto atributos como métodos que se necesitan emplear en la interfaz.
* @author isabella.duran@uao.edu.co Isabella Duran Nagles Código 2210296
* @author jose.escobar@uao.edu.co Jose David Escobar Código 2210172
* @author laura.riascos@uao.edu.co Laura C. Riascos Hernández Código 2211185
* @author juan_jose.viveros@uao.edu.co Juan J. Viveros Delgado Código 2210208
* @date 25 Agosto 2022
* @version 1.0
*/
public class FXMLDocumentController implements Initializable {
    
    Cola<Post> colaP;
    Orquestador orq1;
    Orquestador orq2;
    Orquestador orq3;
    Thread thCola;
    Thread th1;
    Thread th2;
    Thread th3;
    Thread thContador;
    Thread thReporte;
    
    
    
    @FXML
    private Label label, label1, label2;
    
    @FXML
    private WebView wbReporte, wbCola, wbOrquestador1, wbOrquestador2, wbOrquestador3;
        
           
    WebEngine webEngine1, webEngine2, webEngine3,  webEngine4,  webEngine5;


    
    
        @FXML
    private void iniciarProceso(ActionEvent event) {
        wbCola.setVisible(true);
        wbOrquestador1.setVisible(true);
        wbOrquestador2.setVisible(true);
        wbOrquestador3.setVisible(true);
        wbReporte.setVisible(true);
        label2.setVisible(true);
        
        invocarContador();
        invocarCola();
        invocarOrq();
        invocarReporte();        
    }
    
    @FXML
    private void finalizarProceso(ActionEvent event) {
        try{
            thContador.interrupt();
            thCola.interrupt();
            th1.interrupt();
            th2.interrupt();
            th3.interrupt();
            thReporte.interrupt();
            
            Orquestador []or = new Orquestador[3];
            or[0] = orq1;or[1] = orq2;or[2] = orq3;
            boolean t = crearArchivoXML(or);
            if(t){
                JOptionPane.showMessageDialog(null, "Se guardaron los datos de los orquestadores en un archivo xml");
            }else{
                JOptionPane.showMessageDialog(null, "No se guardaron los datos");}
            
            while(!colaP.estaVacia()){colaP.desencolar();}
            wbCola.setVisible(false);
            orq1 = generarOrquestador("Orquestador 1");
            orq2 = generarOrquestador("Orquestador 2");
            orq3 = generarOrquestador("Orquestador 3");
            wbOrquestador1.setVisible(false);
            wbOrquestador2.setVisible(false);
            wbOrquestador3.setVisible(false);
            wbReporte.setVisible(false);
            
        }catch(Exception e){
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "El programa no se ha iniciado");
        }


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
        wbOrquestador1.setZoom(1.1);
        wbOrquestador2.setZoom(1.1);
        wbOrquestador3.setZoom(1.1);
        
        orq1 = generarOrquestador("Orquestador 1");
        orq2 = generarOrquestador("Orquestador 2");
        orq3 = generarOrquestador("Orquestador 3");
        
        
    }    
    public void invocarCola(){
        ColaTask valor = new ColaTask(colaP);
        valor.valueProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            webEngine2.loadContent(newValue);
        });
        thCola = new Thread(valor);
        thCola.setDaemon(true);
        thCola.start();
        
     }
     
    public void invocarContador(){
        ContadorTask valor = new ContadorTask();
        valor.valueProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            label1.setText(newValue);            
        });
        thContador = new Thread(valor);
        thContador.start();
        
     }
     
    public void invocarReporte(){
        Orquestador []orq = new Orquestador[3];
        orq[0] = orq1;orq[1] = orq2;orq[2] = orq3;

        ReporteTask valor = new ReporteTask(orq);
        valor.valueProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            webEngine3.loadContent(newValue);
        });
        thReporte = new Thread(valor);
        thReporte.setDaemon(true);
        thReporte.start();
        
     }
     
    public void invocarOrq(){
        
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
        
        th1 = new Thread(valor);
        th1.start();
        th2 = new Thread(valor1);  
        th2.start();    
        th3 = new Thread(valor2);
        th3.start();
    }
    
}
        
