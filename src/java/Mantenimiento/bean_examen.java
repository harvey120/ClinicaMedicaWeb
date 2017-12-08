package Mantenimiento;

import com.ClinicaMedica.Modelo.Examen;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class bean_examen {
  Examen exe= new Examen();
  ArrayList<Examen> lista= new ArrayList();

  public Examen getExe() {
    return exe;
  }

  public void setExe(Examen exe) {
    this.exe = exe;
  }

  public ArrayList<Examen> getLista() {
    return lista;
  }

  public void setLista(ArrayList<Examen> lista) {
    this.lista = lista;
  }
  
  public void insertar() {
        dao_matenimiento dao;
        System.out.println("ha ingresado a insertar bn");

        try {
            dao = new dao_matenimiento();
            dao.insertarExamen(exe);
            this.listar();
        } catch (Exception ex) {
            System.out.println("error de insertar bn:  " +ex);
        }
        System.out.println("ha ingresado a insertar examen bn");

    }

    public void listar() {
        
        dao_matenimiento dao;

        try {
            dao = new dao_matenimiento();
            lista = dao.listarExamen();
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
            dao.modificarExamen(exe);
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
            exe=dao.buscarExamen(exe);
            
        } catch (Exception e) {
            
            System.out.println("error listar bn" + e);
        }
     }
    
    public void buscar2(Examen me) {
        System.out.println("ha ingresado a lista bn");
        dao_matenimiento dao;
        try {
            dao = new dao_matenimiento();
            exe=dao.buscarExamen(me);
            
        } catch (Exception e) {
            
            System.out.println("error listar bn" + e);
        }
     }

}
