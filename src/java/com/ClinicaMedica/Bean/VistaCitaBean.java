package com.ClinicaMedica.Bean;

import com.ClinicaMedica.DAO.VistaCitaDAO;
import com.ClinicaMedica.Modelo.vistaCita;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author javam
 */
@ManagedBean
@ViewScoped
public class VistaCitaBean {

    private List<vistaCita> lstcita;

    public List<vistaCita> getLstcita() {
        return lstcita;
    }

    public void setLstcita(List<vistaCita> lstcita) {
        this.lstcita = lstcita;
    }

    public void listarCita() {
        VistaCitaDAO dao;
        try {
            dao = new VistaCitaDAO();
            lstcita = dao.listar();
        } catch (SQLException e) {
            System.out.println("No se desplego informacion en CitaBean " + e);
        }
    }

}
