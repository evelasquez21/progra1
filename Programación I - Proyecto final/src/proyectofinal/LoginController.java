/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyectofinal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author eduar
 */
public class LoginController implements Initializable {

    @FXML
    private Button bntIniciarSesion;
    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtPassowrd;
    
    private Conexion con = new Conexion();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void acceder(ActionEvent event) throws IOException {
        if (con.iniciarSession(txtUsuario.getText(), txtPassowrd.getText()) == false) {
            
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("admin/vista/AdminMenu.fxml"));
        
            Parent root = loader.load();

            proyectofinal.admin.AdminMenuController controlador = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage(); 

            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(e -> {
                try {
                    controlador.closeWindows();
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            Stage myStage = (Stage) this.bntIniciarSesion.getScene().getWindow();
            myStage.close();     
        }
           
    }
    
}
