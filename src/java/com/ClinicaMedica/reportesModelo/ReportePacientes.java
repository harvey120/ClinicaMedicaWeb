package com.ClinicaMedica.reportesModelo;

/**
 * @author Harvey
 */
public class ReportePacientes {

    private String nombre;
    private String fecha;
    private String Telefono;
    private String correo;
    private String sexo;
    private String civil;
    private String documento;
    private String noDocumento;

    public ReportePacientes() {
        this.nombre = "";
        this.fecha = "";
        this.Telefono = "";
        this.correo = "";
        this.sexo = "";
        this.civil = "";
        this.documento = "";
        this.noDocumento = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCivil() {
        return civil;
    }

    public void setCivil(String civil) {
        this.civil = civil;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNoDocumento() {
        return noDocumento;
    }

    public void setNoDocumento(String noDocumento) {
        this.noDocumento = noDocumento;
    }

}
