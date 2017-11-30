package com.ClinicaMedica.Bean;

import com.ClinicaMedica.DAO.especialidadDao;
import com.ClinicaMedica.Modelo.Especialidad;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author erick osoy
 */
@ManagedBean
@ViewScoped
public class especialidadBean {

    private Especialidad ingreso = new Especialidad();
    private List<Especialidad> lstEspecialidad = new ArrayList();
    
    public especialidadBean() {
    }

    public Especialidad getIngreso() {
        return ingreso;
    }

    public void setIngreso(Especialidad ingreso) {
        this.ingreso = ingreso;
    }

    public List<Especialidad> getLstEspecialidad() {
        return lstEspecialidad;
    }

    public void setLstEspecialidad(List<Especialidad> lstEspecialidad) {
        this.lstEspecialidad = lstEspecialidad;
    }
   
    
    
    
    public void insertar() throws Exception {
        System.out.println("ha ingresado a insertar");
        especialidadDao dao;
        try {
            dao = new especialidadDao();
            dao.registrar(ingreso);
            this.listar();
        } catch (Exception e) {
            System.out.println("ERROOOOOOOOOOOOOOOOOOOOOOOOOOR INSERTAR BEAN" + e);
        }
    }
   
    

    public void listar() throws Exception {
        System.out.println("ha ingresado a listar");
        especialidadDao dao;

        try {
            dao = new especialidadDao();
            lstEspecialidad = dao.listar();

        } catch (Exception e) {
            System.out.println("error listar especialidadDao" + e);
        }

    }

    public void modificar() {
         especialidadDao dao;

        try {

            dao = new especialidadDao();
            dao.modificar(ingreso);
            this.listar();
        } catch (Exception e) {
            System.out.println("error especialidadDao" + e);
        }
    }

    public void eliminar() throws Exception {
        especialidadDao dao;

        try {
            dao = new especialidadDao();
            dao.eliminar(ingreso);
            this.listar();
        } catch (Exception e) {
            System.out.println("error especialidadDao bean eliminar:" + e);
        }
    }

}
