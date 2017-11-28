package com.ClinicaMedica.Modelo;

/**
 *
 * @author Daniel  
 */
public class AreaVivienda {
    
    private int idAreaVivienda;
    private String nombre;

    public AreaVivienda() {
        this.idAreaVivienda = 0;
        this.nombre = "";
    }

    public int getIdAreaVivienda() {
        return idAreaVivienda;
    }

    public void setIdAreaVivienda(int idAreaVivienda) {
        this.idAreaVivienda = idAreaVivienda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
