/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

import java.util.Date;

/**
 *
 * @author eduar
 */
public class Parametros {
    private String nombreEmpresa;
    private String dirLogoEmpresa;
    private String idioma;
    private String zonaHoraria;
    private Date tiempoVencimientoTicket;

    public Parametros(String nombreEmpresa, String dirLogoEmpresa, String idioma, String zonaHoraria, Date tiempoVencimientoTicket) {
        this.nombreEmpresa = nombreEmpresa;
        this.dirLogoEmpresa = dirLogoEmpresa;
        this.idioma = idioma;
        this.zonaHoraria = zonaHoraria;
        this.tiempoVencimientoTicket = tiempoVencimientoTicket;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDirLogoEmpresa() {
        return dirLogoEmpresa;
    }

    public void setDirLogoEmpresa(String dirLogoEmpresa) {
        this.dirLogoEmpresa = dirLogoEmpresa;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getZonaHoraria() {
        return zonaHoraria;
    }

    public void setZonaHoraria(String zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }

    public Date getTiempoVencimientoTicket() {
        return tiempoVencimientoTicket;
    }

    public void setTiempoVencimientoTicket(Date tiempoVencimientoTicket) {
        this.tiempoVencimientoTicket = tiempoVencimientoTicket;
    }
    
    
}
