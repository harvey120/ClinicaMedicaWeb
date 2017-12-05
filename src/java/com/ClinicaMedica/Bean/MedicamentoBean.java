package com.ClinicaMedica.Bean;

import com.ClinicaMedica.DAO.MedicamentoDAO;
import com.ClinicaMedica.Modelo.Medicamento;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author erick osoy
 */

@ViewScoped
@ManagedBean     
public class MedicamentoBean {

    Medicamento med = new Medicamento();
    ArrayList<Medicamento> array = new ArrayList();
    
    public MedicamentoBean() {
    }

    public Medicamento getMed() {
        return med;
    }

    public void setMed(Medicamento med) {
        this.med = med;
    }

    public ArrayList<Medicamento> getArray() {
        return array;
    }

    public void setArray(ArrayList<Medicamento> array) {
        this.array = array;
    }
    
    
    
    
    public void listar() {
        System.out.println("ha ingresado a lista bn");
        MedicamentoDAO dao;
        try {
            dao = new MedicamentoDAO() ;
            med=dao.listado(med);
            
        } catch (SQLException e) {
            
            System.out.println("error listar bn" + e);
        }
    }

}
