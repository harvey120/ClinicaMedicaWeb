package com.ClinicaMedica.reportesModelo;

/**
 * @author Harvey
 */
public class rptBusquedaPaciente {

    private String nombrePaciente;
    private String fechaNacimiento;
    private String telefono;
    private String correo;
    private String genero;
    private String civil;
    private String documento;
    private String noDocumento;
    private String religion;
    private String direccion;
    private String detalleVivienda;
    private String ocupacion;
    private int codigoHistorial;
    private String descripcion;
    private String fechaIngreso;
    private String referenciaClinica;

    public rptBusquedaPaciente() {
        this.nombrePaciente = "";
        this.fechaNacimiento = "";
        this.telefono = "";
        this.correo = "";
        this.genero = "";
        this.civil = "";
        this.documento = "";
        this.noDocumento = "";
        this.religion = "";
        this.direccion = "";
        this.detalleVivienda = "";
        this.ocupacion = "";
        this.codigoHistorial = 0;
        this.descripcion = "";
        this.fechaIngreso = "";
        this.referenciaClinica = "";
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDetalleVivienda() {
        return detalleVivienda;
    }

    public void setDetalleVivienda(String detalleVivienda) {
        this.detalleVivienda = detalleVivienda;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public int getCodigoHistorial() {
        return codigoHistorial;
    }

    public void setCodigoHistorial(int codigoHistorial) {
        this.codigoHistorial = codigoHistorial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getReferenciaClinica() {
        return referenciaClinica;
    }

    public void setReferenciaClinica(String referenciaClinica) {
        this.referenciaClinica = referenciaClinica;
    }

}
