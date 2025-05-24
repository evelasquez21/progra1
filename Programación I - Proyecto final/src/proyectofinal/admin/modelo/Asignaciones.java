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
public class Asignaciones {
    private final SimpleStringProperty id;
    private final SimpleStringProperty nombreCompleto;
    private final SimpleStringProperty nombreUsuario;
    private final SimpleStringProperty nombreDepto;
            
    public Asignaciones(String id, String nombreCompleto, String nombreUsuario, String nombreDepto){
        this.id = new SimpleStringProperty(id);
        this.nombreCompleto = new SimpleStringProperty(nombreCompleto);
        this.nombreUsuario = new SimpleStringProperty(nombreUsuario);
        this.nombreDepto = new SimpleStringProperty(nombreDepto);
    }
    
    public String getId(){
        return id.get();
    }
    
    public String getNombreCompleto(){
        return nombreCompleto.get();
    }
    
    public String getNombreUsuario(){
        return nombreUsuario.get();
    }
    
    public String getNombreDepto(){
        return nombreDepto.get();
    }
}
