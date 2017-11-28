
package com.ClinicaMedica.Modelo;

public class Examen {
    int IdExamen;
    String Nombre;
    int idCategoriaExamen;

    public Examen(){
        this.IdExamen=0;
        this.Nombre="";
        this.idCategoriaExamen=0;
    }
    
    public int getIdExamen() {
        return IdExamen;
    }

    public void setIdExamen(int IdExamen) {
        this.IdExamen = IdExamen;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getIdCategoriaExamen() {
        return idCategoriaExamen;
    }

    public void setIdCategoriaExamen(int idCategoriaExamen) {
        this.idCategoriaExamen = idCategoriaExamen;
    }
    
}
