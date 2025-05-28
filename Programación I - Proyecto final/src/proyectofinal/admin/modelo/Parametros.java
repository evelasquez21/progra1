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
public class Parametros {
    private final SimpleStringProperty nombreEmpresa;
    private final SimpleStringProperty dirLogoEmpresa;
    private final SimpleStringProperty idioma;
    private final SimpleStringProperty zonaHoraria;
    private final SimpleStringProperty tiempoVencimientoTicket;
    
    public Parametros(String nombreEmpresa, String dirLogoEmpresa, String idioma, String zonaHoraria, String tiempoVencimientoTicket){
        this.nombreEmpresa = new SimpleStringProperty(nombreEmpresa);
        this.dirLogoEmpresa = new SimpleStringProperty(dirLogoEmpresa);
        this.idioma = new SimpleStringProperty(idioma);
        this.zonaHoraria = new SimpleStringProperty(zonaHoraria);
        this.tiempoVencimientoTicket = new SimpleStringProperty(tiempoVencimientoTicket);
    }
    
    public String getNombreEmpresa(){
        return nombreEmpresa.get();
    }
    
    public String getDirLogoEmpresa(){
        return dirLogoEmpresa.get();
    }
    
    public String getIdioma(){
        return idioma.get();
    }
    
    public String getZonaHoraria(){
        return zonaHoraria.get();
    }
    
    public String getTiempoVencimientoTicket(){
        return tiempoVencimientoTicket.get();
    }
}
