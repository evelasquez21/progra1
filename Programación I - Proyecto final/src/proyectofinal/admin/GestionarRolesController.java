/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyectofinal.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import proyectofinal.Conexion;
import proyectofinal.admin.modelo.PermisosTabla;
import proyectofinal.admin.modelo.RolesTabla;

/**
 * FXML Controller class
 *
 * @author eduar
 */
public class GestionarRolesController implements Initializable {

    @FXML
    private Button btnAgregarRol;
    @FXML
    private Button btnAgregarPermiso;
    @FXML
    private Button btnActualizarPermiso;
    @FXML
    private Button btnEliminarPermiso;
    @FXML
    private Button btnActualizarRol;
    @FXML
    private Button btnEliminarRol;
    @FXML
    private Button btnLimpiarDatosR;
    @FXML
    private Button btnLimpiarDatosP;
    @FXML
    private ComboBox<String> cboIdRol;
    @FXML
    private TableView<RolesTabla> tbRoles;
    @FXML
    private TableView<PermisosTabla> tbPermisos;
    @FXML
    private TableColumn<RolesTabla, String> colIdRol;
    @FXML
    private TableColumn<RolesTabla, String> colNombreRol;
    @FXML
    private TableColumn<RolesTabla, String> colDesRol;
    @FXML
    private TableColumn<RolesTabla, String> colNivelA;
    @FXML
    private TableColumn<PermisosTabla, String> colIdPer;
    @FXML
    private TableColumn<PermisosTabla, String> colNomPer;
    @FXML
    private TableColumn<PermisosTabla, String> colDesPer;
    @FXML
    private TableColumn<PermisosTabla, String> colRolPer;
    @FXML
    private TextField txtIdRol;
    @FXML
    private TextField txtNombreRol;
    @FXML
    private TextField txtIdPermiso;
    @FXML
    private TextField txtNomPer;
    @FXML
    private TextField txtDesPer;
    @FXML
    private TextField txtDesRol;
    @FXML
    private TextField txtNivRol;
    
    // Variables
    private Conexion con = new Conexion();
    private String IdRol;
    private String NombreRol;
    private String IdPermiso;
    private String NomPer;
    private String DesPer;
    private String DesRol;
    private String NivRol;
    private String IdRolPer;
    private ArrayList<String> listaRoles = new ArrayList<String>();
    @FXML
    private Label lblRol;
    
    public void obtenerCampos(){
        IdRol = txtIdRol.getText();
        NombreRol = txtNombreRol.getText();
        IdPermiso = txtIdPermiso.getText();
        NomPer = txtNomPer.getText();
        DesPer = txtDesPer.getText();
        DesRol = txtDesRol.getText();
        NivRol = txtNivRol.getText();
        IdRolPer = cboIdRol.getSelectionModel().getSelectedItem();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        colIdRol.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombreRol.setCellValueFactory(new PropertyValueFactory<>("nombreRol"));
        colNivelA.setCellValueFactory(new PropertyValueFactory<>("tipoAcceso"));
        colDesRol.setCellValueFactory(new PropertyValueFactory<>("descripcionRol"));
        
        colIdPer.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNomPer.setCellValueFactory(new PropertyValueFactory<>("nombrePermiso"));
        colDesPer.setCellValueFactory(new PropertyValueFactory<>("descripcionPermiso"));
        colRolPer.setCellValueFactory(new PropertyValueFactory<>("idRol"));
        
        con.consultarRoles(tbRoles, listaRoles);
        con.consultarPermisos(tbPermisos);
        con.asignarCombobox("Roles", cboIdRol);
        
        completarCampos1(tbRoles);
        completarCampos2(tbPermisos);
    }    

    @FXML
    private void agregarRol(ActionEvent event) {
        obtenerCampos();
        con.insertarRoles(NombreRol, NivRol, DesRol);
        con.consultarRoles(tbRoles, listaRoles);
        con.asignarCombobox("Roles", cboIdRol);
    }

    @FXML
    private void agregarPermiso(ActionEvent event) {
        obtenerCampos();
        con.insertarPermisos(NomPer, DesPer, IdRolPer);
        con.consultarPermisos(tbPermisos);
    }
    
    public void closeWindows() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("vista/AdminMenu.fxml"));
        
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        Stage stage = new Stage(); 
        
        stage.setScene(scene);
        stage.show();
        
        Stage myStage = (Stage) this.btnAgregarRol.getScene().getWindow();
        myStage.close();        
    }
    
    public void completarCampos1(TableView<RolesTabla> tableView){
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->{
            if (newSelection != null){
                txtIdRol.setText(newSelection.getId());
                txtNombreRol.setText(newSelection.getNombreRol());
                txtDesRol.setText(newSelection.getDescripcionRol());
                txtNivRol.setText(newSelection.getTipoAcceso());
            }
        });
    }
    
    public void completarCampos2(TableView<PermisosTabla> tableView){
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->{
            if (newSelection != null){
                txtIdPermiso.setText(newSelection.getId());
                txtNomPer.setText(newSelection.getNombrePermiso());
                txtDesPer.setText(newSelection.getDescripcionPermiso());
                String permiso = newSelection.getIdRol();
                for (int i = 0; i < listaRoles.size(); i++) {
                    if (permiso.equals(listaRoles.get(i))) {
                        cboIdRol.setValue(listaRoles.get(i-1));
                    }
                }
            }
        });
    }

    @FXML
    private void actualizarPermiso(ActionEvent event) {
        obtenerCampos();
        con.actualizarPermisos(IdPermiso, NomPer, DesPer, IdRolPer);
        con.consultarPermisos(tbPermisos);
    }

    @FXML
    private void eliminarPermiso(ActionEvent event) {
        obtenerCampos();
        con.eliminarPermisos(IdPermiso);
        con.consultarPermisos(tbPermisos);
    }

    @FXML
    private void actualizarRol(ActionEvent event) {
        obtenerCampos();
        con.actualizarRoles(IdRol, NombreRol, NivRol, DesRol);
        con.consultarRoles(tbRoles, listaRoles);
    }

    @FXML
    private void eliminarRol(ActionEvent event) {
        obtenerCampos();
        con.eliminarRoles(IdRol);
        con.consultarRoles(tbRoles, listaRoles);
        con.asignarCombobox("Roles", cboIdRol);
    }

    @FXML
    private void LimpiarDatosR(ActionEvent event) {
        txtIdRol.setText("");
        txtNombreRol.setText("");
        txtDesRol.setText("");
        txtNivRol.setText("");
        
    }

    @FXML
    private void LimpiarDatosP(ActionEvent event) {
        txtIdPermiso.setText("");
        txtNomPer.setText("");
        txtDesPer.setText("");
        cboIdRol.getSelectionModel().clearSelection();
    }

    @FXML
    private void mostrarNomRol(ActionEvent event) {
        for (int i = 0; i < listaRoles.size(); i++) {
            if (cboIdRol.getSelectionModel().getSelectedItem().equals(listaRoles.get(i))) {
                lblRol.setText(listaRoles.get(i+1));
            }
        }
    }
    
}
