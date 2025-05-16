/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyectofinal.admin.vista;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import proyectofinal.Conexion;
import proyectofinal.admin.modelo.UsuarioTabla;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author eduar
 */
public class GetionUsuariosController implements Initializable {

    @FXML
    private TableView<UsuarioTabla> tbAdministrador;
    @FXML
    private Button btnAgregarUsuario;
    @FXML
    private TextField txtNombreCompleto;
    @FXML
    private TextField txtCorreoElectronico;
    @FXML
    private TextField txtNombreUsuario;
    @FXML
    private TextField txtContraseña;
    @FXML
    private ComboBox<String> cboRolAsignado;
    @FXML
    private TextField txtId;
    @FXML
    private TableColumn<UsuarioTabla, String> idColumn;
    @FXML
    private TableColumn<UsuarioTabla, String> nombreCol;
    @FXML
    private TableColumn<UsuarioTabla, String> nombreUserCol;
    @FXML
    private TableColumn<UsuarioTabla, String> correoECol;
    @FXML
    private TableColumn<UsuarioTabla, String> rolCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombreCol.setCellValueFactory(new PropertyValueFactory<>("nombreCompleto"));
        nombreUserCol.setCellValueFactory(new PropertyValueFactory<>("nombreUsuario"));
        correoECol.setCellValueFactory(new PropertyValueFactory<>("correoElectronico"));
        rolCol.setCellValueFactory(new PropertyValueFactory<>("rol"));
        
        Conexion con = new Conexion();
        con.consultarUsuarios(tbAdministrador);
        con.asignarCombobox("Roles", cboRolAsignado);
        completarCampos(tbAdministrador);
    }    

    @FXML
    private void agregarUsuario(ActionEvent event) {
        
       
        Conexion con = new Conexion();
        String id = txtId.getText();
        String nombreCompleto = txtNombreCompleto.getText();
        String correoElectronico = txtCorreoElectronico.getText();
        String nombreUsuario = txtNombreUsuario.getText();
        String password = txtContraseña.getText();
        String tipoUsuario = cboRolAsignado.getSelectionModel().getSelectedItem();        
         
        con.insertarUsuarios(nombreCompleto, correoElectronico, nombreUsuario, password, tipoUsuario);
        con.consultarUsuarios(tbAdministrador);
       
        
    }
    
    public void closeWindows() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminMenu.fxml"));
        
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        Stage stage = new Stage(); 
        
        stage.setScene(scene);
        stage.show();
        
        Stage myStage = (Stage) this.btnAgregarUsuario.getScene().getWindow();
        myStage.close();        
    }
    
    public void completarCampos(TableView<UsuarioTabla> tableView){
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->{
            if (newSelection != null){
                txtId.setText(newSelection.getId());
                txtNombreCompleto.setText(newSelection.getNombreCompleto());
                txtNombreUsuario.setText(newSelection.getNombreUsuario());
                txtCorreoElectronico.setText(newSelection.getCorreoElectronico());
            }
        });
    }
    
}
