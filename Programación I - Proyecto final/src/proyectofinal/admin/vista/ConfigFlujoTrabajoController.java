/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyectofinal.admin.vista;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
import proyectofinal.admin.modelo.FlujoTrabajos;
import proyectofinal.admin.modelo.Reglas;

/**
 * FXML Controller class
 *
 * @author eduar
 */
public class ConfigFlujoTrabajoController implements Initializable {

    @FXML
    private Button btnAgregar;
    @FXML
    private TextField txtNombreFlujo;
    @FXML
    private ComboBox<String> cboEstados;
    @FXML
    private ComboBox<String> cboReglas;
    @FXML
    private TableView<FlujoTrabajos> tbFlujoTrabajo;
    @FXML
    private TextField txtIdFlujo;
    @FXML
    private Button btnActualizarUsuario;
    @FXML
    private Button btnEliminarFlujo;
    @FXML
    private Label lblRegla;
    @FXML
    private Label lblEstado;
    @FXML
    private TableView<Reglas> tbReglas;
    @FXML
    private TextField txtRegla;
    @FXML
    private TextField txtNombreRegla;
    @FXML
    private TextField txtDesRegla;
    @FXML
    private Button btnAgregarRegla;
    @FXML
    private Button btnActualizarRegla;
    @FXML
    private Button btnEliminarRegla;
    @FXML
    private TableColumn<FlujoTrabajos, String> colIdFlujo;
    @FXML
    private TableColumn<FlujoTrabajos, String> colNomFlujo;
    @FXML
    private TableColumn<FlujoTrabajos, String> colEstadoF;
    @FXML
    private TableColumn<FlujoTrabajos, String> colReglaF;
    @FXML
    private TableColumn<Reglas, String> colIdRegla;
    @FXML
    private TableColumn<Reglas, String> colNomRegla;
    @FXML
    private TableColumn<Reglas, String> colDesRegla;
    
    private Conexion con = new Conexion();
    private String idFlujo;
    private String nomFlujo;
    private String estadoF;
    private String reglF;
    private String idRegla;
    private String nomRegla;
    private String desRegla;
    private ArrayList<String> listaReglas = new ArrayList<String>();
    private ArrayList<String> listaEstado = new ArrayList<String>();
    
    private void obtenerCampos(){
        idFlujo = txtIdFlujo.getText();
        nomFlujo = txtNombreFlujo.getText();
        estadoF = cboEstados.getSelectionModel().getSelectedItem();
        reglF = cboReglas.getSelectionModel().getSelectedItem();
        idRegla = txtRegla.getText();
        nomRegla = txtNombreRegla.getText();
        desRegla = txtDesRegla.getText();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        con.consultarFlujo(tbFlujoTrabajo);
        
        colIdFlujo.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNomFlujo.setCellValueFactory(new PropertyValueFactory<>("nombreFlujo"));
        colEstadoF.setCellValueFactory(new PropertyValueFactory<>("nivelEstado"));
        colReglaF.setCellValueFactory(new PropertyValueFactory<>("idRegla"));
        
        
        con.listaEstados(cboEstados, listaEstado);
        con.listaReglas(cboReglas, listaReglas);
        completarCampos1(tbFlujoTrabajo);
    }    

    @FXML
    private void agregarFlujo(ActionEvent event) {
        obtenerCampos();
        con.insertarFlujo(nomFlujo, estadoF, reglF);
        con.consultarFlujo(tbFlujoTrabajo);
    }
    
    
    public void closeWindows() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminMenu.fxml"));
        
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        Stage stage = new Stage(); 
        
        stage.setScene(scene);
        stage.show();
        
        Stage myStage = (Stage) this.btnAgregar.getScene().getWindow();
        myStage.close();        
    }
    
    public void completarCampos1(TableView<FlujoTrabajos> tableView){
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->{
            if (newSelection != null){
                txtIdFlujo.setText(newSelection.getId());
                txtNombreFlujo.setText(newSelection.getNombreFlujo());
                String estado = newSelection.getNivelEstado();
                String regla = newSelection.getIdRegla();
                for (int i = 0; i < listaEstado.size(); i++) {
                    if (estado.equals(listaEstado.get(i))) {
                        cboEstados.setValue(listaEstado.get(i-1));
                    }
                }
                for (int i = 0; i < listaReglas.size(); i++) {
                    if (regla.equals(listaReglas.get(i))) {
                        cboReglas.setValue(listaReglas.get(i-1));
                    }
                }
            }
        });
    }
    
    public void completarCampos2(TableView<Reglas> tableView){
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->{
            if (newSelection != null){
                txtRegla.setText(newSelection.getId());
                txtNombreRegla.setText(newSelection.getNombreRegla());
                txtDesRegla.setText(newSelection.getDescripcionRegla());
            }
        });
    }

    @FXML
    private void actualizarFlujo(ActionEvent event) {
        obtenerCampos();
        con.actualizarFlujo(idFlujo, nomFlujo, estadoF, reglF);
        con.consultarFlujo(tbFlujoTrabajo);
    }

    @FXML
    private void eliminarFlujo(ActionEvent event) {
        obtenerCampos();
        con.EliminarFlujo(idFlujo);
        con.consultarFlujo(tbFlujoTrabajo);
    }

    @FXML
    private void actualizarRegla(ActionEvent event) {
        obtenerCampos();
        con.actualizarRegla(idRegla, nomRegla, desRegla);
        con.consultarReglas(tbReglas);
        con.consultarFlujo(tbFlujoTrabajo);
        con.listaReglas(cboReglas, listaReglas);
    }

    @FXML
    private void eliminarRegla(ActionEvent event) {
        obtenerCampos();
        con.EliminarRegla(idRegla);
        con.consultarReglas(tbReglas);
        con.consultarFlujo(tbFlujoTrabajo);
        con.listaReglas(cboReglas, listaReglas);
    }

    @FXML
    private void MostrarNomEstado(ActionEvent event) {
        for (int i = 0; i < listaEstado.size(); i++) {
            if (cboEstados.getSelectionModel().getSelectedItem().equals(listaEstado.get(i))) {
                lblEstado.setText(listaEstado.get(i+1));
            }
        }
    }

    @FXML
    private void MostrarNomR(ActionEvent event) {
        for (int i = 0; i < listaReglas.size(); i++) {
            if (cboReglas.getSelectionModel().getSelectedItem().equals(listaReglas.get(i))) {
                lblRegla.setText(listaReglas.get(i+1));
            }
        }
    }

    @FXML
    private void MostrarReglasP(Event event) {
        con.consultarReglas(tbReglas);
        
        colIdRegla.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNomRegla.setCellValueFactory(new PropertyValueFactory<>("nombreRegla"));
        colDesRegla.setCellValueFactory(new PropertyValueFactory<>("descripcionRegla"));
        completarCampos2(tbReglas);
       
    }

    @FXML
    private void agregarRegla(ActionEvent event) {
        obtenerCampos();
        con.insertarRegla(nomRegla, desRegla);
        con.consultarReglas(tbReglas);
        con.listaReglas(cboReglas, listaReglas);
    }
    
}
