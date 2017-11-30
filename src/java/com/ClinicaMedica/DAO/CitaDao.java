/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicaMedica.DAO;

import com.ClinicaMedica.Modelo.Cita;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javam
 */
public class CitaDao extends DAO {

    public void insertar(Cita ne) throws SQLException {
        try {
            this.Conectar();
            String sql = "INSERT INTO cita VALUES (?,?,?,?,?,?)";
            PreparedStatement ns = this.getCn().prepareStatement(sql);
            ns.setInt(1, ne.getIdCita());
            ns.setString(2, ne.getFecha());
            ns.setString(3, ne.getHorario());
            ns.setInt(4, ne.getEmpleado_idEmpleado());
            ns.setInt(5, ne.getEstadoCita_idEstadoCita());
            ns.setInt(6, ne.getPaciente_idPaciente());

            ns.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error CitaDao insertar: " + e);
        } finally {
            this.Cerrar();
        }
    }

    public List<Cita> listar() throws SQLException {
        List<Cita> lista = null;
        ResultSet rs;

        try {
            this.Conectar();
            String sql = "SELECT ci.idCita as id, ci.Fecha as fecha, ci.Horario as horarios, per.Nombre as nombre , es.Tipo as estado_cita\n"
                    + "from persona as per inner join empleado as emp\n"
                    + "on per.idPersona = emp.idEmpleado inner join cita as ci\n"
                    + "on emp.idEmpleado = ci.Empleado_idEmpleado inner join estadocita as es\n"
                    + "on es.IdEstadoCita = ci.EstadoCita_idEstadoCita";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Cita cit = new Cita();
                cit.setIdCita(rs.getInt("id"));
                cit.setFecha(rs.getString("fecha"));
                cit.setHorario(rs.getString("horario"));
                cit.setEmpleado_idEmpleado(rs.getInt("nombre"));
                cit.setEstadoCita_idEstadoCita(rs.getInt("estado_cita"));
                lista.add(cit);
            }
        } catch (SQLException e) {
            System.out.println("Error al desplegar informacion en CitaDao Listar" + e);
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public Cita leerID(Cita ci) throws SQLException {
        Cita cit = null;
        ResultSet nr;

        try {
            this.Conectar();
            String sql = "SELECT * FROM cita WHERE idCita = ?";
            PreparedStatement ns = this.getCn().prepareStatement(sql);
            ns.setInt(1, ci.getIdCita());
            nr = ns.executeQuery();

            while (nr.next()) {
                cit = new Cita();
                cit.setIdCita(nr.getInt("idCita"));
                cit.setFecha(nr.getString("Fecha"));
                cit.setHorario(nr.getString("Horario"));
                cit.setEmpleado_idEmpleado(nr.getInt("Empleado_idEmpleado"));
                cit.setEstadoCita_idEstadoCita(nr.getInt("EstadoCita_idEstadoCita"));
                cit.setPaciente_idPaciente(nr.getInt("Paciente_idPaciente"));

            }
        } catch (SQLException e) {
            System.out.println("ERROR CitaDao leerID: " + e);
        } finally {
            this.Cerrar();
        }
        return cit;
    }

    public void modificar(Cita cii) throws SQLException {
        try {
            this.Conectar();
            String sql = "UPDATE cita SET Fecha=?, Horario=?, Empleado_idEmpleado=?, EstadoCita_idEstadoCita=?, Paciente_idPaciente=? WHERE idCita=?";
            PreparedStatement ns = this.getCn().prepareStatement(sql);
            ns.setString(1, cii.getFecha());
            ns.setString(2, cii.getHorario());
            ns.setInt(3, cii.getEmpleado_idEmpleado());
            ns.setInt(4, cii.getEstadoCita_idEstadoCita());
            ns.setInt(5, cii.getPaciente_idPaciente());
            ns.setInt(6, cii.getIdCita());
            ns.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error citaDao modificar: " + e);
        } finally {
            this.Cerrar();
        }
    }

    public void eliminar(Cita citt) throws SQLException {
        try {
            this.Conectar();
            String sql = "DELETE FROM cita WHERE idCita = ?";
            PreparedStatement ns = this.getCn().prepareStatement(sql);
            ns.setInt(1, citt.getIdCita());
            ns.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error CitaDao eliminar: " + e);
        } finally {
            this.Cerrar();
        }
    }
}
