package com.ClinicaMedica.Bean;

import com.ClinicaMedica.DAO.BuscarCitaDAO;
import com.ClinicaMedica.Modelo.Cita;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author erick osoy
 */
@ViewScoped
@ManagedBean
public class BuscarCitaBean {

    Cita cita = new Cita();
    ArrayList<Cita> array = new ArrayList();

    public BuscarCitaBean() {
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public ArrayList<Cita> getArray() {
        return array;
    }

    public void setArray(ArrayList<Cita> array) {
        this.array = array;
    }

    public void listar() {
        System.out.println("ha ingresado a lista bn");
        BuscarCitaDAO dao;
        try {
            dao = new BuscarCitaDAO();
            cita = dao.listado(cita);
            this.limpiar();
        } catch (SQLException e) {
            System.out.println("Error Buscar Cita bn" + e);
        }
    }
    
    public void limpiar(){
        cita.setIdCita(0);
    }
}
