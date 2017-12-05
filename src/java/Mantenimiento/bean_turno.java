package Mantenimiento;

import com.ClinicaMedica.Modelo.Turno;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class bean_turno {
   Turno turno = new Turno();
   ArrayList<Turno> lista= new ArrayList();

  public Turno getTurno() {
    return turno;
  }

  public void setTurno(Turno turno) {
    this.turno = turno;
  }

  public ArrayList<Turno> getLista() {
    return lista;
  }

  public void setLista(ArrayList<Turno> lista) {
    this.lista = lista;
  }
   
   public void insertar() {
        dao_matenimiento dao;
        System.out.println("ha ingresado a insertar bn");

        try {
            dao = new dao_matenimiento();
            dao.insertarTurno(turno);
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
            lista = dao.listarTurno();
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
            dao.modificarTurno(turno);
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
            turno=dao.buscarTurno(turno);
            
        } catch (Exception e) {
            
            System.out.println("error listar bn" + e);
        }
     }
    
    public void buscar2(Turno me) {
        System.out.println("ha ingresado a lista bn");
        dao_matenimiento dao;
        try {
            dao = new dao_matenimiento();
            turno=dao.buscarTurno(me);
            
        } catch (Exception e) {
            
            System.out.println("error listar bn" + e);
        }
     }
}
