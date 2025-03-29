/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion1clase3;

/**
 *
 * @author eduar
 */
public class Salon {
    private int numero;
    private String ubicacion;
    private int capacidad;
    private Curso [] listadoCursos = new Curso[5];
    private int indice;
    
    public Salon(int numero, String ubicacion, int capacidad){
        this.numero = numero;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.indice = 0;
    }
    
    void MostarCursoSalon(){
       for (int i = 0; i < indice; i++){
           System.out.println(listadoCursos[i]);
       }
   }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (numero >= 0){
            this.numero = numero;
        }
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        if (capacidad >= 0){
            this.capacidad = capacidad;
        }
    }

    public Curso[] getListadoCursos() {
        return listadoCursos;
    }

    public void setListadoCursos(Curso[] listadoCursos) {
        this.listadoCursos = listadoCursos;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
    
    
    public String toString(){
       return "Numero : " + this.numero + " Ubicacion: " + this.ubicacion + " Capacidad: " + this.capacidad;
   }
}
