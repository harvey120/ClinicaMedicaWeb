package com.ClinicaMedica.Bean;

import com.ClinicaMedica.DAO.EstadoCitaDao;
import com.ClinicaMedica.Modelo.EstadoCita;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class EstadoCitaBean {

    private EstadoCita esci = new EstadoCita();
    private List<EstadoCita> lstEstadoCita;

    public EstadoCita getEsci() {
        return esci;
    }

    public void setEsci(EstadoCita esci) {
        this.esci = esci;
    }

    public List<EstadoCita> getLstEstadoCita() {
        return lstEstadoCita;
    }

    public void setLstEstadoCita(List<EstadoCita> lstEstadoCita) {
        this.lstEstadoCita = lstEstadoCita;
    }

    public void limpiar() {
        esci.setIdEstadoCita(0);
        esci.setTipo("");

    }

    public void listarEstadoCita() {
        EstadoCitaDao dao;
        try {
            dao = new EstadoCitaDao();
            lstEstadoCita = dao.listar();
        } catch (SQLException e) {
            System.out.println("Error en metodo listarEstadoCita de la clase EstadoCitaBean: "+e);
        }
    }

//Nota: Esta clase al pasarla no recocia las importaciones de Estado Cita
}
