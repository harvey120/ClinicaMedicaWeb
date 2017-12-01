package com.ClinicaMedica.Bean;

import com.ClinicaMedica.DAO.PacienteListarDAO;
import com.ClinicaMedica.Modelo.Paciente;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author erick osoy
 */
@ViewScoped
@ManagedBean
public class PacienteListarBean {

    Paciente med = new Paciente();
    ArrayList<Paciente> array = new ArrayList();

    public PacienteListarBean() {
    }

    public Paciente getMed() {
        return med;
    }

    public void setMed(Paciente med) {
        this.med = med;
    }

    public ArrayList<Paciente> getArray() {
        return array;
    }

    public void setArray(ArrayList<Paciente> array) {
        this.array = array;
    }

    
    public void listar() {
        System.out.println("ha ingresado a Buscar Paciente Bean");
        PacienteListarDAO dao;
        try {
            dao = new PacienteListarDAO();
            med = dao.listado(med);

        } catch (Exception e) {

            System.out.println("error Buscar Paciente Bean" + e);
        }
    }

}
