package com.ClinicaMedica.Bean;

import com.ClinicaMedica.DAO.BuscarCitaDAO;
import com.ClinicaMedica.Modelo.Cita;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    List<Cita> array = new ArrayList();

    public BuscarCitaBean() {
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public List<Cita> getArray() {
        return array;
    }

    public void setArray(List<Cita> array) {
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

    public void listarDocumentos() {
        BuscarCitaDAO dao;

        try {
            dao = new BuscarCitaDAO();
            System.out.println("");
            array = dao.listarReporte(cita);

            cita.setIdCita(array.get(0).getIdCita());
            cita.setNombreEmpleado(array.get(0).getNombreEmpleado());
            cita.setFecha(array.get(0).getFecha());
            cita.setHorario(array.get(0).getHorario());
            cita.setTipo(array.get(0).getTipo());
            cita.setNombrePaciente(array.get(0).getNombrePaciente());
        } catch (Exception e) {
            System.out.println("Error Buscar Cita bn" + e);
        }
    }

    public void limpiar() {
        cita.setIdCita(0);
    }
}
