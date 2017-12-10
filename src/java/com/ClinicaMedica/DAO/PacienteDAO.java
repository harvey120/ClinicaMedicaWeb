package com.ClinicaMedica.DAO;

import com.ClinicaMedica.Modelo.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 */
public class PacienteDAO extends DAO {

    private PreparedStatement st;

    public void registrar(Paciente pac) throws SQLException {
        try {
            this.Conectar();
            String sql = "INSERT INTO paciente(IdPaciente, Domicilio_IdDomicilio, contactoEmergencia, telefonoContacto, ocupacion_idOcupacion)"
                    + " value(?,?,?,?,?)";
            this.st = this.getCn().prepareStatement(sql);
            st.setInt(1, pac.getIdPaciente());
            st.setInt(2, pac.getIdDomicilio());
            st.setString(3, pac.getContactoPersona());
            st.setInt(4, pac.getTelefonoContacto());
            st.setInt(5, pac.getIdOcupacion());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Revisa pacienteDAO");
            System.out.println("No se pudo Insertar en PacienteDAO" + e);
        } finally {
            this.Cerrar();
        }
    }

    public List<Paciente> listar() throws SQLException {
        List<Paciente> lista = null;
        ResultSet rs;

        try {
            this.Conectar();
            String sql = "SELECT * FROM paciente";
            st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Paciente pac = new Paciente();
                pac.setIdPaciente(rs.getInt("IdPaciente"));
                pac.setIdDomicilio(rs.getInt("Domicilio_IdDomicilio"));
                pac.setContactoPersona(rs.getString("contactoEmergencia"));
                pac.setTelefonoContacto(rs.getInt("telefonoContacto"));
                pac.setIdOcupacion(rs.getInt("ocupacion_idOcupacion"));
                lista.add(pac);
            }
        } catch (Exception e) {
            System.out.println("Revisa PacienteDAO");
            System.out.println("Error al desplegar informacion en PacienteDAO Listar" + e);
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public List<Paciente> rptPacienteMedico(Paciente obejto) throws SQLException {
        List<Paciente> lista = null;
        ResultSet rs;

        try {
            this.Conectar();
            String sql = "SELECT * FROM rptPacienteMedico WHERE noDocumento = ?";
            st = this.getCn().prepareCall(sql);
            st.setString(1, obejto.getNoDocumento());
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Paciente pac = new Paciente();
                pac.setNombre(rs.getString("nombrePaciente"));
                pac.setOcupacion(rs.getString("ocupacion"));
                pac.setDireccion(rs.getString("direccion"));
                pac.setContactoEmergencia(rs.getString("contactoEmergencia"));
                pac.setTelefonoEmergencia(rs.getString("telefonoEmergencia"));
                lista.add(pac);
            }
        } catch (Exception e) {
            System.out.println("Revisa PacienteDAO");
            System.out.println("Error al desplegar informacion en PacienteDAO Listar" + e);
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public Paciente leerID(Paciente pac) throws Exception {
        Paciente paci = null;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT * FROM paciente WHERE idPaciente = ?";

            this.st = this.getCn().prepareStatement(sql);
            st.setInt(1, pac.getIdPaciente());
            rs = st.executeQuery();

            while (rs.next()) {
                paci = new Paciente();
                paci.setIdDomicilio(rs.getInt("Domicilio_IdDomicilio"));
                paci.setContactoPersona(rs.getString("contactoEmergencia"));
                paci.setTelefonoContacto(rs.getInt("telefonoContacto"));
                paci.setIdOcupacion(rs.getInt("ocupacion_idOcupacion"));
                paci.setIdPaciente(rs.getInt("idPaciente"));
            }
        } catch (Exception e) {
            System.out.println("Revisa PacienteDAO");
            System.out.println("No se pudo LeerID en PacienteDAO" + e);
        } finally {
            this.Cerrar();
        }
        return paci;
    }

    public void modificar(Paciente pac) throws SQLException {
        try {
            this.Conectar();
            String sql = "UPDATE paciente SET Domicilio_IdDomicilio = ?, contactoEmergencia = ?"
                    + ", telefonoContacto = ?, ocupacion_idOcupacion = ? WHERE IdPaciente = ?";

            this.st = this.getCn().prepareStatement(sql);
            st.setInt(1, pac.getIdDomicilio());
            st.setString(2, pac.getContactoPersona());
            st.setInt(3, pac.getTelefonoContacto());
            st.setInt(4, pac.getIdOcupacion());
            st.setInt(5, pac.getIdPaciente());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Revisa PacienteDAO");
            System.out.println("No se pudo Modificar en PacienteDAO" + e);
        } finally {
            this.Cerrar();
        }
    }

    public void eliminar(Paciente pac) throws SQLException {
        try {
            this.Conectar();
            String sql = "DELETE FROM paciente WHERE idPaciente = ?";
            this.st = this.getCn().prepareStatement(sql);
            st.setInt(1, pac.getIdPaciente());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Revisa PacienteDAO");
            System.out.println("No se pudo Eliminar en PacienteDAO" + e);
        } finally {
            this.Cerrar();
        }
    }

    public Paciente listado(Paciente topp) throws SQLException {
        ResultSet rs;
        //clase con los 4 atributos
        Paciente topo = new Paciente();

        try {
            System.out.println("ingreso a Paciente Buscar:");
            this.Conectar();
            String sql = "SELECT * FROM Paciente where idPaciente = ?";
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
