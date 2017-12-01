package com.ClinicaMedica.VistaBean;

import com.ClinicaMedica.Modelo.Empleado;
import com.ClinicaMedica.Modelo.Persona;
import com.ClinicaMedica.Modelo.Usuarios;
import com.ClinicaMedica.VistaDAO.VistaDAOEmpleado;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Harvey
 */
@ManagedBean
@ViewScoped
public class VistaBeanEmpleado {

    private Persona persona = new Persona();
    private Empleado empleado = new Empleado();
    private Usuarios usuario = new Usuarios();

    public VistaBeanEmpleado() {
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public void registrarEmpleado() {
        VistaDAOEmpleado dao;
        empleado.setIdEmpleado(persona.getIdPersona());
        try {
            dao = new VistaDAOEmpleado();
            dao.registrarEmpleado(persona, empleado);
        } catch (Exception e) {
            System.out.println("No se registro en VistaBeanEmpleado " + e);
        }
    }

    public void registrarAdmin() {
        VistaDAOEmpleado dao;
        empleado.setIdEmpleado(persona.getIdPersona());
        try {
            dao = new VistaDAOEmpleado();
            dao.registrarAdmin(persona, empleado, usuario);
        } catch (Exception e) {
            System.out.println("No se registro en VistaBeanEmpleado " + e);
        }
    }

}
