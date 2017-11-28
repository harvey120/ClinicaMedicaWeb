package com.ClinicaMedica.Modelo;

/**
 *
 * @author erick osoy
 */
public class RevisionGeneral {
    private int IdExamenGeneral;
    private String Presion;
    private String Temperatura;
    private String Peso;
    private String Estatura;
    private String Talla;
    private int Cita_IdCitaa;
    
    public RevisionGeneral(){
        this.IdExamenGeneral=0;
        this.Presion="";
        this.Temperatura="";
        this.Peso="";
        this.Estatura="";
        this.Talla="";
        this.Cita_IdCitaa=0;
    }

    public int getIdExamenGeneral() {
        return IdExamenGeneral;
    }

    public void setIdExamenGeneral(int IdExamenGeneral) {
        this.IdExamenGeneral = IdExamenGeneral;
    }

    public String getPresion() {
        return Presion;
    }

    public void setPresion(String Presion) {
        this.Presion = Presion;
    }

    public String getTemperatura() {
        return Temperatura;
    }

    public void setTemperatura(String Temperatura) {
        this.Temperatura = Temperatura;
    }

    public String getPeso() {
        return Peso;
    }

    public void setPeso(String Peso) {
        this.Peso = Peso;
    }

    public String getEstatura() {
        return Estatura;
    }

    public void setEstatura(String Estatura) {
        this.Estatura = Estatura;
    }

    public String getTalla() {
        return Talla;
    }

    public void setTalla(String Talla) {
        this.Talla = Talla;
    }

    public int getCita_IdCitaa() {
        return Cita_IdCitaa;
    }

    public void setCita_IdCitaa(int Cita_IdCitaa) {
        this.Cita_IdCitaa = Cita_IdCitaa;
    }
    
    
}
