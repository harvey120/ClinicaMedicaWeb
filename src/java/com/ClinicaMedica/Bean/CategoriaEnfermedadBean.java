package com.ClinicaMedica.Bean;

import com.ClinicaMedica.DAO.CategoriaEnfermedadDAO;
import com.ClinicaMedica.Modelo.CategoriaEnfermedad;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author medev
 */
@ManagedBean
@ViewScoped
public class CategoriaEnfermedadBean {

    private CategoriaEnfermedad nc = new CategoriaEnfermedad();
    private List<CategoriaEnfermedad> lstCatEnfermedad = new ArrayList();

    public CategoriaEnfermedad getNc() {
        return nc;
    }

    public void setNc(CategoriaEnfermedad nc) {
        this.nc = nc;
    }

    public List<CategoriaEnfermedad> getLstCatEnfermedad() {
        return lstCatEnfermedad;
    }

    public void setLstCatEnfermedad(List<CategoriaEnfermedad> lstCatEnfermedad) {
        this.lstCatEnfermedad = lstCatEnfermedad;
    }

    public void insertar() {
        CategoriaEnfermedadDAO nu;
        try {
            nu = new CategoriaEnfermedadDAO();
            nu.Insertar(nc);
            this.listar();
            this.limpiar();
        } catch (SQLException e) {
            System.out.println("Error CategoriaEnfermedadBean Insertar: " + e);
        }
    }

    public void listar() {
        CategoriaEnfermedadDAO li;
        try {
            li = new CategoriaEnfermedadDAO();
            lstCatEnfermedad = li.listar();
        } catch (SQLException e) {
            System.out.println("Error CategoriaEnfermedadBean Listar: " + e);
        }
    }
    
    public void leerID (CategoriaEnfermedad cat){
        CategoriaEnfermedadDAO ncat;
        CategoriaEnfermedad temp;
        
        try {
            ncat = new CategoriaEnfermedadDAO();
            temp = ncat.leerID(cat);
            if (temp != null) {
                this.nc = temp;
            }
        } catch (SQLException e) {
            System.out.println("ERROR CategoriaEnfermedadBean leerID: "+e);
        }
    }

    public void Modificar() {
        CategoriaEnfermedadDAO mo;
        try {
            mo = new CategoriaEnfermedadDAO();
            mo.modificar(nc);
            this.listar();
        } catch (SQLException e) {
            System.out.println("Error CategoriaEnfermedadBean Modificar: " + e);
        }
    }

    public void Eliminar(CategoriaEnfermedad eli) {
        CategoriaEnfermedadDAO el;
        try {
            el = new CategoriaEnfermedadDAO();
            el.eliminar(eli);
            this.listar();
        } catch (SQLException e) {
            System.out.println("Error CategoriaEnfermedadBean Eliminar: " + e);
        }
    }

    public void limpiar() {
        nc.setIdCategoriaEnfermedad(0);
        nc.setNombreCategoria("");
    }
}
