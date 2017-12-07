package com.ClinicaMedica.Bean;

import com.ClinicaMedica.DAO.RevisionGeneralDao;
import com.ClinicaMedica.Modelo.RevisionGeneral;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author erick osoy
 */
@ViewScoped
@ManagedBean
public class RevisionGeneralBean {

    private RevisionGeneral rev = new RevisionGeneral();
    private List<RevisionGeneral> array;

    public RevisionGeneral getRev() {
        return rev;
    }

    public void setRev(RevisionGeneral rev) {
        this.rev = rev;
    }

    public List<RevisionGeneral> getArray() {
        return array;
    }

    public void setArray(List<RevisionGeneral> array) {
        this.array = array;
    }
    
    public void listar() {
        System.out.println("ha ingresado a lista bn RevisionGeneralDAO");
        RevisionGeneralDao dao;
        try {
            dao = new RevisionGeneralDao();
            rev = dao.listado(rev);

        } catch (Exception e) {

            System.out.println("error listar bn RevisionGeneralDAO" + e);
        }
    }

    public void limpiar() {
        rev.setIdExamenGeneral(0);
        rev.setPresion("");
        rev.setTemperatura("");
        rev.setPeso("");
        rev.setEstatura("");
        rev.setTalla("");
        rev.setCita_IdCitaa(0);
    }

    public void insertar() {
        RevisionGeneralDao ins;
        try {
            ins = new RevisionGeneralDao();
            ins.insertar(rev);
            this.limpiar();
            this.listarRevisionGeneral();
        } catch (SQLException e) {
            System.out.println("Error RevisionGeneralBean insertar: " + e);
        }
    }

    public void listarRevisionGeneral() {
        RevisionGeneralDao dao;
        try {
            dao = new RevisionGeneralDao();
            array = dao.listar();
        } catch (SQLException e) {
            System.out.println("No se desplego informacion en RevisionGeneralBean " + e);
        }
    }

    public void leerID(RevisionGeneral rge) {
        RevisionGeneralDao ne;
        RevisionGeneral temp;

        try {
            ne = new RevisionGeneralDao();
            temp = ne.leerID(rge);
            if (temp != null) {
                this.rev = temp;
            }
        } catch (SQLException e) {
        }
    }

    public void modificar() {
        RevisionGeneralDao mod;
        try {
            mod = new RevisionGeneralDao();
            mod.modificar(rev);
            this.listarRevisionGeneral();
        } catch (SQLException e) {
            System.out.println("Error RevisionGeneralBean modificar: " + e);
        }
    }

    public void eliminar(RevisionGeneral reee) {
        RevisionGeneralDao elim;
        try {
            elim = new RevisionGeneralDao();
            elim.eliminar(reee);
            this.listarRevisionGeneral();
        } catch (SQLException e) {
            System.out.println("Error RevisionGeneralBean eliminar: " + e);
        }
    }

}
