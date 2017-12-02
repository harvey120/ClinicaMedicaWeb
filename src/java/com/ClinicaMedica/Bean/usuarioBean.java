package com.ClinicaMedica.Bean;

import com.ClinicaMedica.DAO.usuarioDao;
import com.ClinicaMedica.Modelo.Usuarios;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class usuarioBean {

    private Usuarios ingreso = new Usuarios();
    private List<Usuarios> lstUsuarios = new ArrayList();

    public usuarioBean() {
    }

    public Usuarios getIngreso() {
        return ingreso;
    }

    public void setIngreso(Usuarios ingreso) {
        this.ingreso = ingreso;
    }

    public List<Usuarios> getLstUsuarios() {
        return lstUsuarios;
    }

    public void setLstUsuarios(List<Usuarios> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }

    public void insertar() throws Exception {
        System.out.println("ha ingresado a Empleado");
        usuarioDao dao;
        try {
            dao = new usuarioDao();
            dao.registrarUsuarios(ingreso);
            this.listar();
        } catch (Exception e) {
            System.out.println("ERROOOOOOOOOOOOOOOOOOOOOOOOOOR INSERTAR  usuario BEAN" + e);
        }
    }

    public void listar() throws Exception {
        System.out.println("ha ingresado a listar");
        usuarioDao dao;

        try {
            dao = new usuarioDao();
            lstUsuarios = dao.listar();

        } catch (Exception e) {
            System.out.println("error listar usuario Bean " + e);
        }

    }

    public void modificar() {
        usuarioDao dao;

        try {

            dao = new usuarioDao();
            dao.modificarUsuarios(ingreso);
            this.listar();
        } catch (Exception e) {
            System.out.println("error usuario Bean" + e);
        }
    }

    public void eliminar(Usuarios usu) throws Exception {
        usuarioDao dao;

        try {
            dao = new usuarioDao();
            dao.eliminarUsuarios(usu);
            this.listar();
        } catch (Exception e) {
            System.out.println("error usuario bean eliminar:" + e);
        }
    }
    
    

    public void leerID(Usuarios vi) throws Exception {
        System.out.println("ha ingresado a leer Usuario***************************** ");
        usuarioDao dao;
        Usuarios temp;
        try {
            dao = new usuarioDao();
            temp = dao.leerID(vi);

            if (temp != null) {
                this.ingreso = temp;
            }

        } catch (Exception e) {
            System.out.println("ERROOOOOOOOOOOOOOOOOOOOOOOOOOR LEER USUARIO BEAN" + e);
        }
    }

}
