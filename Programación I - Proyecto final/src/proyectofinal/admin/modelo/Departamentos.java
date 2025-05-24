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
public class Departamentos {
    private final SimpleStringProperty idDepto;
    private final SimpleStringProperty nombreDepartamento;
    private final SimpleStringProperty descripcionDepartamento;

    public Departamentos(String idDepto, String nombreDepartamento, String descripcionDepartamento){
        this.idDepto = new SimpleStringProperty(idDepto);
        this.nombreDepartamento = new SimpleStringProperty(nombreDepartamento);
        this.descripcionDepartamento = new SimpleStringProperty(descripcionDepartamento);
    }
    
    public String getIdDepto(){
        return idDepto.get();
    }
    
    public String getNombreDepartamento(){
        return nombreDepartamento.get();
    }
    
    public String getDescripcionDepartamento(){
        return descripcionDepartamento.get();
    }
}
