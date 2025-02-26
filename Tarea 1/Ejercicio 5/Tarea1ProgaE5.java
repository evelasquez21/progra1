/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea1progae5;

import java.util.List;

/**
 *
 * @author eduar
 */
public class Tarea1ProgaE5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Curso curso = new Curso();

        // Registrar estudiantes
        curso.agregarEstudiante(new Estudiante("Eduardo", "12345", 93));
        curso.agregarEstudiante(new Estudiante("Alejandro", "67890", 61));
        curso.agregarEstudiante(new Estudiante("Pablo", "54321", 60));
        curso.agregarEstudiante(new Estudiante("Luis", "09876", 90));

        // Calcular el promedio del curso
        double promedio = curso.calcularPromedio();
        System.out.println("Promedio del curso: " + promedio);

        // Obtener y mostrar los estudiantes que aprobaron
        List<Estudiante> aprobados = curso.obtenerEstudiantesAprobados();
        System.out.println("Estudiantes que aprobaron:");
        for (Estudiante estudiante : aprobados) {
            System.out.println(estudiante.getNombre() + " (Carnet: " + estudiante.getCarnet() + ")");
        }
    }
    
}
