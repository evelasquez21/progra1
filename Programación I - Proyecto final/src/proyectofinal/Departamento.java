/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

/**
 *
 * @author eduar
 */
public class Departamento {
    private String nombreDepartamento;
    private String descripcionDepartamento;
    private Tecnicos [] listaTecnicos;
    private int indice;

    public Departamento(String nombreDepartamento, String descripcionDepartamento, Tecnicos[] listaTecnicos) {
        this.nombreDepartamento = nombreDepartamento;
        this.descripcionDepartamento = descripcionDepartamento;
        this.listaTecnicos = listaTecnicos;
    }
    
    public void asignarTecnico(Tecnicos tecnico){
        
    }
}
