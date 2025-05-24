/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyectofinal.admin.vista;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import proyectofinal.Conexion;
import proyectofinal.admin.modelo.*;

/**
 * FXML Controller class
 *
 * @author eduar
 */
public class GestionDepartamentoController implements Initializable {

    @FXML
    private TextField txtNomDepto;
    @FXML
    private TextField txtDescDepto;
    @FXML
    private ComboBox<String> cboTecnicos;
    @FXML
    private Button btnAgregarDepto;
    @FXML
    private TableView<Departamentos> txbDepartamentos;
    @FXML
    private TextField txtIdDepto;
    @FXML
    private Button btnAgregarTec;
    @FXML
    private TableColumn<Departamentos, String> colIdDepto;
    @FXML
    private TableColumn<Departamentos, String> colNomDepto;
    @FXML
    private TableColumn<Departamentos, String> colDesDepto;
    @FXML
    private TableColumn<Asignaciones, String> colIdAsig;
    @FXML
    private TableColumn<Asignaciones, String> colNomTec;
    @FXML
    private TableColumn<Asignaciones, String> colUsuTec;
    @FXML
    private TableColumn<Asignaciones, String> colDepto;
    @FXML
    private TableView<Asignaciones> tbAsignaciones;
    @FXML
    private TextField txtIdAsig;
    @FXML
    private Button btnEliminarDepto;
    @FXML
    private Button btnActualizarDepto;
    @FXML
    private ComboBox<String> cboDepartamentos;
    @FXML
    private Button btnEliminarAsig;
    @FXML
    private Button btnActualizarAsig;
    @FXML
    private Label lblTecnico;
    
     // variables
    private Conexion con = new Conexion();
    private String idDepto;
    private String nombDepto;
    private String DesDepto;
    private String idAsig;
    private String idUsuario;
    private String idDeptoA;
    private ArrayList<String> listaTecnicos = new ArrayList<String>();
    
    private void obtenerCampos(){
        idDepto = txtIdDepto.getText();
        nombDepto = txtNomDepto.getText();
        DesDepto = txtDescDepto.getText();
        idAsig = txtIdAsig.getText();
        idUsuario = cboTecnicos.getSelectionModel().getSelectedItem();
        idDeptoA = cboDepartamentos.getSelectionModel().getSelectedItem();
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        con.listaTecnicos(cboTecnicos, listaTecnicos);
        con.asignarCombobox("Departamentos", cboDepartamentos);
        
        
        con.consultarDepartamentos(txbDepartamentos);
        con.consultarAsignaciones(tbAsignaciones);
        
        colIdDepto.setCellValueFactory(new PropertyValueFactory<>("idDepto"));
        colNomDepto.setCellValueFactory(new PropertyValueFactory<>("nombreDepartamento"));
        colDesDepto.setCellValueFactory(new PropertyValueFactory<>("descripcionDepartamento"));
        
        colIdAsig.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNomTec.setCellValueFactory(new PropertyValueFactory<>("nombreCompleto"));
        colUsuTec.setCellValueFactory(new PropertyValueFactory<>("nombreUsuario"));
        colDepto.setCellValueFactory(new PropertyValueFactory<>("nombreDepto"));
        
        completarCampos1(txbDepartamentos);
        completarCampos2(tbAsignaciones);
        
    }    

    @FXML
    private void agregarDepartamento(ActionEvent event) {
        obtenerCampos();
        con.insertarDepartamentos(nombDepto, DesDepto);
        con.consultarDepartamentos(txbDepartamentos);
        con.asignarCombobox("Departamentos", cboDepartamentos);
    }
    
    public void closeWindows() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminMenu.fxml"));
        
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        Stage stage = new Stage(); 
        
        stage.setScene(scene);
        stage.show();
        
        Stage myStage = (Stage) this.btnAgregarDepto.getScene().getWindow();
        myStage.close();        
    }
    
    public void completarCampos1(TableView<Departamentos> tableView){
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->{
            if (newSelection != null){
                txtIdDepto.setText(newSelection.getIdDepto());
                txtNomDepto.setText(newSelection.getNombreDepartamento());
                txtDescDepto.setText(newSelection.getDescripcionDepartamento());
            }
        });
    }
    
    public void completarCampos2(TableView<Asignaciones> tableView){
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->{
            if (newSelection != null){
                txtIdAsig.setText(newSelection.getId());
            }
        });
    }

    @FXML
    private void agregarTecnico(ActionEvent event) {
        obtenerCampos();
        con.insertarAsignaciones(idUsuario, idDeptoA);
        con.consultarAsignaciones(tbAsignaciones);
    }

    @FXML
    private void eliminarDepartamento(ActionEvent event) {
        obtenerCampos();
        con.eliminarDepartamentos(idDepto);
        con.consultarDepartamentos(txbDepartamentos);
        con.asignarCombobox("Departamentos", cboDepartamentos);
    }

    @FXML
    private void actualizarDepartamento(ActionEvent event) {
        obtenerCampos();
        con.actualizarDepartamentos(idDepto, nombDepto, DesDepto);
        con.consultarDepartamentos(txbDepartamentos);
        con.consultarAsignaciones(tbAsignaciones);
    }


    @FXML
    private void actualizarAsig(ActionEvent event) {
        obtenerCampos();
        con.actualizatAsignaciones(idAsig, idUsuario, idDeptoA);
        con.consultarAsignaciones(tbAsignaciones);
    }

    @FXML
    private void mostrarNomTec(ActionEvent event) {
        for (int i = 0; i < listaTecnicos.size(); i++) {
            if (cboTecnicos.getSelectionModel().getSelectedItem().equals(listaTecnicos.get(i))) {
                lblTecnico.setText(listaTecnicos.get(i+1));
            }
        }
    }

    @FXML
    private void eliminarAsig(ActionEvent event) {
        obtenerCampos();
        con.eliminarAsignaciones(idAsig);
        con.consultarAsignaciones(tbAsignaciones);
    }
    
}
