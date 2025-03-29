/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacion1clase3;

/**
 *
 * @author eduar
 */
public class Esudiante {
   private String nombre;
   private String apellido;
   private  int edad;
   private char sexo;
   private String carnet;
   private Curso [] cursosAsignados = new Curso[5];
   private int indice;
   
   public Esudiante(String nombre, String apellido, int edad, char sexo, String carnet){
       System.out.println("Ejecucion del constructor de Estudiante.");
       this.nombre = nombre;
       this.apellido = apellido;
       this.edad = edad;
       this.sexo = sexo;
       this.carnet = carnet;
       this.indice = 0;
   }
   
   public void setNombre(String nombre){
       this.nombre = nombre;
   }
   
   public void setApellido(String apellido){
       this.apellido = apellido;
   }
   
   public void setEdad(int edad){
       if (edad >= 0){
            this.edad = edad;
       } else {
           System.err.println("La edad debe de ser mayor o igual a 0");
       }
   }
   
   public void setSexo(char sexo){
       if (sexo == 'M' || sexo == 'F' || sexo == 'm' || sexo == 'f'){
            this.sexo = sexo;
       }       
   }
   
   public void setCarnet(String carnet){
       this.carnet = carnet;
   }
   
   public String getNombre(){
       return this.nombre.toUpperCase() + " " + this.apellido.toUpperCase();
   }
   
   public String getApellido(){
       return this.apellido;
   }
   
   public int getEdad(){
       return this.edad;
   }
   
   public char getSex(){
       return this.sexo;
   }
   
   public String getCarnet(){
       return this.carnet;
   }
   
   public void aprender(){
       System.out.println(nombre + " esta aprendiendo");
   }
   
   public void programar(){
       System.out.println(nombre + " esta programando");
   }
   
   public void asignar(Curso curso){
       curso.asignar(this);
       cursosAsignados[indice] = curso;
       indice++;
   }
   
   public void mostrarCursosAsignados(){
       for (int i = 0; i < indice; i++){
           System.out.println(cursosAsignados[i]);
       }
   }
   
   public String toString(){
       return "Carnet: " + this.carnet + " Nombre: " + this.nombre + "  Apellido: " + this.apellido;
   }
}
