/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1prograe4;

/**
 *
 * @author eduar
 */
public class Temporizador {
    private int tiempoActual;
    private Alarma alarma;
    
    public void iniciarTemporizador(){
        this.tiempoActual = 0;
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            
            // incremento de tiempo
            this.tiempoActual++;
            System.out.println(this.tiempoActual + "S");
            
            // Verificación de activación de la alarma
            if (alarma != null && alarma.getTiempoObjetivo() == tiempoActual){
                alarma.activar();
                break;
            }
        }
    }
    
    public void setAlarma(Alarma alarma){
        this.alarma = alarma;
    }
}
