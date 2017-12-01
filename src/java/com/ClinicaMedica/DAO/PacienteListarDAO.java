package com.ClinicaMedica.DAO;

import com.ClinicaMedica.Modelo.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PacienteListarDAO extends DAO{
    
    String sql;
    String pt;
    PreparedStatement st;
    
    
    public Paciente listado(Paciente topp) throws SQLException{
         ResultSet rs;
        //clase con los 4 atributos
        Paciente topo = new Paciente();
        
        try {
            System.out.println("ingreso a Paciente Buscar:");
            this.Conectar();
            //sql = "SELECT * FROM Examenesdetalles";
            sql = "SELECT * FROM Paciente where idPaciente = ?";
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, topp.getIdPaciente());
            rs = st.executeQuery();            
            while (rs.next()) {
                
                topo.setIdDomicilio(rs.getInt("Domicilio_IdDomicilio"));
                topo.setContactoPersona(rs.getString("contactoEmergencia"));
                topo.setTelefonoContacto(rs.getInt("telefonoContacto"));
                topo.setIdOcupacion(rs.getInt("ocupacion_idOcupacion"));
                topo.setIdPaciente(rs.getInt("idPaciente"));
                
            }
        } catch (Exception e) {
            System.out.println("error de Buscar Paciente    : " + e);
        } finally {
            this.Cerrar();
        }
        return topo;
    }
    
}
