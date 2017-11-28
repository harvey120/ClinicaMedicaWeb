package com.ClinicaMedica.VistaModelo;

/**
 * @author Harvey
 */
public class VistaEmpleado {

    // objetos de la tabla persona
    private int idPersona;
    private String nombre;
    private String apellido;
    private String fechaNac;
    private String telefono;
    private String correoElectronico;
    private int idGenero;
    private int idEstadoCivil;
    private int idNoIdentificacion;
    private String noIdentificacion;
    private int idReligion;
    // objetos de la tabla empleado
    private int idEmpleado;
    private int idEspecialidad;
    private String consultorio;
    private String estado;
    private int idPuesto;

    // constructor de la clase
    public VistaEmpleado() {
        this.idPersona = 0;
        this.nombre = "";
        this.apellido = "";
        this.fechaNac = "";
        this.telefono = "";
        this.correoElectronico = "";
        this.idGenero = 0;
        this.idEstadoCivil = 0;
        this.idNoIdentificacion = 0;
        this.noIdentificacion = "";
        this.idReligion = 0;

        this.idEmpleado = 0;
        this.idEspecialidad = 0;
        this.consultorio = "";
        this.estado = "";
        this.idPuesto = 0;

    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public int getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(int idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public int getIdNoIdentificacion() {
        return idNoIdentificacion;
    }

    public void setIdNoIdentificacion(int idNoIdentificacion) {
        this.idNoIdentificacion = idNoIdentificacion;
    }

    public String getNoIdentificacion() {
        return noIdentificacion;
    }

    public void setNoIdentificacion(String noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }

    public int getIdReligion() {
        return idReligion;
    }

    public void setIdReligion(int idReligion) {
        this.idReligion = idReligion;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

}
