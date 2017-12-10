package com.ClinicaMedica.Modelo;

/**
 * @author Harvey
 */
public class Paciente {

    private int idPaciente;
    private int idDomicilio;
    private String contactoPersona;
    private int telefonoContacto;
    private int idOcupacion;

    // elemento de la vista para Medico
    private String nombre;
    private String ocupacion;
    private String direccion;
    private String contactoEmergencia;
    private String telefonoEmergencia;
    private String noDocumento;

    public Paciente() {
        this.idPaciente = 0;
        this.idDomicilio = 0;
        this.contactoPersona = "";
        this.telefonoContacto = 0;
        this.idOcupacion = 0;
        this.nombre = "";
        this.ocupacion = "";
        this.direccion = "";
        this.contactoEmergencia = "";
        this.telefonoEmergencia = "";
        this.noDocumento = "";

    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getContactoPersona() {
        return contactoPersona;
    }

    public void setContactoPersona(String contactoPersona) {
        this.contactoPersona = contactoPersona;
    }

    public int getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(int telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public int getIdOcupacion() {
        return idOcupacion;
    }

    public void setIdOcupacion(int idOcupacion) {
        this.idOcupacion = idOcupacion;
    }

    // getter y setter de la vista
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContactoEmergencia() {
        return contactoEmergencia;
    }

    public void setContactoEmergencia(String contactoEmergencia) {
        this.contactoEmergencia = contactoEmergencia;
    }

    public String getTelefonoEmergencia() {
        return telefonoEmergencia;
    }

    public void setTelefonoEmergencia(String telefonoEmergencia) {
        this.telefonoEmergencia = telefonoEmergencia;
    }

    public String getNoDocumento() {
        return noDocumento;
    }

    public void setNoDocumento(String noDocumento) {
        this.noDocumento = noDocumento;
    }

}
