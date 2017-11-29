/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicaMedica.Calendar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ClinicaMedica.Calendar.Evento;
import com.ClinicaMedica.DAO.DAO;

/**
 *
 * @author javam
 */
public class EventoDAO extends DAO {

    String sql;
    PreparedStatement st;

    public void salvar(Evento ex) throws SQLException {
        try {
            this.Conectar();
            System.out.println("holaModificar Cita Dao**************************");
            sql = "Insert into evento(titulo, inicio_evento, fin_evento, desc_evento, status_evento, horainicio, horafin, nombre_empleado, nombre_paciente) values(?,?,?,?,?,?,?,?,?)";
            st = this.getCn().prepareStatement(sql);
            st.setString(1, ex.getTitulo());
            st.setDate(2, new java.sql.Date(ex.getInicio().getTime()));
            st.setDate(3, new java.sql.Date(ex.getFin().getTime()));
            st.setString(4, ex.getDescripcion());
            st.setBoolean(5, ex.isStatus());
            st.setString(6, ex.getHorainicio());
            st.setString(7, ex.getHorafin());
            st.setString(8, ex.getNombre_empleado());
            st.setString(9, ex.getNombre_paciente());
            
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("*********error Insertar Citas DAO **************************" + e);
        } finally {
            this.Cerrar();
        }
    }

    public List<Evento> todosEventos() throws SQLException {
        List<Evento> lista = new ArrayList();
        ResultSet rs;
        int i = -1;
        try {
            System.out.println("daolistar Cita");
            this.Conectar();
            sql = "SELECT * FROM evento";
            st = this.getCn().prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                i++;

                Evento ex = new Evento();

                ex.setId(rs.getLong("id_evento"));
                ex.setTitulo(rs.getString("Titulo"));
                ex.setInicio(rs.getDate("inicio_evento"));
                ex.setFin(rs.getDate("fin_evento"));
                ex.setDescripcion(rs.getString("desc_evento"));
                ex.setStatus(rs.getBoolean("status_evento"));
                ex.setHorainicio(rs.getString("horainicio"));
                ex.setHorafin(rs.getString("horafin"));
                ex.setNombre_empleado(rs.getString("nombre_empleado"));
                ex.setNombre_paciente(rs.getString("nombre_paciente"));
                lista.add(ex);
                //System.out.println(lista.get(i).getCodigo());
            }

        } catch (Exception e) {
            System.out.println("error listar Citas dao" + e);
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public void actualizar(Evento ex) throws SQLException {
        try {
            this.Conectar();
            System.out.println("holaModificar Cita Dao**************************");
            sql = "UPDATE evento SET Titulo=?, inicio_evento=?, fin_evento=?, desc_evento=?, status_evento=?, horainicio=?, horafin=?, nombre_empleado=?, nombre_paciente=? WHERE id_evento = ?;";
            st = this.getCn().prepareStatement(sql);
            st.setString(1, ex.getTitulo());
            st.setDate(2, new java.sql.Date(ex.getInicio().getTime()));
            st.setDate(3, new java.sql.Date(ex.getFin().getTime()));
            st.setString(4, ex.getDescripcion());
            st.setBoolean(5, ex.isStatus());
            st.setString(6, ex.getHorainicio());
            st.setString(7, ex.getHorafin());
            st.setString(8, ex.getNombre_empleado());
            st.setString(9, ex.getNombre_paciente());
            st.setLong(10, ex.getId());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("*********error Modificar Citas DAO **************************" + e);
        } finally {
            this.Cerrar();
        }
    }

    /**
     *
     * public void EliminarCita(Evento ex) throws SQLException { try {
     * this.Conectar(); System.out.println("holaModificar Cita
     * Dao**************************"); sql = "delete from cita where
     * idCita=?;"; st = this.getCn().prepareStatement(sql); st.setInt(1,
     * ex.getIdCita()); st.executeUpdate(); } catch (Exception e) {
     * System.out.println("*********error Insertar Citas DAO
     * **************************" + e); } finally { this.Cerrar(); } }
     *
     *
     */
}
