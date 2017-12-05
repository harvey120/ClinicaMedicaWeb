package com.ClinicaMedica.Modelo;

public class Medicamento {

    private int idmedicamento;
    private String nombre;
    private String descripcion;
    private String fecha;
    private int provedor;
    private int idInventario;

    public Medicamento() {
        this.idmedicamento = 0;
        this.nombre = "";
        this.descripcion = "";
        this.fecha = "";
        this.provedor = 0;
        this.idInventario = 0;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
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

    public int getProvedor() {
        return provedor;
    }

    public void setProvedor(int provedor) {
        this.provedor = provedor;
    }

}
