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
public class Prioridades {
    private final SimpleStringProperty id;
    private final SimpleStringProperty nombrePrioridad;
    
    public Prioridades(String id, String nombrePrioridad){
        this.id = new SimpleStringProperty(id);
        this.nombrePrioridad = new SimpleStringProperty(nombrePrioridad);
    }
    
    public String getId(){
        return id.get();
    }
    
    public String getNombrePrioridad(){
        return nombrePrioridad.get();
    }
}
