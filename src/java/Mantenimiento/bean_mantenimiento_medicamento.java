package Mantenimiento;

import com.ClinicaMedica.Modelo.Medicamento;
import com.ClinicaMedica.Modelo.Provedor;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class bean_mantenimiento_medicamento {

  Provedor pro = new Provedor();
  Medicamento men = new Medicamento();
  ArrayList<Medicamento> lista = new ArrayList();
  ArrayList<Provedor> listo = new ArrayList();

  public Provedor getPro() {
    return pro;
  }

  public void setPro(Provedor pro) {
    this.pro = pro;
  }

  public ArrayList<Provedor> getListo() {
    return listo;
  }

  public void setListo(ArrayList<Provedor> listo) {
    this.listo = listo;
  }

  public Medicamento getMen() {
    return men;
  }

  public void setMen(Medicamento men) {
    this.men = men;
  }

  public ArrayList<Medicamento> getLista() {
    return lista;
  }

  public void setLista(ArrayList<Medicamento> lista) {
    this.lista = lista;
  }

  public void insertar() {
    dao_matenimiento dao;
    System.out.println("ha ingresado a insertar bn");

    try {
      dao = new dao_matenimiento();
      dao.insertarMedicamento(men);
      this.listar();
    } catch (Exception e) {
      System.out.println("error de insertar bn");
    }
    System.out.println("ha ingresado a insertar examen bn");

  }

  public void listar() {
    System.out.println("ha ingresado a lista bn");
    dao_matenimiento dao;

    try {
      dao = new dao_matenimiento();
      lista = dao.listarMedicamento();
      
    } catch (Exception e) {
      System.out.println("error listar bn" + e);
    }
  }

  public void modificar() {
    dao_matenimiento dao;
    System.out.println("ha ingresado a modificar bn");
    try {
      
      dao = new dao_matenimiento();
      dao.modificarMedicamento(men);
      this.listar();
    } catch (Exception e) {
      System.out.println("error de modificar bn" + e);
    }

  }

  public void buscar() {
    System.out.println("ha ingresado a lista bn");
    dao_matenimiento dao = null;
    try {
      
        dao = new dao_matenimiento();
        men = dao.buscarMedicamento(men);


    } catch (Exception e) {

      System.out.println("error listar bn" + e);
    }
  }
  
  
  

  public void buscar2(Medicamento men) {
    System.out.println("ha ingresado a lista bn");
    dao_matenimiento dao;
    Medicamento temp;
    
    try {
      dao = new dao_matenimiento();
      temp = dao.LeerID(men);
      System.out.println("Esto es una prueba: " + temp.getNombre());
      if (temp != null) {
                this.men = temp;
            }
    } catch (Exception e) {

      System.out.println("error listar bn" + e);
    }
  }
  
  
  

  public void listarnuevo() {
    System.out.println("ha ingresado a lista bn");
    dao_listas da;

    try {
      da = new dao_listas();
      listo = da.listarunico();

    } catch (Exception e) {
      System.out.println("error listar bn" + e);
    }
  }
}
