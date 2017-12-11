package com.ClinicaMedica.Bean;

import com.ClinicaMedica.DAO.BusquedaPacienteSecreDAO;
import com.ClinicaMedica.Modelo.BusquedaPacienteSecre;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class BusquedaPacienteSecreBean implements Serializable{

    private BusquedaPacienteSecre nb = new BusquedaPacienteSecre();
    private List<BusquedaPacienteSecre> lstBusqueda;

    public BusquedaPacienteSecreBean() {
    }

    public BusquedaPacienteSecre getNb() {
        return nb;
    }

    public void setNb(BusquedaPacienteSecre nb) {
        this.nb = nb;
    }

    public List<BusquedaPacienteSecre> getLstBusqueda() {
        return lstBusqueda;
    }

    public void setLstBusqueda(List<BusquedaPacienteSecre> lstBusqueda) {
        this.lstBusqueda = lstBusqueda;
    }

    public void Busqueda(BusquedaPacienteSecre npb) {
        BusquedaPacienteSecreDAO nd;
        BusquedaPacienteSecre temp;
        
        try {
            nd = new BusquedaPacienteSecreDAO();
            temp = nd.leerDoc(npb);
            if (temp != null) {
                this.nb = temp;
            }
        } catch (Exception e) {
            System.out.println("Error BusquedaPacienteSecreBean: "+e);
        }
    }

}
