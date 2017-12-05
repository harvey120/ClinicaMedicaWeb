package com.ClinicaMedica.DAO;

import com.ClinicaMedica.Modelo.HistorialClinico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 */
public class HistorialClinicoDAO extends DAO {

    private PreparedStatement st;

    public void registrar(HistorialClinico histo) throws SQLException {
        try {
            this.Conectar();
            String sql = "INSERT INTO historialclinico(Descripcion, Paciente_idPacientee, IdReferenciaClinica, Enfermedad_idEnfermedadd, Fecha, Hora, IdEmpleado)"
                    + " value(?,?,?,?,?,?,?)";
            this.st = this.getCn().prepareStatement(sql);
            st.setString(1, histo.getDescripcion());
            st.setInt(2, histo.getIdPaciente());
            st.setInt(3, histo.getIdReferenciaClinica());
            st.setInt(4, histo.getIdEnfermedad());
            st.setString(5, histo.getFecha());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Revisa HistorialClinicoDAO");
            System.out.println("No se pudo Insertar en HistorialClinicoDAO" + e);
        } finally {
            this.Cerrar();
        }
    }

    public List<HistorialClinico> listar() throws SQLException {
        List<HistorialClinico> lista = null;
        ResultSet rs;

        try {
            this.Conectar();
            String sql = "SELECT * FROM historialclinico";
            st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                HistorialClinico histo = new HistorialClinico();
                histo.setIdHistorialClinico(rs.getInt("idHistorialClinico"));
                histo.setDescripcion(rs.getString("Descripcion"));
                histo.setIdPaciente(rs.getInt("Paciente_idPacientee"));
                histo.setIdReferenciaClinica(rs.getInt("IdReferenciaClinica"));
                histo.setIdEnfermedad(rs.getInt("Enfermedad_idEnfermedadd"));
                histo.setFecha(rs.getString("Fecha"));
                lista.add(histo);
            }
        } catch (Exception e) {
            System.out.println("Revisa HistorialClinicoDAO");
            System.out.println("Error al desplegar informacion en HistorialClinicoDAO Listar" + e);
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public HistorialClinico leerID(HistorialClinico histo) throws Exception {
        HistorialClinico histor = null;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT * FROM historialclinico WHERE idHistorialClinico = ?";

            this.st = this.getCn().prepareStatement(sql);
            st.setInt(1, histo.getIdHistorialClinico());
            rs = st.executeQuery();

            while (rs.next()) {
                histor = new HistorialClinico();
                histor.setIdHistorialClinico(rs.getInt("idHistorialClinico"));
                histor.setDescripcion(rs.getString("Descripcion"));
                histor.setIdPaciente(rs.getInt("Paciente_idPacientee"));
                histor.setIdReferenciaClinica(rs.getInt("IdReferenciaClinica"));
                histor.setIdEnfermedad(rs.getInt("Enfermedad_idEnfermedadd"));
                histor.setFecha(rs.getString("Fecha"));
            }
        } catch (Exception e) {
            System.out.println("Revisa HistorialClinicoDAO");
            System.out.println("No se pudo LeerID en HistorialClinicoDAO" + e);
        } finally {
            this.Cerrar();
        }
        return histor;
    }

    public void modificar(HistorialClinico histo) throws SQLException {
        try {
            this.Conectar();
            String sql = "UPDATE historialclinico SET Descripcion = ?, Paciente_idPacientee = ?, IdReferenciaClinica = ?, Enfermedad_idEnfermedadd = ?,"
                    + "Fecha= ?, Hora=? , IdEmpleado = ? WHERE idHistorialClinico = ?";

            this.st = this.getCn().prepareStatement(sql);
            st.setString(1, histo.getDescripcion());
            st.setInt(2, histo.getIdPaciente());
            st.setInt(3, histo.getIdReferenciaClinica());
            st.setInt(4, histo.getIdEnfermedad());
            st.setString(5, histo.getFecha());
            st.setInt(8, histo.getIdHistorialClinico());
             
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Revisa HistorialClinicoDAO");
            System.out.println("No se pudo Modificar en HistorialClinicoDAO" + e);
        } finally {
            this.Cerrar();
        }
    }

    public void eliminar(HistorialClinico histo) throws SQLException {
        try {
            this.Conectar();
            String sql = "DELETE FROM historialclinico WHERE idHistorialClinico = ?";
            this.st = this.getCn().prepareStatement(sql);
            st.setInt(1, histo.getIdHistorialClinico());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Revisa PacienteDAO");
            System.out.println("No se pudo Eliminar en HistorialClinicoDAO" + e);
        } finally {
            this.Cerrar();
        }
    }

    public HistorialClinico listado(HistorialClinico topp) throws SQLException{
         ResultSet rs;
        //clase con los 4 atributos
        HistorialClinico topo = new HistorialClinico();
        
        try {
            System.out.println("ingreso a listar HistorialClinico:");
            this.Conectar();
            //sql = "SELECT * FROM Examenesdetalles";
            String sql = "SELECT * FROM historialclinico where idHistorialClinico = ?";
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, topp.getIdHistorialClinico());
            rs = st.executeQuery();            
            while (rs.next()) {
                
                topo.setDescripcion(rs.getString("Descripcion"));
                topo.setIdPaciente(rs.getInt("Paciente_idPacientee"));
                topo.setIdReferenciaClinica(rs.getInt("IdReferenciaClinica"));
                topo.setIdEnfermedad(rs.getInt("Enfermedad_idEnfermedadd"));
                topo.setFecha(rs.getString("FechaHora"));
                topo.setIdHistorialClinico(rs.getInt("idHistorialClinico"));
            

            }
        } catch (Exception e) {
            System.out.println("error de lista: " + e);
        } finally {
            this.Cerrar();
        }
        return topo;
    }
}
