/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividadsemanal2;

/**
 *
 * @author eduar
 */
public class Banco {
    private String nombre;
    private CuentaBancaria [] listaCuentas = new CuentaBancaria[20];
    private int indice;

    public Banco(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregarCuenta(CuentaBancaria cuenta){
        this.listaCuentas[indice] = cuenta;
        indice++;
    }
    
    public void mostrarCuentas(){
        for (int i = 0; i < indice; i++) {
            System.out.println(this.listaCuentas[i]);
        }
    }
}
