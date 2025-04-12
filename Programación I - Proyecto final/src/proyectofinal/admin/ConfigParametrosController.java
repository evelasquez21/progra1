/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyectofinal.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author eduar
 */
public class ConfigParametrosController implements Initializable {

    @FXML
    private Button btnGuardar;

    @FXML
    private void guardarCambios(ActionEvent event) {
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

     public void closeWindows() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("vista/AdminMenu.fxml"));
        
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        Stage stage = new Stage(); 
        
        stage.setScene(scene);
        stage.show();
        
        Stage myStage = (Stage) this.btnGuardar.getScene().getWindow();
        myStage.close();        
    }

    
    
}
