/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1prograe1;

/**
 *
 * @author eduar
 */
public class CuentaBancaria {
    private int noCuenta;
    private double saldoIncial;

    // Constructor
    public CuentaBancaria(int noCuenta, double saldoIncial) {
        this.noCuenta = noCuenta;
        this.saldoIncial = saldoIncial;
    }
    
    // Métodos
    public void depositar(double monto){
        if (monto > 0){
            this.saldoIncial = this.saldoIncial + monto;
        } else {
            System.err.println("No se puede depositar valores negativos");
        }
    }
    
    public void retirar(double monto){
        if (monto > 0){
            if (monto < this.saldoIncial){
                this.saldoIncial = this.saldoIncial - monto;
            } else {
                System.err.println("No es posbile la transaccion debido a que el monto a retirar es mayor al saldo de la cuenta");
            }
            
        } else {
            System.err.println("No se puede retirar valores negativos");
        }
    }
    
    public void consultarSaldo(){
        System.out.format("Numero de cuenta: %d Saldo: GTQ%.2f \n", this.noCuenta, this.saldoIncial);
    }
    
    public String toString(){
        return "Numero de cuenta: " + this.noCuenta + " Saldo: " + this.saldoIncial;
    }
}
