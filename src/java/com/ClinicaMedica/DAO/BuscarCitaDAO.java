package com.ClinicaMedica.DAO;

import com.ClinicaMedica.Modelo.Cita;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author erick osoy
 */
public class BuscarCitaDAO extends DAO{
    
    String sql;
    String pt;
    PreparedStatement st;
    
     public Cita listado(Cita topp) throws SQLException{
         ResultSet rs;
        //clase con los 4 atributos
        Cita topo = new Cita();
        
        try {
            System.out.println("ingreso a listar Cita:");
            this.Conectar();
            //sql = "SELECT * FROM Examenesdetalles";
            sql = "SELECT * FROM Cita where idCita = ?";
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, topp.getIdCita());
            rs = st.executeQuery();            
            while (rs.next()) {
                
                topo.setFecha(rs.getString("Fecha"));
                topo.setHorario(rs.getString("Horario"));
                topo.setEmpleado_idEmpleado(rs.getInt("Empleado_idEmpleado"));
                topo.setEstadoCita_idEstadoCita(rs.getInt("EstadoCita_idEstadoCita"));
                topo.setPaciente_idPaciente(rs.getInt("Paciente_idPaciente"));
                topo.setIdCita(rs.getInt("idCita"));
                
            }
        } catch (Exception e) {
            System.out.println("error de lista Cita: " + e);
        } finally {
            this.Cerrar();
        }
        return topo;
    }
    
}
