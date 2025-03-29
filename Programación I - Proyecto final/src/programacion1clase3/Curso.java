/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion1clase3;

/**
 *
 * @author eduar
 */
public class Curso {
    private int codigo;
    private String nombre;
    private String catedratico;
    private Esudiante [] listadoEstudiantes = new Esudiante[50];
    private int indice;
    
    public Curso(int codigo, String nombre, String catedratico){
        this.codigo = codigo;
        this.nombre = nombre;
        this.catedratico = catedratico;
        this.indice = 0;
    }
    
    // Getter's & Settetr's

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        if (codigo >= 0){
            this.codigo = codigo;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCatedratico() {
        return catedratico;
    }

    public void setCatedratico(String catedratico) {
        this.catedratico = catedratico;
    }

    public Esudiante[] getListadoEstudiantes() {
        return listadoEstudiantes;
    }

    public void setListadoEstudiantes(Esudiante[] listadoEstudiantes) {
        this.listadoEstudiantes = listadoEstudiantes;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
    
    public void asignar(Esudiante estudiante){
        listadoEstudiantes[indice] = estudiante;
        indice++;
    }
    
    
    public void MostrarEstudiantesAsignados(){
       for (int i = 0; i < indice; i++){
           System.out.println(listadoEstudiantes[i]);
       }
   }
    
    public String toString(){
       return "Codigo de curso: " + this.codigo + " Nombre: " + this.nombre + " Catedrático: " + this.catedratico;
   }
}
