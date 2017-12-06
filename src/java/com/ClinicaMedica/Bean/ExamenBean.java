package com.ClinicaMedica.Bean;

import com.ClinicaMedica.DAO.ExamenDao;
import com.ClinicaMedica.Modelo.Examen;
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
public class ExamenBean {

    private Examen ingreso = new Examen();
    private List<Examen> lstExamenes = new ArrayList();

    public ExamenBean() {
    }

    public Examen getIngreso() {
        return ingreso;
    }

    public void setIngreso(Examen ingreso) {
        this.ingreso = ingreso;
    }

    public List<Examen> getLstExamenes() {
        return lstExamenes;
    }

    public void setLstExamenes(List<Examen> lstExamenes) {
        this.lstExamenes = lstExamenes;
    }

    //----------------------------------------------------------------------------------------------------
    //-----------------------------------------------METODOS----------------------------------------------
    //----------------------------------------------------------------------------------------------------
    public void insertar() throws Exception {
        System.out.println("ha ingresado a Examenes Bean");
        ExamenDao dao;
        try {
            dao = new ExamenDao();
            dao.insertar(ingreso);
            this.listarExamen();
            this.limpiar();
        } catch (Exception e) {
            System.out.println("ERROOOOOOOOOOOOOOOOOOOOOOOOOOR INSERTAR  Examenes BEAN" + e);
        }
    }

    public void listarExamen() throws Exception {
        System.out.println("ha ingresado a listar Examenes Bean");
        ExamenDao dao;

        try {
            dao = new ExamenDao();
            lstExamenes = dao.listar();

        } catch (Exception e) {
            System.out.println("error genero Examenes Bean" + e);
        }

    }

    public void modificar() {
        ExamenDao dao;

        try {

            dao = new ExamenDao();
            dao.modificar(ingreso);
            this.listarExamen();
        } catch (Exception e) {
            System.out.println("error Modificar Examenes  Bean" + e);
        }
    }

    public void eliminar(Examen ex) throws Exception {
        ExamenDao dao;

        try {
            dao = new ExamenDao();
            dao.eliminar(ex);
            this.listarExamen();
        } catch (Exception e) {
            System.out.println("error bean eliminar Examenes :" + e);
        }
    }

    public void leerID(Examen vi) throws Exception {
        System.out.println("ha ingresado a insertar");
        ExamenDao dao;
        Examen temp;
        try {
            dao = new ExamenDao();
            temp = dao.leerID(vi);

            if (temp != null) {
                this.ingreso = temp;
            }

        } catch (Exception e) {
            System.out.println("ERROOOOOOOOOOOOOOOOOOOOOOOOOOR LEER EXAMEN BEAN" + e);
        }
    }

    public void limpiar() {
        ingreso.setIdExamen(0);
        ingreso.setNombre("");
        ingreso.setIdCategoriaExamen(0);
    }

}
