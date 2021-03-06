package com.ClinicaMedica.Modelo;

/**
 * @author Harvey
 */
public class Enfermedad {

    private int idEnfermedad;
    private String nombre;
    private int idCategoriaEnfermedad;

    private String tipoEnfermedad;

    public Enfermedad() {
        this.idEnfermedad = 0;
        this.nombre = "";
        this.idCategoriaEnfermedad = 0;
        this.tipoEnfermedad = "";
    }

    public int getIdEnfermedad() {
        return idEnfermedad;
    }

    public void setIdEnfermedad(int idEnfermedad) {
        this.idEnfermedad = idEnfermedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCategoriaEnfermedad() {
        return idCategoriaEnfermedad;
    }

    public void setIdCategoriaEnfermedad(int idCategoriaEnfermedad) {
        this.idCategoriaEnfermedad = idCategoriaEnfermedad;
    }

    public String getTipoEnfermedad() {
        return tipoEnfermedad;
    }

    public void setTipoEnfermedad(String tipoEnfermedad) {
        this.tipoEnfermedad = tipoEnfermedad;
    }

}
