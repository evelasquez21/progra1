/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividadsemanal2;

/**
 *
 * @author eduar
 */
public class CuentaBancaria {
    private String numeroCuenta;
    private double saldo;
    private Cliente propietario;

    public CuentaBancaria(String numeroCuenta, double saldo, Cliente propietario) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.propietario = propietario;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getPropietario() {
        return propietario;
    }

    public void setPropietario(Cliente propietario) {
        this.propietario = propietario;
    }
    
    
    
    public void depositar(double monto){
        if (monto > 0){
            this.saldo = this.saldo + monto;
            System.out.println("Operacion exitosa.");
        }
    }
    
    public void reitar(double monto){
        if (monto < this.saldo){
            this.saldo = this.saldo - monto;
        } else {
            System.err.println("No hay saldo suficiente.");
        }
        
    }
    
    public void consultarSaldo(){
        System.out.format("El saldo de cuenta: GTQ%.2f\n", this.saldo);
    }
    
    @Override
    public String toString(){
        return "\nNo.Cuenta: " + this.numeroCuenta
                + "\nSaldo: GTQ" + this.saldo
                + "\nPropietario: " + this.propietario;
    }
}
