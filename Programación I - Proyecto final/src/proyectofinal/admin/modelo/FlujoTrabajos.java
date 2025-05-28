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
public class FlujoTrabajos {
    private final SimpleStringProperty id;
    private final SimpleStringProperty nombreFlujo;
    private final SimpleStringProperty nivelEstado;
    private final SimpleStringProperty idRegla;
    
    public FlujoTrabajos(String id, String nombreFlujo, String nivelEstado, String idRegla){
        this.id = new SimpleStringProperty(id);
        this.nombreFlujo = new SimpleStringProperty(nombreFlujo);
        this.nivelEstado = new SimpleStringProperty(nivelEstado);
        this.idRegla = new SimpleStringProperty(idRegla);
    }
    
    public String getId(){
        return id.get();
    }
    
    public String getNombreFlujo(){
        return nombreFlujo.get();
    }
    
    public String getNivelEstado(){
        return nivelEstado.get();
    }
    
    public String getIdRegla(){
        return idRegla.get();
    }
}
