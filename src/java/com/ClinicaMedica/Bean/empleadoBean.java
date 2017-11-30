package com.ClinicaMedica.Bean;

import com.ClinicaMedica.DAO.empleadoDao;
import com.ClinicaMedica.Modelo.Empleado;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class empleadoBean {
    private Empleado ingreso = new Empleado();
    private List<Empleado> lstEmpleado = new ArrayList();
    
    
    public empleadoBean(){
        
    }

    public Empleado getIngreso() {
        return ingreso;
    }

    public void setIngreso(Empleado ingreso) {
        this.ingreso = ingreso;
    }

    public List<Empleado> getLstEmpleado() {
        return lstEmpleado;
    }

    public void setLstEmpleado(List<Empleado> lstEmpleado) {
        this.lstEmpleado = lstEmpleado;
    }
    
    

    
     public void insertar() throws Exception {
        System.out.println("ha ingresado a Empleado");
        empleadoDao dao;
       // ingreso.setIdEmpleado(persona.getIdPersona());
        try {
            dao = new empleadoDao();
            dao.registrar(ingreso);
            this.listar();
            this.limpiar();
        } catch (Exception e) {
            System.out.println("ERROOOOOOOOOOOOOOOOOOOOOOOOOOR INSERTAR BEAN" + e);
        }
    }
    
    
    public void listar() throws Exception {
        System.out.println("ha ingresado a listar");
        empleadoDao dao;

        try {
            dao = new empleadoDao();
            lstEmpleado = dao.listar();

        } catch (Exception e) {
            System.out.println("error listar" + e);
        }

    }
    

    public void modificar() {
         empleadoDao dao;

        try {

            dao = new empleadoDao();
            dao.modificar(ingreso);
            this.listar();
        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }

    public void eliminar(Empleado mar) throws Exception {
        empleadoDao dao;

        try {
            dao = new empleadoDao();
            dao.eliminar(mar);
            this.listar();
        } catch (Exception e) {
            System.out.println("error bean eliminar:" + e);
        }
    }
    
    public void leerID(Empleado vi) throws Exception {
        System.out.println("ha ingresado a insertar");
        empleadoDao dao;
        Empleado temp;
        try {
            dao = new empleadoDao();
            temp = dao.leerID(vi); 
            
            if(temp != null){
                this.ingreso = temp;
            }
            
        } catch (Exception e) {
            System.out.println("ERROOOOOOOOOOOOOOOOOOOOOOOOOOR INSERTAR BEAN" + e);
        }
    }
    
    public void limpiar(){
        ingreso.setIdEmpleado(0);
        ingreso.setIdEspecialidad(0);
        ingreso.setConsultorio("");
        ingreso.setEstado("");
        ingreso.setIdPuesto(0);
    }
    
}
