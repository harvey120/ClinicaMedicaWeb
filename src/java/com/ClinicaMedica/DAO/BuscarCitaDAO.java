package com.ClinicaMedica.DAO;

import com.ClinicaMedica.Modelo.Cita;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author erick osoy
 */
public class BuscarCitaDAO extends DAO {

    String sql;
    String pt;
    PreparedStatement st;

    public Cita listado(Cita topp) throws SQLException {
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

    public List<Cita> listarReporte(Cita objeto) throws SQLException {

        List<Cita> lista = null;
        Cita rep = null;
        ResultSet rs;

        try {
            this.Conectar();
            String sql = "SELECT * FROM rptCitas WHERE noDocuemtno =?";
            st = this.getCn().prepareCall(sql);
            st.setString(1, objeto.getNoDocumento());
            rs = st.executeQuery();

            lista = new ArrayList();

            while (rs.next()) {
                rep = new Cita();
                rep.setIdCita(rs.getInt("idCita"));
                rep.setNombreEmpleado(rs.getString("nombreEmpleado"));
                rep.setFecha(rs.getString("fecha"));
                rep.setHorario(rs.getString("hora"));
                rep.setTipo(rs.getString("tipo"));
                rep.setNombrePaciente(rs.getString("nombrePaciente"));
                rep.setNoDocumento(rs.getString("noDocuemtno"));

                lista.add(rep);

            }

        } catch (Exception e) {
             System.out.println("error de lista Cita: " + e);
        } finally {
            this.Cerrar();
        }
        return lista;
    }

}
