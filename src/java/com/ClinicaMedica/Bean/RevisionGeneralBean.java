package com.ClinicaMedica.Bean;

import com.ClinicaMedica.DAO.RevisionGeneralDao;
import com.ClinicaMedica.Modelo.RevisionGeneral;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author erick osoy
 */


@ViewScoped
@ManagedBean
public class RevisionGeneralBean {

    RevisionGeneral rev = new RevisionGeneral();
    ArrayList<RevisionGeneral> array = new ArrayList();
    
    public RevisionGeneralBean() {
    }

    public RevisionGeneral getRev() {
        return rev;
    }

    public void setRev(RevisionGeneral rev) {
        this.rev = rev;
    }

    public ArrayList<RevisionGeneral> getArray() {
        return array;
    }

    public void setArray(ArrayList<RevisionGeneral> array) {
        this.array = array;
    }
    
    
    
     public void listar() {
        System.out.println("ha ingresado a lista bn RevisionGeneralDAO");
        RevisionGeneralDao dao;
        try {
            dao = new RevisionGeneralDao();
            rev=dao.listado(rev);
            
        } catch (Exception e) {
            
            System.out.println("error listar bn RevisionGeneralDAO" + e);
        }
    }
    
    
}
