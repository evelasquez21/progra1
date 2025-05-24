/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyectofinal.admin.vista;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author eduar
 */
public class GestionTicketsController implements Initializable {

    @FXML
    private TableView<?> tbAdministrador;
    @FXML
    private Button btnGenerarTicket;
    @FXML
    private TextField txtTituloTicket;
    @FXML
    private TextField txtDesTicket;
    @FXML
    private ComboBox<?> cboDeptoAsig;
    @FXML
    private ComboBox<?> cboNivelP;
    @FXML
    private TextField txtNoTicket;
    @FXML
    private Button btnEliminarTicket;
    @FXML
    private Button btnActualizarTicket;
    @FXML
    private TextField txtNivelEstado;
    @FXML
    private TextField txtNombreEstado;
    @FXML
    private TextField txtDesEstado;
    @FXML
    private TableView<?> tbAdministrador1;
    @FXML
    private Button btnCrearEstado;
    @FXML
    private Button btnEliminarEstado;
    @FXML
    private Button btnActualizarEstado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void GenerarTicket(ActionEvent event) {
    }
    
    public void closeWindows() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminMenu.fxml"));
        
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        Stage stage = new Stage(); 
        
        stage.setScene(scene);
        stage.show();
        
        Stage myStage = (Stage) this.btnGenerarTicket.getScene().getWindow();
        myStage.close();        
    }
    
}
