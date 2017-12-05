package Mantenimiento;

import com.ClinicaMedica.Modelo.Religion;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class bean_religion {
  Religion religion = new Religion();
  ArrayList<Religion> lista=new ArrayList();

  public Religion getReligion() {
    return religion;
  }

  public void setReligion(Religion religion) {
    this.religion = religion;
  }

  public ArrayList<Religion> getLista() {
    return lista;
  }

  public void setLista(ArrayList<Religion> lista) {
    this.lista = lista;
  }
  
  public void insertar() {
        dao_matenimiento dao;
        System.out.println("ha ingresado a insertar bn");

        try {
            dao = new dao_matenimiento();
            dao.insertarReligion(religion);
            this.listar();
        } catch (Exception e) {
            System.out.println("error de insertar bn");
        }
        System.out.println("ha ingresado a insertar examen bn");

    }

    public void listar() {
        
        dao_matenimiento dao;

        try {
            dao = new dao_matenimiento();
            lista = dao.listarReligion();
            System.out.println("ha ingresado a lista bn");
        } catch (Exception e) {
            System.out.println("error listar bn" + e);
        }
    }

    public void modificar() {
        dao_matenimiento dao;
        System.out.println("ha ingresado a modificar bn");
        try {

            dao = new dao_matenimiento();
            dao.modificarReligion(religion);
            this.listar();
        } catch (Exception e) {
            System.out.println("error de modificar bn" + e);
        }
        
    }
    
    public void buscar() {
        System.out.println("ha ingresado a lista bn");
        dao_matenimiento dao;
        try {
            dao = new dao_matenimiento();
            religion=dao.buscarReligion(religion);
            
        } catch (Exception e) {
            
            System.out.println("error listar bn" + e);
        }
     }
    
    public void buscar2(Religion me) {
        System.out.println("ha ingresado a lista bn");
        dao_matenimiento dao;
        try {
            dao = new dao_matenimiento();
            religion=dao.buscarReligion(me);
            
        } catch (Exception e) {
            
            System.out.println("error listar bn" + e);
        }
     }
}
