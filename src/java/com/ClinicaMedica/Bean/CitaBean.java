package com.ClinicaMedica.Bean;

import com.ClinicaMedica.DAO.CitaDao;
import com.ClinicaMedica.Modelo.Cita;
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
public class CitaBean {

  private Cita ingreso = new Cita();
  private List<Cita> lstCita = new ArrayList();
  
    public CitaBean() {
    }

    public Cita getIngreso() {
        return ingreso;
    }

    public void setIngreso(Cita ingreso) {
        this.ingreso = ingreso;
    }

    public List<Cita> getLstCita() {
        return lstCita;
    }

    public void setLstCita(List<Cita> lstCita) {
        this.lstCita = lstCita;
    }
    
    
    public void listarCita() throws Exception {
        System.out.println("ha ingresado a listar Citas Bean");
        CitaDao dao;

        try {
            dao = new CitaDao();
            lstCita = dao.listarCitas();

        } catch (Exception e) {
            System.out.println("error listar Citas Bean" + e);
        }

    }
    
    
    public void modificar() {
         CitaDao dao;

        try {

            dao = new CitaDao();
            dao.modificar(ingreso);
            this.listarCita();
        } catch (Exception e) {
            System.out.println("error Modificar CITAS  Bean"  + e);
        }
    }
    
     public void leerID(Cita vi) throws Exception {
        System.out.println("ha ingresado a Buscar Cita");
        CitaDao dao;
        Cita temp;
        try {
            dao = new CitaDao();
            temp = dao.leerID(vi); 
            
            if(temp != null){
                this.ingreso = temp;
            }
            
        } catch (Exception e) {
            System.out.println("ERROOOOOOOOOOOOOOOOOOOOOOOOOOR LEER Cita BEAN" + e);
        }
    }          
}
