package com.ClinicaMedica.Bean;

import com.ClinicaMedica.DAO.VistaExamenDAO;
import com.ClinicaMedica.Modelo.Examen;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class VistaExamenBean {

    Examen exa = new Examen();
    ArrayList<Examen> array = new ArrayList();    
    
    
    public VistaExamenBean() {
    }

    public Examen getExa() {
        return exa;
    }

    public void setExa(Examen exa) {
        this.exa = exa;
    }

    public ArrayList<Examen> getArray() {
        return array;
    }

    public void setArray(ArrayList<Examen> array) {
        this.array = array;
    }
    
    
    
    public void listar() {
        System.out.println("ha ingresado a lista bn");
        VistaExamenDAO dao;
        try {
            dao = new VistaExamenDAO();
            exa=dao.listado(exa);
            
        } catch (Exception e) {
            
            System.out.println("error Buscar Examen bn" + e);
        }
    }
    
    
}
