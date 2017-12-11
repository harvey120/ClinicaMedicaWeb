package com.ClinicaMedica.Modelo;

public class BusquedaPacienteSecre {

    private String Nombre;
    private String Apellido;
    private String FechaNac;
    private String Correo;
    private String NoDocumento;
    private String ContactoEmergencia;
    private String Telefono;
    private String FechaHistorial;
    private String ReferenciaClinica;
    private String Enfermedad;

    public BusquedaPacienteSecre() {
        this.Nombre = "";
        this.Apellido = "";
        this.FechaNac = "";
        this.Correo = "";
        this.NoDocumento = "";
        this.ContactoEmergencia = "";
        this.Telefono = "";
        this.FechaHistorial = "";
        this.ReferenciaClinica = "";
        this.Enfermedad = "";
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(String FechaNac) {
        this.FechaNac = FechaNac;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getNoDocumento() {
        return NoDocumento;
    }

    public void setNoDocumento(String NoDocumento) {
        this.NoDocumento = NoDocumento;
    }

    public String getContactoEmergencia() {
        return ContactoEmergencia;
    }

    public void setContactoEmergencia(String ContactoEmergencia) {
        this.ContactoEmergencia = ContactoEmergencia;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getFechaHistorial() {
        return FechaHistorial;
    }

    public void setFechaHistorial(String FechaHistorial) {
        this.FechaHistorial = FechaHistorial;
    }

    public String getReferenciaClinica() {
        return ReferenciaClinica;
    }

    public void setReferenciaClinica(String ReferenciaClinica) {
        this.ReferenciaClinica = ReferenciaClinica;
    }

    public String getEnfermedad() {
        return Enfermedad;
    }

    public void setEnfermedad(String Enfermedad) {
        this.Enfermedad = Enfermedad;
    }

   
}
