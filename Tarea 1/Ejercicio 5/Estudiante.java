/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1progae5;

/**
 *
 * @author eduar
 */
class Estudiante {
    private String nombre;
    private String carnet;
    private int notaFinal;

    public Estudiante(String nombre, String carnet, int notaFinal) {
        this.nombre = nombre;
        this.carnet = carnet;
        setNotaFinal(notaFinal); // Validar y asignar la nota
    }

    public String getNombre() {
        return nombre;
    }

    public String getCarnet() {
        return carnet;
    }

    public int getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(int notaFinal) {
        if (notaFinal >= 0 && notaFinal <= 100) {
            this.notaFinal = notaFinal;
        } else {
            throw new IllegalArgumentException("La nota debe estar en el rango de 0 a 100.");
        }
    }

    public boolean haAprobado() {
        return notaFinal >= 61;
    }
}
