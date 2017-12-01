package Mantenimiento;

import com.ClinicaMedica.Modelo.Medicamento;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class bean_mantenimiento_medicamento {
    
    Medicamento men = new Medicamento();
    ArrayList<Medicamento> lista= new ArrayList();

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
            dao.insertarMedicamento();
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
            for (int i = 0; i < lista.size(); i++) {
                System.out.println("Codigo: " + lista.get(i).getNombre());
            }
        } catch (Exception e) {
            System.out.println("error listar bn" + e);
        }
    }

    public void modificar(Medicamento me) {
        dao_matenimiento dao;
        System.out.println("ha ingresado a modificar bn");
        try {

            dao = new dao_matenimiento();
            dao.modificarMedicamento();
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
            men=dao.buscarMedicamento(men);
            
        } catch (Exception e) {
            
            System.out.println("error listar bn" + e);
        }
     }
}
