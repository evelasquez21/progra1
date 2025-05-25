/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyectofinal.admin.vista;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
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
import proyectofinal.admin.modelo.Estados;
import proyectofinal.admin.modelo.Tickets;

/**
 * FXML Controller class
 *
 * @author eduar
 */
public class GestionTicketsController implements Initializable {

    @FXML
    private Button btnGenerarTicket;
    @FXML
    private TextField txtTituloTicket;
    @FXML
    private TextField txtDesTicket;
    @FXML
    private ComboBox<String> cboDeptoAsig;
    @FXML
    private ComboBox<String> cboNivelP;
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
    private Button btnCrearEstado;
    @FXML
    private Button btnEliminarEstado;
    @FXML
    private Button btnActualizarEstado;
    @FXML
    private TableColumn<Tickets, String> colNoTicket;
    @FXML
    private TableColumn<Tickets, String> colTituloT;
    @FXML
    private TableColumn<Tickets, String> colDesTicket;
    @FXML
    private TableColumn<Tickets, String> colDeptoAsig;
    @FXML
    private TableColumn<Tickets, String> colPrioridad;
    @FXML
    private TableColumn<Tickets, String> colFechaC;
    @FXML
    private TableColumn<Estados, String> colNivEstado;
    @FXML
    private TableColumn<Estados, String> colNomEstado;
    @FXML
    private TableColumn<Estados, String> colDesEstado;
    @FXML
    private TableView<Tickets> tbTicket;
    @FXML
    private TableView<Estados> tbEstados;
    
    private Conexion con = new Conexion();
    private String noTicket;
    private String tituloTicket;
    private String desTicket;
    private String deptoAsig;
    private String nivelP;
    private String nivelEstado;
    private String nombreEstado;
    private String desEstado;
    private ArrayList<String> listaDepartamentos = new ArrayList<String>();
    private ArrayList<String> listaPrioridades = new ArrayList<String>();
    @FXML
    private Label lblNivPrio;
    @FXML
    private Label lblDeptoAsig;
    
    
    public void obtenerCampos(){
        noTicket = txtNoTicket.getText();
        tituloTicket = txtTituloTicket.getText();
        desTicket = txtDesTicket.getText();
        deptoAsig = cboDeptoAsig.getSelectionModel().getSelectedItem();
        nivelP = cboNivelP.getSelectionModel().getSelectedItem();
        nivelEstado = txtNivelEstado.getText();
        nombreEstado = txtNombreEstado.getText();
        desEstado = txtDesEstado.getText();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        con.consultaTickets(tbTicket);
        
        con.listaDepartamentos(cboDeptoAsig, listaDepartamentos);
        con.listaPrioridad(cboNivelP, listaPrioridades);
        
        colNoTicket.setCellValueFactory(new PropertyValueFactory<>("noTicket"));
        colTituloT.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colDesTicket.setCellValueFactory(new PropertyValueFactory<>("desProblema"));
        colDeptoAsig.setCellValueFactory(new PropertyValueFactory<>("idDepartamento"));
        colPrioridad.setCellValueFactory(new PropertyValueFactory<>("idPrioridad"));
        colFechaC.setCellValueFactory(new PropertyValueFactory<>("fechaCreacion"));
        
        completarCampos1(tbTicket);
    }    

    @FXML
    private void GenerarTicket(ActionEvent event) {
        obtenerCampos();
        con.insertarTicket(tituloTicket, deptoAsig, nivelP, desTicket);
        con.consultaTickets(tbTicket);
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
    
    public void completarCampos1(TableView<Tickets> tableView){
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->{
            if (newSelection != null){
                txtNoTicket.setText(newSelection.getNoTicket());
                txtTituloTicket.setText(newSelection.getDescripcion());
                txtDesTicket.setText(newSelection.getDesProblema());
                String departamento = newSelection.getIdDepartamento();
                String prioridad = newSelection.getIdPrioridad();
                for (int i = 0; i < listaDepartamentos.size(); i++) {
                    if (departamento.equals(listaDepartamentos.get(i))) {
                        cboDeptoAsig.setValue(listaDepartamentos.get(i-1));
                    }
                }
                for (int i = 0; i < listaPrioridades.size(); i++) {
                    if (departamento.equals(listaPrioridades.get(i))) {
                        cboNivelP.setValue(listaPrioridades.get(i-1));
                    }
                }
            }
        });
    }
    
    public void completarCampos2(TableView<Estados> tableView){
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->{
            if (newSelection != null){
                txtNivelEstado.setText(newSelection.getNivelEstado());
                txtNombreEstado.setText(newSelection.getNombreEstado());
                txtDesEstado.setText(newSelection.getDescripcionEstado());
            }
        });
    }

    @FXML
    private void eliminarTicket(ActionEvent event) {
        obtenerCampos();
        con.eliminarTicket(noTicket);
        con.consultaTickets(tbTicket);
    }

    @FXML
    private void actualizarTicket(ActionEvent event) {
        obtenerCampos();
        con.actualizarTicket(noTicket, tituloTicket, deptoAsig, nivelP, desTicket);
        con.consultaTickets(tbTicket);
    }

    @FXML
    private void crearEstado(ActionEvent event) {
        obtenerCampos();
        con.insertarEstado(nivelEstado, nombreEstado, desEstado);
        con.consultaEstados(tbEstados);
    }

    @FXML
    private void eliminarEstado(ActionEvent event) {
        obtenerCampos();
        con.EliminarEstado(nivelEstado);
        con.consultaEstados(tbEstados);
    }

    @FXML
    private void actualizarEstado(ActionEvent event) {
        obtenerCampos();
        con.actualizarEstados(nivelEstado, nombreEstado, desEstado);
        con.consultaEstados(tbEstados);
    }

    @FXML
    private void MostrarEstados(Event event) {
        con.consultaEstados(tbEstados);
        colNivEstado.setCellValueFactory(new PropertyValueFactory<>("nivelEstado"));
        colNomEstado.setCellValueFactory(new PropertyValueFactory<>("nombreEstado"));
        colDesEstado.setCellValueFactory(new PropertyValueFactory<>("descripcionEstado"));
        
        completarCampos2(tbEstados);
    }

    @FXML
    private void mostrarDepto(ActionEvent event) {
        for (int i = 0; i < listaDepartamentos.size(); i++) {
            if (cboDeptoAsig.getSelectionModel().getSelectedItem().equals(listaDepartamentos.get(i))) {
                lblDeptoAsig.setText(listaDepartamentos.get(i+1));
            }
        }
    }

    @FXML
    private void MostrarPrioridad(ActionEvent event) {
        for (int i = 0; i < listaPrioridades.size(); i++) {
            if (cboNivelP.getSelectionModel().getSelectedItem().equals(listaPrioridades.get(i))) {
                lblNivPrio.setText(listaPrioridades.get(i+1));
            }
        }
    }
    
}
