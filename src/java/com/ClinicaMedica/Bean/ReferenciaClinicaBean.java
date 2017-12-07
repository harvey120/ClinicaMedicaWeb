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
            dao = new ReferenciaClinicaDAO();
            referenciaclinica = dao.listado(referenciaclinica);

        } catch (SQLException e) {

            System.out.println("error listar ReferenciaClinicaBean" + e);
        }
    }

    public void insertar() {
        ReferenciaClinicaDAO ree;
        try {
            ree = new ReferenciaClinicaDAO();
            ree.insertar(referenciaclinica);
            this.limpiar();
            this.listarReferenciaClinica();
        } catch (SQLException e) {
            System.out.println("Error ReferenciaClinica insertar: " + e);
        }
    }

    public void modificar() {
        ReferenciaClinicaDAO rf;
        try {
            rf = new ReferenciaClinicaDAO();
            rf.modificar(referenciaclinica);
            this.listarReferenciaClinica();
        } catch (SQLException e) {
            System.out.println("Error ReferenciaClinicaBean modificar: " + e);
        }
    }

    public void leerID(ReferenciaClinica enf) {
        ReferenciaClinicaDAO ne;
        ReferenciaClinica temp;

        try {
            ne = new ReferenciaClinicaDAO();
            temp = ne.leerID(enf);
            if (temp != null) {
                this.referenciaclinica = temp;
            }
        } catch (SQLException e) {
        }
    }

    public void limpiar() {
        referenciaclinica.setIdReferenciaClinica(0);
        referenciaclinica.setNombre("");
    }
}
