/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea1prograe3;

/**
 *
 * @author eduar
 */
public class Tarea1PrograE3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Producto producto = new Producto(1, "Pincel", 3.25f);
        
        System.out.println("Precio original: " + producto.getPrecio());
        
        // ingreso correcto
        producto.setPrecio(2.75);
        System.out.println("Nuevo precio: " + producto.getPrecio());
        
        // ingreso incorrecto
        producto.setPrecio(-2.50);
    }
    
}
