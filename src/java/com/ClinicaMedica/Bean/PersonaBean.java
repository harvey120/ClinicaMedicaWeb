package com.ClinicaMedica.Bean;

import com.ClinicaMedica.DAO.PersonaDAO;
import com.ClinicaMedica.Modelo.Persona;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Harvey
 */
@ManagedBean
@ViewScoped
public class PersonaBean {

    private Persona persona = new Persona();
    private List<Persona> lstPersona;

    public PersonaBean() {

    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getLstPersona() {
        return lstPersona;
    }

    public void setLstPersona(List<Persona> lstPersona) {
        this.lstPersona = lstPersona;
    }

    public void registrar() {
        PersonaDAO dao;
        System.out.println("nombre" + persona.getApellido());
        try {
            dao = new PersonaDAO();
            dao.registrar(persona);

        } catch (Exception e) {
            System.out.println("No se registro en PersonaBean" + e);
        }
    }

    public void listarPersona() {
        PersonaDAO dao;
        try {
            dao = new PersonaDAO();
            lstPersona = dao.listar();
        } catch (Exception e) {
            System.out.println("No de desplego informacion en PersonaBean" + e);
        }
    }

    public void leerID(Persona per) {
        System.out.println("llego");
        PersonaDAO dao;
        Persona temp;
        try {
            dao = new PersonaDAO();
            temp = dao.leerID(per);
            if (temp != null) {
                this.persona = temp;
            }
        } catch (Exception e) {
            System.out.println("No se pudo leer ID en PersonaBean" + e);
        }
    }

    public void modificar() {
        PersonaDAO dao;
        System.out.println("MODIFICAR");
        System.out.println("Nombre: " + persona.getApellido());
        try {
            dao = new PersonaDAO();
            dao.modificar(persona);
            this.listarPersona();
        } catch (Exception e) {
            System.out.println("No se Modifico en PersonaBean" + e);
        }
    }

    public void eliminar(Persona per) {
        PersonaDAO dao;
        System.out.println("Nombre" + per.getApellido());
        try {
            dao = new PersonaDAO();
            dao.eliminar(per);
            this.listarPersona();
        } catch (Exception e) {
            System.out.println("No se Eliminar en PersonaBean" + e);
        }
    }

}
