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
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnLimpiarDatos;
    @FXML
    private Button btnBuscarID;
    
    
    // variables
    private Conexion con = new Conexion();  
    private String id;
    private String nombreCompleto;
    private String correoElectronico;
    private String nombreUsuario;
    private String password;
    private String tipoUsuario;
    
    public void obtenerCampos(){
        id = txtId.getText();
        nombreCompleto = txtNombreCompleto.getText();
        correoElectronico = txtCorreoElectronico.getText();
        nombreUsuario = txtNombreUsuario.getText();
        password = txtContraseña.getText();
        tipoUsuario = cboRolAsignado.getSelectionModel().getSelectedItem();
    }

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
        
        con.consultarUsuarios(tbAdministrador);
        con.asignarCombobox("Roles", cboRolAsignado);
        completarCampos(tbAdministrador);
    }    

    @FXML
    private void agregarUsuario(ActionEvent event) {      
        obtenerCampos();
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

    @FXML
    private void actualizarUsuario(ActionEvent event) {
        obtenerCampos();
        con.actualizarUsuarios(id, nombreCompleto, correoElectronico, nombreUsuario, password, tipoUsuario);
        con.consultarUsuarios(tbAdministrador);
    }

    @FXML
    private void eliminarUsuario(ActionEvent event) {
        obtenerCampos();
        con.eliminarUsuarios(id);
        con.consultarUsuarios(tbAdministrador);
    }

    @FXML
    private void limpiarDatos(ActionEvent event) {
        txtId.setText("");
        txtNombreCompleto.setText("");
        txtCorreoElectronico.setText("");
        txtNombreUsuario.setText("");
        txtContraseña.setText("");
        cboRolAsignado.getSelectionModel().clearSelection();
    }

    @FXML
    private void buscarIdUsuario(ActionEvent event) {
        obtenerCampos();
        con.buscarUsuarios(tbAdministrador, id);
    }
    
}
