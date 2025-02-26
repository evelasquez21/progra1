/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1prograe3;

/**
 *
 * @author eduar
 */
public class Producto {
    private int codigoProducto;
    private String nombre;
    private double precio;
    
    // constructor
    public Producto(int codigoProducto, String nombre, double precio){
       this.codigoProducto = codigoProducto;
       this.nombre = nombre;
       this.precio = precio;
    }
    
    public void setPrecio(double precio){
        if (precio > 0){
            this.precio = precio;
        } else {
            System.err.println("No se puede asignar un precio negativo al producto");
        }
        
    }

    public double getPrecio() {
        return precio;
    }
}
