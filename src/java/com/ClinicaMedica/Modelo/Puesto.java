package com.ClinicaMedica.Modelo;

public class Puesto {
    private int idPuesto;
    private String nombre;
    
    public Puesto(){
        this.idPuesto=0;
        this.nombre="";
    }

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
