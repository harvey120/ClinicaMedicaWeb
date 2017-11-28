package com.ClinicaMedica.Modelo;

/**
 *
 * @author erick osoy
 */
public class CategoriaExamen {
    private int idCategoriaExamen;
    private String NombreCategoria;
    
    public CategoriaExamen(){
        this.idCategoriaExamen=0;
        this.NombreCategoria="";
    }

    public int getIdCategoriaExamen() {
        return idCategoriaExamen;
    }

    public void setIdCategoriaExamen(int idCategoriaExamen) {
        this.idCategoriaExamen = idCategoriaExamen;
    }

    public String getNombreCategoria() {
        return NombreCategoria;
    }

    public void setNombreCategoria(String NombreCategoria) {
        this.NombreCategoria = NombreCategoria;
    }
    
    
}
