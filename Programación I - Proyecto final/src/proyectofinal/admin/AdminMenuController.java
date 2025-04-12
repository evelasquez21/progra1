/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyectofinal.admin;

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
import javafx.stage.Stage;
import proyectofinal.LoginController;
import proyectofinal.admin.vista.ConfigFlujoTrabajoController;
import proyectofinal.admin.vista.GestionDepartamentoController;
import proyectofinal.admin.vista.GestionTicketsController;
import proyectofinal.admin.vista.GetionUsuariosController;

/**
 * FXML Controller class
 *
 * @author eduar
 */
public class AdminMenuController implements Initializable {

    @FXML
    private Button btnCerrarSesion;
    @FXML
    private Button btnParametros;
    @FXML
    private Button btnRoles;
    @FXML
    private Button btnFlujoTrabajo;
    @FXML
    private Button btnUsuarios;
    @FXML
    private Button btnDep;
    @FXML
    private Button btnTicket;
    
    @FXML
    private void irParametros(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("vista/ConfigParametros.fxml"));
        
        Parent root = loader.load();
        
        ConfigParametrosController controlador = loader.getController();
        
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
        
        Stage myStage = (Stage) this.btnParametros.getScene().getWindow();
        myStage.close(); 
    }

    @FXML
    private void irRoles(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("vista/GestionarRoles.fxml"));
        
        Parent root = loader.load();
        
        GestionarRolesController controlador = loader.getController();
        
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
        
        Stage myStage = (Stage) this.btnParametros.getScene().getWindow();
        myStage.close(); 
    }

    @FXML
    private void irFlujoTrabajo(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("vista/ConfigFlujoTrabajo.fxml"));
        
        Parent root = loader.load();
        
        ConfigFlujoTrabajoController controlador = loader.getController();
        
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
        
        Stage myStage = (Stage) this.btnParametros.getScene().getWindow();
        myStage.close(); 
    }

    @FXML
    private void irUsuarios(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("vista/GetionUsuarios.fxml"));
        
        Parent root = loader.load();
        
        GetionUsuariosController controlador = loader.getController();
        
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
        
        Stage myStage = (Stage) this.btnParametros.getScene().getWindow();
        myStage.close(); 
    }

    @FXML
    private void irDepartamento(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("vista/GestionDepartamento.fxml"));
        
        Parent root = loader.load();
        
        GestionDepartamentoController controlador = loader.getController();
        
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
        
        Stage myStage = (Stage) this.btnParametros.getScene().getWindow();
        myStage.close(); 
    }

    @FXML
    private void irTickets(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("vista/GestionTickets.fxml"));
        
        Parent root = loader.load();
        
        GestionTicketsController controlador = loader.getController();
        
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
        
        Stage myStage = (Stage) this.btnParametros.getScene().getWindow();
        myStage.close(); 
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cerrarSesion(ActionEvent event) {
    }
    
    public void closeWindows() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Login.fxml"));
        
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        Stage stage = new Stage(); 
        
        stage.setScene(scene);
        stage.show();
        
        Stage myStage = (Stage) this.btnCerrarSesion.getScene().getWindow();
        myStage.close();        
    }

    
    
}
