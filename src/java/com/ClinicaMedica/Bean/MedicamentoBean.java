package com.ClinicaMedica.Bean;

import com.ClinicaMedica.DAO.MedicamentoDAO;
import com.ClinicaMedica.Modelo.Medicamento;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    List<Medicamento> array = new ArrayList<>();

    public MedicamentoBean() {
    }

    public Medicamento getMed() {
        return med;
    }

    public void setMed(Medicamento med) {
        this.med = med;
    }

    public List<Medicamento> getArray() {
        return array;
    }

    public void setArray(List<Medicamento> array) {
        this.array = array;
    }

    public void listar() {

        MedicamentoDAO dao = null;
        try {
            dao = new MedicamentoDAO();
            array = dao.listarMedicamento(med);
            med.setIdmedicamento(array.get(0).getIdmedicamento());
            med.setNombre(array.get(0).getNombre());
            med.setDescripcion(array.get(0).getDescripcion());
            med.setFecha(array.get(0).getFecha());
            med.setProvedor(array.get(0).getProvedor());
        } catch (Exception e) {
            System.out.println("Hubo error al desplegar informacion en listarMedicamento DAO ");
        }

    }

}
