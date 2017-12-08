package com.ClinicaMedica.DAO;

import com.ClinicaMedica.Modelo.vistaCita;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javam
 */
public class VistaCitaDAO extends DAO {

    public List<vistaCita> listar() throws SQLException {
        List<vistaCita> lista = null;
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
                vistaCita cit = new vistaCita();
                cit.setId(rs.getInt("id"));
                cit.setFecha(rs.getString("fecha"));
                cit.setHorario(rs.getString("horarios"));
                cit.setNombre(rs.getString("nombre"));
                cit.setEstado_cita(rs.getString("estado_cita"));
                lista.add(cit);
            }
        } catch (SQLException e) {
            System.out.println("Error al desplegar informacion en CitaDao Listar" + e);
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    

}
