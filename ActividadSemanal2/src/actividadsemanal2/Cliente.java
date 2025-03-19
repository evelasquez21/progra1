/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividadsemanal2;

/**
 *
 * @author eduar
 */
public class Cliente {
    private String nombre;
    private String dpi;
    private String direccion;

    public Cliente(String nombre, String dpi, String direccion) {
        this.nombre = nombre;
        this.dpi = dpi;
        this.direccion = direccion;
    }
    
    
    public void mostrarDatos(){
        System.out.println(
                "Nombre: "+ this.nombre
                + " DPI:" + this.dpi
                + " Direccion: " + this.direccion
        );
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
}
