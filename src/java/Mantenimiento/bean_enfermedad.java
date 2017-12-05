package Mantenimiento;

import com.ClinicaMedica.Modelo.Enfermedad;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class bean_enfermedad {
  Enfermedad enfermedad= new Enfermedad();
  ArrayList<Enfermedad>lista= new ArrayList();

  public Enfermedad getEnfermedad() {
    return enfermedad;
  }

  public void setEnfermedad(Enfermedad enfermedad) {
    this.enfermedad = enfermedad;
  }

  public ArrayList<Enfermedad> getLista() {
    return lista;
  }

  public void setLista(ArrayList<Enfermedad> lista) {
    this.lista = lista;
  }
  
  public void insertar() {
        dao_matenimiento dao;
        System.out.println("ha ingresado a insertar bn");

        try {
            dao = new dao_matenimiento();
            dao.insertarEnfermedad(enfermedad);
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
            lista = dao.listarEnfermedad();
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
            dao.modificarEnfermedad(enfermedad);
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
            enfermedad=dao.buscarEnfermedad(enfermedad);
            
        } catch (Exception e) {
            
            System.out.println("error listar bn" + e);
        }
     }
    
    public void buscar2(Enfermedad me) {
        System.out.println("ha ingresado a lista bn");
        dao_matenimiento dao;
        try {
            dao = new dao_matenimiento();
            enfermedad=dao.buscarEnfermedad(me);
            
        } catch (Exception e) {
            
            System.out.println("error listar bn" + e);
        }
     }
}
