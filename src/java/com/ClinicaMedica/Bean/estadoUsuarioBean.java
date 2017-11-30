package com.ClinicaMedica.Bean;

import com.ClinicaMedica.DAO.estadoUsuarioDao;
import com.ClinicaMedica.Modelo.EstadoUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class estadoUsuarioBean {

    private EstadoUsuario ingreso = new EstadoUsuario();
    private List<EstadoUsuario> lstEstadoUsuario = new ArrayList();

    public estadoUsuarioBean() {
    }

    public EstadoUsuario getIngreso() {
        return ingreso;
    }

    public void setIngreso(EstadoUsuario ingreso) {
        this.ingreso = ingreso;
    }

    public List<EstadoUsuario> getLstEstadoUsuario() {
        return lstEstadoUsuario;
    }

    public void setLstEstadoUsuario(List<EstadoUsuario> lstEstadoUsuario) {
        this.lstEstadoUsuario = lstEstadoUsuario;
    }

    
    public void insertar() throws Exception {
        System.out.println("ha ingresado a Empleado");
        estadoUsuarioDao dao;
        try {
            dao = new estadoUsuarioDao();
            dao.registrar(ingreso);
            this.listar();
        } catch (Exception e) {
            System.out.println("ERROOOOOOOOOOOOOOOOOOOOOOOOOOR estadoUsuarioDao  INSERTAR BEAN" + e);
        }
    }

    public void listar() throws Exception {
        System.out.println("ha ingresado a listar");
        estadoUsuarioDao dao;

        try {
            dao = new estadoUsuarioDao();
            lstEstadoUsuario = dao.listar();

        } catch (Exception e) {
            System.out.println("error listar estadoUsuarioDao Bean *******************" + e);
        }

    }

    public void modificar() {
       estadoUsuarioDao dao;

        try {

            dao = new estadoUsuarioDao();
            dao.modificar(ingreso);
            this.listar();
        } catch (Exception e) {
            System.out.println("error estadoUsuarioDao  Bean *****************" + e);
        }
    }

    public void eliminar() throws Exception {
        estadoUsuarioDao dao;

        try {
            dao = new estadoUsuarioDao();
            dao.eliminar(ingreso);
            this.listar();
        } catch (Exception e) {
            System.out.println("error estadoUsuarioDao Bean eliminar:" + e);
        }
    }

}
