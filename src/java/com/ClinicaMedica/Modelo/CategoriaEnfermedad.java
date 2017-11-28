package com.ClinicaMedica.Modelo;

/**
 *
 * @author medev
 */
public class CategoriaEnfermedad {
    
    private int IdCategoriaEnfermedad;
    private String NombreCategoria;

    public CategoriaEnfermedad() {
        this.IdCategoriaEnfermedad = 0;
        this.NombreCategoria = "";
    }

    public int getIdCategoriaEnfermedad() {
        return IdCategoriaEnfermedad;
    }

    public void setIdCategoriaEnfermedad(int IdCategoriaEnfermedad) {
        this.IdCategoriaEnfermedad = IdCategoriaEnfermedad;
    }

    public String getNombreCategoria() {
        return NombreCategoria;
    }

    public void setNombreCategoria(String NombreCategoria) {
        this.NombreCategoria = NombreCategoria;
    }
}
