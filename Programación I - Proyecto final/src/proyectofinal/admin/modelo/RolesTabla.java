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
public class RolesTabla {
    private final SimpleStringProperty id;
    private final SimpleStringProperty nombreRol;
    private final SimpleStringProperty tipoAcceso;
    private final SimpleStringProperty descripcionRol;
    
    public RolesTabla(String id, String nombreRol, String descripcionRol, String tipoAcceso){
        this.id = new SimpleStringProperty(id);
        this.nombreRol = new SimpleStringProperty(nombreRol);
        this.descripcionRol = new SimpleStringProperty(descripcionRol);
        this.tipoAcceso = new SimpleStringProperty(tipoAcceso);
    }
    
    public String getId(){
        return id.get();
    }
    
    public String getNombreRol(){
        return nombreRol.get();
    }
    
    public String getDescripcionRol(){
        return descripcionRol.get();
    }
    
    public String getTipoAcceso(){
        return tipoAcceso.get();
    }
    
    
}
