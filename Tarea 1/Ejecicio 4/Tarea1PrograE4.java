/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea1prograe4;

/**
 *
 * @author eduar
 */
public class Tarea1PrograE4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Temporizador temporizador = new Temporizador();
        Alarma alarma = new Alarma(10);
        temporizador.setAlarma(alarma);
        temporizador.iniciarTemporizador();
    }
    
}
