package com.ClinicaMedica.Bean;

import com.ClinicaMedica.DAO.HistorialClinicoDAO;
import com.ClinicaMedica.Modelo.HistorialClinico;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author erick osoy
 */
@ViewScoped
@ManagedBean   
public class HistorialBean {
    
    HistorialClinico his = new HistorialClinico();
    ArrayList<HistorialClinico> array = new ArrayList();
    
    
    public HistorialBean() {
    
    }

    public HistorialClinico getHis() {
        return his;
    }

    public void setHis(HistorialClinico his) {
        this.his = his;
    }

    public ArrayList<HistorialClinico> getArray() {
        return array;
    }

    public void setArray(ArrayList<HistorialClinico> array) {
        this.array = array;
    }
    
    
     public void listar() {
        System.out.println("ha ingresado a lista HistorialDAO bn");
        HistorialClinicoDAO dao;
        try {
            dao = new HistorialClinicoDAO() ;
            his=dao.listado(his);
            
        } catch (Exception e) {
            
            System.out.println("error listar HistorialDAO bn" + e);
        }
    }
    
    
    
    
}
