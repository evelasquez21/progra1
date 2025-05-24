/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package proyectofinal.admin;

import java.io.File;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import proyectofinal.Conexion;
import proyectofinal.admin.modelo.*;

/**
 * FXML Controller class
 *
 * @author eduar
 */
public class ConfigParametrosController implements Initializable {

    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnsubirImagen;
    @FXML
    private TextField txtNombreEmp;
    @FXML
    private ComboBox<String> cboIdioma;
    @FXML
    private ComboBox<String> cboZonaHoraria;
    @FXML
    private TextField txtIdPrioridad;
    @FXML
    private TextField txtNomPrioridad;
    @FXML
    private Button btnAgregarP;
    @FXML
    private Button btnEliminarP;
    @FXML
    private Button btnActualizarP;
    @FXML
    private TextField txtTiempoVen;
    @FXML
    private TableColumn<Prioridades, String> colIdPrio;
    @FXML
    private TableColumn<Prioridades, Prioridades> colNombrePrio;
    @FXML
    private TableView<Prioridades> tbPrioridades;
    @FXML
    private ImageView imgViewEmp;

    @FXML
    private void guardarCambios(ActionEvent event) {
        obtenerCampos();
        con.actualizarDatosEmpresa(nombreEmp, idioma, zonaHoraria, tiempoVen);
    }
    
    // variables
    private Conexion con = new Conexion();
    private String idPrioridad;
    private String nombrePrioridad;
    private String nombreEmp;
    private String idioma;
    private String zonaHoraria;
    private String tiempoVen;
    private String dirLogoEmpresa;
    private ArrayList<String> datos = new ArrayList<String>();
    private Stage stage;
    
    public void obtenerCampos(){
        idPrioridad = txtIdPrioridad.getText();
        nombrePrioridad = txtNomPrioridad.getText();
        nombreEmp = txtNombreEmp.getText();
        idioma = cboIdioma.getSelectionModel().getSelectedItem();
        zonaHoraria = cboZonaHoraria.getSelectionModel().getSelectedItem();
        tiempoVen = txtTiempoVen.getText();
    }
    
    public void setStage(Stage stage){
        this.stage = stage;
    }
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        colIdPrio.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombrePrio.setCellValueFactory(new PropertyValueFactory<>("nombrePrioridad"));
        
        con.consultarPrioridades(tbPrioridades);
        
        ObservableList<String> idiomas = FXCollections.observableArrayList();
        idiomas.add("Español");
        idiomas.add("English");
        idiomas.add("Português");
        idiomas.add("Français");
        idiomas.add("Deutsch");
        cboIdioma.setItems(idiomas);
        
        ObservableList<String> zonasHorarias = FXCollections.observableArrayList();
        zonasHorarias.add("GMT-12"); zonasHorarias.add("GMT-11"); zonasHorarias.add("GMT-10"); zonasHorarias.add("GMT-9"); zonasHorarias.add("GMT-8");
        zonasHorarias.add("GMT-7"); zonasHorarias.add("GMT-6"); zonasHorarias.add("GMT-5"); zonasHorarias.add("GMT-4"); zonasHorarias.add("GMT-3");
        zonasHorarias.add("GMT-2"); zonasHorarias.add("GMT-1"); zonasHorarias.add("GMT+0"); zonasHorarias.add("GMT+1"); zonasHorarias.add("GMT+2");
        zonasHorarias.add("GMT+3"); zonasHorarias.add("GMT+4"); zonasHorarias.add("GMT+5"); zonasHorarias.add("GMT+6"); zonasHorarias.add("GMT+7");
        zonasHorarias.add("GMT+8"); zonasHorarias.add("GMT+9"); zonasHorarias.add("GMT+10"); zonasHorarias.add("GMT+11"); zonasHorarias.add("GMT+12");
        cboZonaHoraria.setItems(zonasHorarias);
        
        con.obtenerDatosEmpresa(datos);
        txtNombreEmp.setText(datos.get(0));
        cboIdioma.setValue(datos.get(1));
        cboZonaHoraria.setValue(datos.get(2));
        txtTiempoVen.setText(datos.get(3));
        
        completarCampos(tbPrioridades);
        con.mostrarImagen(imgViewEmp);
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
     
     public void completarCampos(TableView<Prioridades> tableView){
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->{
            if (newSelection != null){
                txtIdPrioridad.setText(newSelection.getId());
                txtNomPrioridad.setText(newSelection.getNombrePrioridad());
            }
        });
    }
     
     private void seleccionarImagen(Stage stage){
         FileChooser fileChooser = new FileChooser();
         fileChooser.setTitle("Selecciona una imagen");
         fileChooser.getExtensionFilters().addAll(
                 new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg", "*.gif")
         );
         
         File archivo = fileChooser.showOpenDialog(stage);
         if (archivo != null){
            Image imagen = new Image(archivo.toURI().toString());
            imgViewEmp.setImage(imagen);
            con.guardarImagen(archivo);
         }
         
     }


    @FXML
    private void subirImagen(ActionEvent event) {
        seleccionarImagen(stage);
    }

    @FXML
    private void agregarP(ActionEvent event) {
        obtenerCampos();
        con.insertarPrioridades(idPrioridad, nombrePrioridad);
        con.consultarPrioridades(tbPrioridades);
    }

    @FXML
    private void eliminarP(ActionEvent event) {
        obtenerCampos();
        con.eliminarPrioridad(idPrioridad);
        con.consultarPrioridades(tbPrioridades);
    }

    @FXML
    private void actualizarP(ActionEvent event) {
        obtenerCampos();
        con.actualizarPrioridad(idPrioridad, nombrePrioridad);
        con.consultarPrioridades(tbPrioridades);
    }

    
    
}
