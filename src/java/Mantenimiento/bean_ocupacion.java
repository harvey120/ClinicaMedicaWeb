package Mantenimiento;

import com.ClinicaMedica.Modelo.Ocupacion;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class bean_ocupacion {
  Ocupacion ocupacion= new Ocupacion();
  ArrayList<Ocupacion> lista= new ArrayList();

  public Ocupacion getOcupacion() {
    return ocupacion;
  }

  public void setOcupacion(Ocupacion ocupacion) {
    this.ocupacion = ocupacion;
  }

  public ArrayList<Ocupacion> getLista() {
    return lista;
  }

  public void setLista(ArrayList<Ocupacion> lista) {
    this.lista = lista;
  }
  
  public void insertar() {
        dao_matenimiento dao;
        System.out.println("ha ingresado a insertar bn");

        try {
            dao = new dao_matenimiento();
            dao.insertarOcupacion(ocupacion);
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
            lista = dao.listarOcupacion();
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
            dao.modificarOcupacion(ocupacion);
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
            ocupacion=dao.buscarOcupacion(ocupacion);
            
        } catch (Exception e) {
            
            System.out.println("error listar bn" + e);
        }
     }
    
    public void buscar2(Ocupacion me) {
        System.out.println("ha ingresado a lista bn");
        dao_matenimiento dao;
        try {
            dao = new dao_matenimiento();
            ocupacion=dao.buscarOcupacion(me);
            
        } catch (Exception e) {
            
            System.out.println("error listar bn" + e);
        }
     }
}
