package com.ClinicaMedica.Bean;

import com.ClinicaMedica.DAO.EnfermedadDAO;
import com.ClinicaMedica.Modelo.Enfermedad;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Harvey
 */
@ManagedBean
@ViewScoped
public class EnfermedadBean {

    private Enfermedad enfermedad = new Enfermedad();
    private List<Enfermedad> lstEnfermedad = new ArrayList<>();

    public EnfermedadBean() {
    }

    public Enfermedad getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
    }

    public List<Enfermedad> getLstEnfermedad() {
        return lstEnfermedad;
    }

    public void setLstEnfermedad(List<Enfermedad> lstEnfermedad) {
        this.lstEnfermedad = lstEnfermedad;
    }

    public void limpiar() {
        enfermedad.setIdEnfermedad(0);
        enfermedad.setIdCategoriaEnfermedad(0);
        enfermedad.setNombre("");
    }

    public void insertar() {
        EnfermedadDAO ins;
        try {
            ins = new EnfermedadDAO();
            ins.insertar(enfermedad);
            this.limpiar();
            this.listarEnfermedad();
        } catch (SQLException e) {
            System.out.println("Error EnfermedadBean insertar: " + e);
        }
    }

    public void listarEnfermedad() {
        EnfermedadDAO dao;
        try {
            dao = new EnfermedadDAO();
            lstEnfermedad = dao.listar();
        } catch (Exception e) {
            System.out.println("No se desplego informacion en EnfermedadBean " + e);
        }
    }

    public void leerID(Enfermedad enf) {
        EnfermedadDAO ne;
        Enfermedad temp;

        try {
            ne = new EnfermedadDAO();
            temp = ne.leerID(enf);
            if (temp != null) {
                this.enfermedad = temp;
            }
        } catch (Exception e) {
        }
    }

    public void modificar() {
        EnfermedadDAO mod;
        try {
            mod = new EnfermedadDAO();
            mod.modificar(enfermedad);
            this.listarEnfermedad();
        } catch (SQLException e) {
            System.out.println("Error EnfermedadBean modificar: " + e);
        }
    }

    public void eliminar(Enfermedad eli) {
        EnfermedadDAO elim;
        try {
            elim = new EnfermedadDAO();
            elim.eliminar(eli);
            this.listarEnfermedad();
        } catch (SQLException e) {
            System.out.println("Error EnfermedadBean eliminar: " + e);
        }
    }

    public void listar() {
        System.out.println("ha ingresado a lista bn Enfermedad2DAO");
        EnfermedadDAO dao;
        try {
            dao = new EnfermedadDAO();
            enfermedad = dao.listado(enfermedad);

        } catch (Exception e) {

            System.out.println("error listar bn Enfermedad2DAO" + e);
        }
    }

    public void RPTEnfermedad() {
        System.out.println("ha ingresado a lista bn Enfermedad2DAO");
        EnfermedadDAO dao;
        try {
            dao = new EnfermedadDAO();
            lstEnfermedad = dao.rptEnfermedad(enfermedad);
            enfermedad.setNombre(lstEnfermedad.get(0).getNombre());
            enfermedad.setTipoEnfermedad(lstEnfermedad.get(0).getTipoEnfermedad());
            
            System.out.println(lstEnfermedad.get(0).getTipoEnfermedad());
            
        } catch (Exception e) {

            System.out.println("error listar bn Enfermedad2DAO" + e);
        }
    }
}
