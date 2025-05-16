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
public class UsuarioTabla {
    private final SimpleStringProperty id;
    private final SimpleStringProperty nombreCompleto;
    private final SimpleStringProperty nombreUsuario;
    private final SimpleStringProperty correoElectronico;
    private final SimpleStringProperty rol;

    public UsuarioTabla(String id, String nombreCompleto, String nombreUsuario, String correoElectronico, String rol) {
        this.id = new SimpleStringProperty(id);
        this.nombreCompleto = new SimpleStringProperty(nombreCompleto);
        this.nombreUsuario = new SimpleStringProperty(nombreUsuario);
        this.correoElectronico = new SimpleStringProperty(correoElectronico);
        this.rol = new SimpleStringProperty(rol);
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
    
    public String getCorreoElectronico(){
        return correoElectronico.get();
    }
    
   public String getRol(){
       return rol.get();
   }
    
}
