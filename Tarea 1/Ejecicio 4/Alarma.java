/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1prograe4;

/**
 *
 * @author eduar
 */
public class Alarma {
    private int tiempoObjetivo;
    
    // constructor
    public Alarma(int tiempoObjetivo){
        this.tiempoObjetivo = tiempoObjetivo;
    }
    
    public int getTiempoObjetivo(){
        return tiempoObjetivo;
    }
    
    // Activación de alarma
    public void activar(){
        System.out.println("¡Atención!. Se ha alcanzado el tiempo objetivo.");
    }
}
