package com.ClinicaMedica.reportesModelo;

/**
 * @author Harvey
 */
public class ReporteEmpleado {

    private String nombre;
    private String telefono;
    private String correo;
    private String documento;
    private String noDocumento;
    private String especialidad;
    private String consultorio;
    private String puesto;

    public ReporteEmpleado() {
        this.nombre = "";
        this.telefono = "";
        this.correo = "";
        this.documento = "";
        this.noDocumento = "";
        this.especialidad = "";
        this.consultorio = "";
        this.puesto = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

}
