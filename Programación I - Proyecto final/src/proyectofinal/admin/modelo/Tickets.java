/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal.admin.modelo;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author eduar
 */
public class Tickets {
    private final SimpleStringProperty noTicket;
    private final SimpleStringProperty descripcion;
    private final SimpleStringProperty idDepartamento;
    private final SimpleStringProperty idPrioridad;
    private final SimpleStringProperty fechaCreacion;
    private final SimpleStringProperty desProblema;

   public Tickets(String noTicket, String descripcion, String idDepartamento, String idPrioridad, String fechaCreacion, String desProblema){
       this.noTicket = new SimpleStringProperty(noTicket);
       this.descripcion = new SimpleStringProperty(descripcion);
       this.idDepartamento = new SimpleStringProperty(idDepartamento);
       this.idPrioridad = new SimpleStringProperty(idPrioridad);
       this.fechaCreacion = new SimpleStringProperty(fechaCreacion);
       this.desProblema = new SimpleStringProperty(desProblema);
   }
   
   public String getNoTicket(){
       return noTicket.get();
   }
   
   public String getDescripcion(){
       return descripcion.get();
   }
   
   public String getIdDepartamento(){
       return idDepartamento.get();
   }
   
   public String getIdPrioridad(){
       return idPrioridad.get();
   }
   
   public String getFechaCreacion(){
       return fechaCreacion.get();
   }
   
   public String getDesProblema(){
       return desProblema.get();
   }

    
}
