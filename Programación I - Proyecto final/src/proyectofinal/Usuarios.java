/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

/**
 *
 * @author eduar
 */
public class Usuarios {
    private String nombreCompleto;
    private String correoElectronico;
    private String nombreUsuario;
    private String password;
    private Roles rolAsignado;

    public Usuarios(String nombreCompleto, String correoElectronico, String nombreUsuario, String password, Roles rolAsignado) {
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.rolAsignado = rolAsignado;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRolAsignado() {
        return rolAsignado;
    }

    public void setRolAsignado(Roles rolAsignado) {
        this.rolAsignado = rolAsignado;
    }
    
    
    
}
