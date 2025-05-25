/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal.admin.modelo;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author eduar
 */
public class Estados {
    private final SimpleStringProperty nivelEstado;
    private final SimpleStringProperty nombreEstado;
    private final SimpleStringProperty descripcionEstado;
    
    public Estados(String nivelEstado, String nombreEstado, String descripcionEstado){
        this.nivelEstado = new SimpleStringProperty(nivelEstado);
        this.nombreEstado = new SimpleStringProperty(nombreEstado);
        this.descripcionEstado = new SimpleStringProperty(descripcionEstado);
    }
    
    public String getNivelEstado(){
        return nivelEstado.get();
    }
    
    public String getNombreEstado(){
        return nombreEstado.get();
    }
    
    public String getDescripcionEstado(){
        return descripcionEstado.get();
    }
    
}
