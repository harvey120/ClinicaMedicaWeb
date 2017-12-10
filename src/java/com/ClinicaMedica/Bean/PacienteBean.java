package com.ClinicaMedica.Bean;

import com.ClinicaMedica.DAO.PacienteDAO;
import com.ClinicaMedica.Modelo.Paciente;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Harvey
 */
@ManagedBean
@ViewScoped
public class PacienteBean {

    private Paciente paciente = new Paciente();
    private List<Paciente> lstPaciente;

    public PacienteBean() {

    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Paciente> getLstPaciente() {
        return lstPaciente;
    }

    public void setLstPaciente(List<Paciente> lstPaciente) {
        this.lstPaciente = lstPaciente;
    }

    public void registrar() {
        PacienteDAO dao;

        try {
            dao = new PacienteDAO();
            dao.registrar(paciente);
        } catch (Exception e) {
            System.out.println("No se registro en PacienteBean" + e);
        }
    }

    public void listarPaciente() {
        PacienteDAO dao;

        try {
            dao = new PacienteDAO();
            lstPaciente = dao.listar();
        } catch (Exception e) {
            System.out.println("No de desplego informacion en PacienteBean" + e);
        }
    }

    public void listaRPTPaciente() {
        PacienteDAO dao;

        try {
            dao = new PacienteDAO();
            lstPaciente = dao.rptPacienteMedico(paciente);

            paciente.setNombre(lstPaciente.get(0).getNombre());
            paciente.setOcupacion(lstPaciente.get(0).getOcupacion());
            paciente.setDireccion(lstPaciente.get(0).getDireccion());
            paciente.setContactoEmergencia(lstPaciente.get(0).getContactoEmergencia());
            paciente.setTelefonoEmergencia(lstPaciente.get(0).getTelefonoEmergencia());

        } catch (Exception e) {
            System.out.println("No de desplego informacion en PacienteBean" + e);
        }
    }

    public void leerID(Paciente per) {
        PacienteDAO dao;
        Paciente temp;
        try {
            dao = new PacienteDAO();
            temp = dao.leerID(per);
            if (temp != null) {
                this.paciente = temp;
            }
        } catch (Exception e) {
            System.out.println("No se pudo leerID en PacienteBean" + e);
        }
    }

    public void modificar() {
        PacienteDAO dao;

        try {
            dao = new PacienteDAO();
            dao.modificar(paciente);
            this.listarPaciente();
        } catch (Exception e) {
            System.out.println("No se pudo Modificar en PacienteBean" + e);
        }
    }

    public void eliminar(Paciente per) {
        PacienteDAO dao;

        try {
            dao = new PacienteDAO();
            dao.eliminar(per);
            this.listarPaciente();
        } catch (Exception e) {
            System.out.println("No se Eliminar en PacienteBean" + e);
        }
    }

    public void listar() {
        System.out.println("ha ingresado a Buscar Paciente Bean");
        PacienteDAO dao;
        try {
            dao = new PacienteDAO();
            paciente = dao.listado(paciente);

        } catch (Exception e) {

            System.out.println("error Buscar Paciente Bean" + e);
        }
    }
}
