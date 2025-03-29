/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programacion1clase3;

/**
 *
 * @author eduar
 */
public class Programacion1Clase3 {

    /**
     * @param args the command line arguments
     */
    
    // EN PROGRAMACIÓN 1, TODOS LOS ATRIBUTOS SON PRIVADOS Y TODOS LOS METODOS SON PUBLICOS
    
    public static void main(String[] args) {
        Esudiante estudiante1 = new Esudiante("Eduardo", "Velasquez", 20, 'M', "7590-24-13687");
        Esudiante estudiante2 = new Esudiante("Carlos", "Marroquin", 22, 'M', "7590-24-14812");
        
        Curso curso1 = new Curso(12, "Programacion 1", "Miguel Catalan");
        Curso curso2 = new Curso(6, "Fisica 1", "Gabriel Catalan");
        
        Salon salon1 = new Salon(202, "INED", 35);
        Salon salon2 = new Salon(201, "INED", 35);
        
        estudiante1.asignar(curso1);
        estudiante1.asignar(curso2);
        
        
        estudiante2.asignar(curso1);
        /*
        estudiante1.mostrarCursosAsignados();
        
        curso1.MostrarEstudiantesAsignados();
        */
        
        salon1.MostarCursoSalon();
        
        estudiante1.setEdad(0);
        System.out.println(estudiante1.getEdad());
        
        estudiante1.setNombre("Leo");
        System.out.println(estudiante1.getNombre());
        
        estudiante1.setSexo('m');
        System.out.println(estudiante1.getSex());
        
        curso1.setCodigo(-324);
        System.out.println(curso1.getCodigo());
        
        salon1.setNumero(-23);
        System.out.println(salon1.getNumero());
    }
    
}
