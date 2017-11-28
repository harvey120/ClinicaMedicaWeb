package com.ClinicaMedica.Modelo;
/**
 *
 * @author Daniel
 */
public class Turno{
    
    private int idturno;
    private String horarioEntrada;
    private String horarioSalida;

    //SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
    
    public Turno(){
        this.idturno = 0;
        this.horarioEntrada = null;
        this.horarioSalida = null;
    }

    public int getIdturno() {
        return idturno;
    }

    public void setIdturno(int idturno) {
        this.idturno = idturno;
    }

    public String getHorarioEntrada() {
        
        return horarioEntrada;
    }

    public void setHorarioEntrada(String horarioEntrada) {
        //this.horarioEntrada=formateador.format(this.horarioEntrada);
        this.horarioEntrada = horarioEntrada;
    }

    public String getHorarioSalida() {
        return horarioSalida;
    }

    public void setHorarioSalida(String horarioSalida) {
        //this.horarioEntrada=formateador.format(this.horarioEntrada);
        this.horarioSalida = horarioSalida;
    }    
}
