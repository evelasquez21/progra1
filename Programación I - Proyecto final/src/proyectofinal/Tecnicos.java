/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

/**
 *
 * @author eduar
 */
public class Tecnicos extends Usuarios{
    
    public Tecnicos(String nombreCompleto, String correoElectronico, String nombreUsuario, String password, Roles rolAsignado) {
        super(nombreCompleto, correoElectronico, nombreUsuario, password, rolAsignado);
    }
    
    public void asignarDepartamento(Departamento departamento){
        
    }
    
}
