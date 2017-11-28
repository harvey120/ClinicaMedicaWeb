package com.ClinicaMedica.VistaModelo;

/**
 * @author Harvey
 */
public class VistaPersona {

    private int idPersona;
    private String nombre, apellido, fechaNacimiento, telefono, correoElectronico, noDocumento;
    private String genero, estadocivil, documentopaciente, religion;

    public VistaPersona() {
        this.idPersona = 0;
        this.nombre = "";
        this.apellido = "";
        this.fechaNacimiento = "";
        this.telefono = "";
        this.correoElectronico = "";
        this.genero = "";
        this.estadocivil = "";
        this.documentopaciente = "";
        this.noDocumento = "";
        this.religion = "";
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public String getNoDocumento() {
        return noDocumento;
    }

    public void setNoDocumento(String noDocumento) {
        this.noDocumento = noDocumento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getDocumentopaciente() {
        return documentopaciente;
    }

    public void setDocumentopaciente(String documentopaciente) {
        this.documentopaciente = documentopaciente;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

}
