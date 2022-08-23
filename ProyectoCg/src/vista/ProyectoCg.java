/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Descripción:
 * @author isabella.duran@uao.edu.co Isabella Duran Cód. 2210296
 * @author jose.escobar@uao.edu.co Jose D. Escobar Cód. 2210172
 * @author laura.riascos@uao.edu.co Laura C. Riascos Cód. 2211185
 * @author Juan_jose.viveros@uao.edu.co Juan J. Viveros Cód. 2210208
 * @date 25 de Agosto de 2022
 * @version 1.8
 */
public class ProyectoCg extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/vista/FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
