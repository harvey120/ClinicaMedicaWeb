package com.ClinicaMedica.Bean;

import com.ClinicaMedica.DAO.HistorialClinicoDAO;
import com.ClinicaMedica.Modelo.HistorialClinico;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Harvey
 */
@ManagedBean
@ViewScoped
public class HistorialClinicoBean {

    private HistorialClinico historial = new HistorialClinico();
    private List<HistorialClinico> lsthistorial;

    public HistorialClinicoBean() {
    }

    public HistorialClinico getHistorial() {
        return historial;
    }

    public void setHistorial(HistorialClinico historial) {
        this.historial = historial;
    }

    public List<HistorialClinico> getLsthistorial() {
        return lsthistorial;
    }

    public void setLsthistorial(List<HistorialClinico> lsthistorial) {
        this.lsthistorial = lsthistorial;
    }

    public void registrar() {
        HistorialClinicoDAO dao;

        try {
            dao = new HistorialClinicoDAO();
            dao.registrar(historial);
        } catch (Exception e) {
            System.out.println("No se registro en HistorialClinicoBean" + e);
        }
    }

    public void listarHistorialClinico() {
        HistorialClinicoDAO dao;

        try {
            dao = new HistorialClinicoDAO();
            lsthistorial = dao.listar();
        } catch (Exception e) {
            System.out.println("No de desplego informacion en HistorialClinicoBean" + e);
        }
    }

    public void leerID(HistorialClinico histo) {
        HistorialClinicoDAO dao;
        HistorialClinico temp;
        try {
            dao = new HistorialClinicoDAO();
            temp = dao.leerID(histo);
            if (temp != null) {
                this.historial = temp;
            }
        } catch (Exception e) {
            System.out.println("No se pudo leerID en HistorialClinicoBean" + e);
        }
    }

    public void modificar() {
        HistorialClinicoDAO dao;

        try {
            dao = new HistorialClinicoDAO();
            dao.modificar(historial);
            this.listarHistorialClinico();
        } catch (Exception e) {
            System.out.println("No se pudo Modificar en HistorialClinicoBean" + e);
        }
    }

    public void eliminar(HistorialClinico histo) {
        HistorialClinicoDAO dao;

        try {
            dao = new HistorialClinicoDAO();
            dao.eliminar(histo);
            this.listarHistorialClinico();
        } catch (Exception e) {
            System.out.println("No se Eliminar en HistorialClinicoBean" + e);
        }
    }
}
