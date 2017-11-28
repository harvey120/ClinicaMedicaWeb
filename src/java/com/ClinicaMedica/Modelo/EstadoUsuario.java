package com.ClinicaMedica.Modelo;
/**
 * @author Erick
 */

public class EstadoUsuario {
    private int idEstadoUsuario;
    private String tipoEstado;
    
    public EstadoUsuario(){
        this.idEstadoUsuario=0;
        this.tipoEstado="";
    }

    public int getIdEstadoUsuario() {
        return idEstadoUsuario;
    }

    public void setIdEstadoUsuario(int idEstadoUsuario) {
        this.idEstadoUsuario = idEstadoUsuario;
    }

    public String getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(String tipoEstado) {
        this.tipoEstado = tipoEstado;
    }
    
    
}
