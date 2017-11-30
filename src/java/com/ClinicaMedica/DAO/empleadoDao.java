package com.ClinicaMedica.DAO;

import com.ClinicaMedica.Modelo.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class empleadoDao extends DAO{
    String sql;
    PreparedStatement st;
    
    
    public void registrar(Empleado doc) throws Exception {
        try {
            this.Conectar();
            sql = "insert into empleado(idEmpleado, Especialidad_idEspecialidad, Consultorio,"
                + " Estado, Puesto_idPuesto) value(?,?,?,?,?)";
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, doc.getIdEmpleado());
            st.setInt(2, doc.getIdEspecialidad());
            st.setString(3, doc.getConsultorio());
            st.setString(4, doc.getEstado());
            st.setInt(5, doc.getIdPuesto());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Errooooooor" + e);
        } finally {
            this.Cerrar();
        }
    }
    
    
    public List<Empleado> listar() throws Exception {
        List<Empleado> lista = new ArrayList();
        ResultSet rs;
        int i = -1;
        try {
            System.out.println("daolistar");
            this.Conectar();
            sql = "SELECT * FROM empleado";
            st = this.getCn().prepareStatement(sql);

            rs = st.executeQuery();

            while (rs.next()) {
                i++;
                Empleado mar = new Empleado();
                mar.setIdEmpleado(rs.getInt("IdEmpleado"));
                mar.setIdEspecialidad(rs.getInt("Especialidad_idEspecialidad"));
                mar.setConsultorio(rs.getString("Consultorio"));
                mar.setEstado(rs.getString("Estado"));
                mar.setIdPuesto(rs.getInt("Puesto_idPuesto"));
                lista.add(mar);
                //System.out.println(lista.get(i).getCodigo());
            }

        } catch (Exception e) {
            System.out.println("error Pacienete dao" + e);
        } finally {
            this.Cerrar();

        }
        return lista;
    }
    
    
    
    public void modificar(Empleado mar) throws SQLException {
        try {
            this.Conectar();
            System.out.println("hola Documento_Identificacion Dao**************************");
            sql = "UPDATE empleado SET Especialidad_idEspecialidad=?, Consultorio=?, Estado=?,"
                + "Puesto_idPuesto=? WHERE IdEmpleado= ?;";
            
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, mar.getIdEspecialidad());
            st.setString(2, mar.getConsultorio());
            st.setString(3, mar.getEstado());
            st.setInt(4, mar.getIdPuesto());
            st.setInt(5, mar.getIdEmpleado());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("*********error DocumentoIdentificacion DAO **************************" + e);
        } finally {
            this.Cerrar();
        }
    }
    
    
    public void eliminar(Empleado mar) throws SQLException {

        try {
            this.Conectar();
            sql = ("DELETE FROM empleado WHERE IdEmpleado = ?;");
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, mar.getIdEmpleado());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR ELIMINAR Empleado DAO ***********" + e);
        } finally {
            this.Cerrar();
        }

    }
    
    
     public Empleado leerID(Empleado vi) throws Exception {
        Empleado pers = null;
        ResultSet rs;

        try {
            System.out.println("****************daoLEER*********************");
            this.Conectar();
            sql = "SELECT IdEmpleado,Especialidad_idEspecialidad, Consultorio, Estado, Puesto_idPuesto from empleado WHERE IdEmpleado = ?";
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, vi.getIdEmpleado()); 
            rs = st.executeQuery();
            while (rs.next()) {
                pers = new Empleado();
                pers.setIdEmpleado(rs.getInt("idEmpleado"));
                pers.setIdEspecialidad(rs.getInt("Especialidad_idEspecialidad")); 
                pers.setConsultorio(rs.getString("Consultorio")); 
                pers.setEstado(rs.getString("Estado")); 
                pers.setIdPuesto(rs.getInt("Puesto_idPuesto")); 
            }

        } catch (Exception e) {
            System.out.println("***************ERROR LEER ID Dao************" + e);
        } finally {
            this.Cerrar();
        }
        return pers;
    }
    
}
