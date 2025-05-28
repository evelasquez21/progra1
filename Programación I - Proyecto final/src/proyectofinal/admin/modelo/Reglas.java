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
public class Reglas {
    private final SimpleStringProperty id;
    private final SimpleStringProperty nombreRegla;
    private final SimpleStringProperty descripcionRegla;
    
    public Reglas(String id, String nombreRegla, String descripcionRegla){
        this.id = new SimpleStringProperty(id);
        this.nombreRegla = new SimpleStringProperty(nombreRegla);
        this.descripcionRegla = new SimpleStringProperty(descripcionRegla);
    }
    
    public String getId(){
        return id.get();
    }
    
    public String getNombreRegla(){
        return nombreRegla.get();
    }
    
    public String getDescripcionRegla(){
        return descripcionRegla.get();
    }
}
