package com.ClinicaMedica.Modelo;

/**
 * @author Erick
 */

public class Usuarios {
    private int idUsuario;
    private String Usuario;
    private String Contrasenia;
    private int idEstadoUsuario ;
    private int idEmpleado;
    
    public Usuarios(){
        this.idUsuario=0;
        this.Usuario="";
        this.Contrasenia="";
        this.idEstadoUsuario=0;
        this.idEmpleado=0;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public int getIdEstadoUsuario() {
        return idEstadoUsuario;
    }

    public void setIdEstadoUsuario(int idEstadoUsuario) {
        this.idEstadoUsuario = idEstadoUsuario;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String Contrasenia) {
        this.Contrasenia = Contrasenia;
    }
        
}
