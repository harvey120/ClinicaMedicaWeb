package com.ClinicaMedica.Modelo;

public class Medicamento {

    private int idmedicamento;
    private String nombre;
    private String descripcion;
    private String fecha;
    private String provedor;
    private int codProveedor;

    public Medicamento() {
        this.idmedicamento = 0;
        this.nombre = "";
        this.descripcion = "";
        this.fecha = "";
        this.provedor = "";
        this.codProveedor = 0;
    }

    public int getCodProveedor() {
        return codProveedor;
    }

    public void setCodProveedor(int codProveedor) {
        this.codProveedor = codProveedor;
    }

    public int getIdmedicamento() {
        return idmedicamento;
    }

    public void setIdmedicamento(int idmedicamento) {
        this.idmedicamento = idmedicamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getProvedor() {
        return provedor;
    }

    public void setProvedor(String provedor) {
        this.provedor = provedor;
    }

}
