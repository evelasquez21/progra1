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
public class Pendiente {
    private final SimpleStringProperty idPendiente;
    private final SimpleStringProperty noTicket;
    private final SimpleStringProperty nombreEstado;
    private final SimpleStringProperty fechaCreacion;
    private final SimpleStringProperty nombreDepartamento;
    private final SimpleStringProperty nombrePrioridad;
    private final SimpleStringProperty desProblema;
    
    public Pendiente(String idPendiente, String noTicket, String nombreEstado, String fechaCreacion, String nombreDepartamento, String nombrePrioridad, String desProblema){
        this.idPendiente = new SimpleStringProperty(idPendiente);
        this.noTicket = new SimpleStringProperty(noTicket);
        this.nombreEstado = new SimpleStringProperty(nombreEstado);
        this.fechaCreacion = new SimpleStringProperty(fechaCreacion);
        this.nombreDepartamento = new SimpleStringProperty(nombreDepartamento);
        this.nombrePrioridad = new SimpleStringProperty(nombrePrioridad);
        this.desProblema = new SimpleStringProperty(desProblema);
    }
    
    public String getIdPendiente(){
        return idPendiente.get();
    }
    
    public String getNoTicket(){
        return noTicket.get();
    }
    
    public String getNombreEstado(){
        return nombreEstado.get();
    }
    
    public String getFechaCreacion(){
        return fechaCreacion.get();
    }
    
    public String getNombreDepartamento(){
        return nombreDepartamento.get();
    }
    
    public String getNombrePrioridad(){
        return nombrePrioridad.get();
    }
    
    public String getDesProblema(){
        return desProblema.get();
    }
}
