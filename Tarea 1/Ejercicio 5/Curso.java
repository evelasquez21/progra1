/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1progae5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eduar
 */
class Curso {
    private List<Estudiante> estudiantes;

    public Curso() {
        this.estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public double calcularPromedio() {
        if (estudiantes.isEmpty()) {
            return 0;
        }
        int sumaNotas = 0;
        for (Estudiante estudiante : estudiantes) {
            sumaNotas += estudiante.getNotaFinal();
        }
        return (double) sumaNotas / estudiantes.size();
    }

    public List<Estudiante> obtenerEstudiantesAprobados() {
        List<Estudiante> aprobados = new ArrayList<>();
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.haAprobado()) {
                aprobados.add(estudiante);
            }
        }
        return aprobados;
    }
}
