package com.ClinicaMedica.Bean;


import com.ClinicaMedica.DAO.puestoDao;
import com.ClinicaMedica.Modelo.Puesto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class puestoBean {
    private Puesto ingreso = new Puesto();
    private List<Puesto> lstPuesto = new ArrayList();
    
    public puestoBean() {
    }

    public Puesto getIngreso() {
        return ingreso;
    }

    public void setIngreso(Puesto ingreso) {
        this.ingreso = ingreso;
    }

    public List<Puesto> getLstPuesto() {
        return lstPuesto;
    }

    public void setLstPuesto(List<Puesto> lstPuesto) {
        this.lstPuesto = lstPuesto;
    }

    
    
    
     public void insertar() throws Exception {
        System.out.println("ha ingresado a insertar_puestoDao*************");
        puestoDao dao;
        try {
            dao = new puestoDao();
            dao.registrarPuesto(ingreso);
            this.listar();
       
        } catch (Exception e) {
            System.out.println("ERROOOOOOOOOOOOOOOOOOOOOOOOOOR INSERTAR BEAN" + e);
        }
    }
     
     public void listar() throws Exception {
        System.out.println("ha ingresado a listar");
        puestoDao dao;

        try {
            dao = new puestoDao();
            lstPuesto = dao.listar();

        } catch (Exception e) {
            System.out.println("error listar" + e);
        }

    }

    public void modificar() {
         puestoDao dao;

        try {

            dao = new puestoDao();
            dao.modificarPuesto(ingreso);
            this.listar();
        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }

    public void eliminar() throws Exception {
        puestoDao dao;

        try {
            dao = new puestoDao();
            dao.eliminarPuesto(ingreso);
            this.listar();
        } catch (Exception e) {
            System.out.println("error bean eliminar:" + e);
        }
    }
     
}
