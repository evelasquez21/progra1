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
public class PermisosTabla {
    private final SimpleStringProperty id;
    private final SimpleStringProperty nombrePermiso;
    private final SimpleStringProperty descripcionPermiso;
    private final SimpleStringProperty idRol;
    
    public PermisosTabla(String id, String nombrePermiso, String descripcionPermiso, String idRol){
        this.id = new SimpleStringProperty(id);
        this.nombrePermiso = new SimpleStringProperty(nombrePermiso);
        this.descripcionPermiso = new SimpleStringProperty(descripcionPermiso);
        this.idRol = new SimpleStringProperty(idRol);
    }
    
    public String getId(){
        return id.get();
    }
    
    public String getNombrePermiso(){
        return nombrePermiso.get();
    }
    
    public String getDescripcionPermiso(){
        return descripcionPermiso.get();
    }
    
    public String getIdRol(){
        return idRol.get();
    }
    
}
