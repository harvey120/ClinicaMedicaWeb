package com.ClinicaMedica.Bean;

import com.ClinicaMedica.DAO.CategoriaExamenDao;
import com.ClinicaMedica.Modelo.CategoriaExamen;
import java.sql.SQLException;
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
public class CategoriaExamenBean {
    private CategoriaExamen ingreso = new CategoriaExamen();
    private List<CategoriaExamen> lstCategoriaExamenDAO = new ArrayList();
    

    public CategoriaExamen getIngreso() {
        return ingreso;
    }

    public void setIngreso(CategoriaExamen ingreso) {
        this.ingreso = ingreso;
    }

    public List<CategoriaExamen> getLstCategoriaExamenDAO() {
        return lstCategoriaExamenDAO;
    }

    public void setLstCategoriaExamenDAO(List<CategoriaExamen> lstCategoriaExamenDAO) {
        this.lstCategoriaExamenDAO = lstCategoriaExamenDAO;
    }

    
    
    public void listarCategoriaExamen() throws Exception {
        System.out.println("ha ingresado a listar Examenes Bean");
        CategoriaExamenDao dao;

        try {
            dao = new CategoriaExamenDao();
            lstCategoriaExamenDAO = dao.listar();

        } catch (SQLException e) {
            System.out.println("error genero Examenes Bean" + e);
        }
    }
    
}
