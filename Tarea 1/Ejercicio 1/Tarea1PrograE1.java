/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea1prograe1;

/**
 *
 * @author eduar
 */
public class Tarea1PrograE1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CuentaBancaria cuenta1 = new CuentaBancaria(12345, 2000.00f);
        
        cuenta1.consultarSaldo();
        
        // retiro
        cuenta1.retirar(200.00);
        cuenta1.consultarSaldo();
        
        // deposito
        cuenta1.depositar(650.00);
        cuenta1.consultarSaldo();
        
        // prueba de valores negativos
        cuenta1.retirar(4000.00);
        cuenta1.retirar(-300.00);
        cuenta1.depositar(-300.00);
        
        cuenta1.consultarSaldo();
    }
    
}
