/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

import proyectofinal.admin.modelo.Departamentos;
import java.util.Date;

/**
 *
 * @author eduar
 */
public class Ticket {
    private String noTicket;
    private String estadoTicket;
    private Date fechaCreacion;
    private Departamentos departamentoAsignado;
    private int prioridad;
    private String resumenProblema;

    public Ticket(String noTicket, String estadoTicket, Date fechaCreacion, Departamentos departamentoAsignado, int prioridad, String resumenProblema) {
        this.noTicket = noTicket;
        this.estadoTicket = estadoTicket;
        this.fechaCreacion = fechaCreacion;
        this.departamentoAsignado = departamentoAsignado;
        this.prioridad = prioridad;
        this.resumenProblema = resumenProblema;
    }

    public String getNoTicket() {
        return noTicket;
    }

    public void setNoTicket(String noTicket) {
        this.noTicket = noTicket;
    }

    public String getEstadoTicket() {
        return estadoTicket;
    }

    public void setEstadoTicket(String estadoTicket) {
        this.estadoTicket = estadoTicket;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Departamentos getDepartamentoAsignado() {
        return departamentoAsignado;
    }

    public void setDepartamentoAsignado(Departamentos departamentoAsignado) {
        this.departamentoAsignado = departamentoAsignado;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getResumenProblema() {
        return resumenProblema;
    }

    public void setResumenProblema(String resumenProblema) {
        this.resumenProblema = resumenProblema;
    }
    
    
    
}
