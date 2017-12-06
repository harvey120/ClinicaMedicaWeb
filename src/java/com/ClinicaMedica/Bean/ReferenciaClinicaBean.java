package com.ClinicaMedica.Bean;

import com.ClinicaMedica.DAO.ReferenciaClinicaDAO;
import com.ClinicaMedica.Modelo.ReferenciaClinica;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Harvey
 */
@ManagedBean
@ViewScoped
public class ReferenciaClinicaBean {

    private ReferenciaClinica referenciaclinica = new ReferenciaClinica();
    private List<ReferenciaClinica> lstReferencia;

    public ReferenciaClinicaBean() {
    }

    public ReferenciaClinica getReferenciaclinica() {
        return referenciaclinica;
    }

    public void setReferenciaclinica(ReferenciaClinica referenciaclinica) {
        this.referenciaclinica = referenciaclinica;
    }

    public List<ReferenciaClinica> getLstReferencia() {
        return lstReferencia;
    }

    public void setLstReferencia(List<ReferenciaClinica> lstReferencia) {
        this.lstReferencia = lstReferencia;
    }

    public void listarReferenciaClinica() {
        ReferenciaClinicaDAO dao;
        try {
            dao = new ReferenciaClinicaDAO();
            lstReferencia = dao.listar();
        } catch (SQLException e) {
            System.out.println("No de desplego informacion en ReferenciaClinicaBean" + e);
        }
    }
    
    public void listar() {
        System.out.println("ha ingresado a lista ReferenciaClinicaBean");
        ReferenciaClinicaDAO dao;
        try {
            dao = new ReferenciaClinicaDAO() ;
            referenciaclinica = dao.listado(referenciaclinica);
            
        } catch (SQLException e) {
            
            System.out.println("error listar ReferenciaClinicaBean" + e);
        }
    }
}
