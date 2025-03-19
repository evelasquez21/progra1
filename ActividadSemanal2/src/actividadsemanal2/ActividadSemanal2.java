/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividadsemanal2;

/**
 *
 * @author eduar
 */
public class ActividadSemanal2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente c1 = new Cliente("Eduardo", "303020717", "KM22 Crta. Ciudad Quetzal");
        c1.mostrarDatos();
        Cliente c2 = new Cliente("Carlos", "309577721", "Zona 4 de mixco");
        c2.mostrarDatos();
        
        
        CuentaBancaria cb1 = new CuentaBancaria("123456", 300, c1);
        cb1.consultarSaldo();
        CuentaBancaria cb2 = new CuentaBancaria("789123", 900, c2);
        cb2.consultarSaldo();
        
        
        Banco b1 = new Banco("PROMERICA");
        b1.agregarCuenta(cb1);
        b1.agregarCuenta(cb2);
        b1.mostrarCuentas();
        
        cb1.depositar(200);
        cb1.reitar(50000);
        cb1.consultarSaldo();
    }
    
}
