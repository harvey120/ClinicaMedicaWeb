package com.ClinicaMedica.DAO;

import com.ClinicaMedica.Modelo.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 */
public class PersonaDAO extends DAO {

    private PreparedStatement st;

    public void registrar(Persona per) throws SQLException {
        try {
            this.Conectar();
            String sql = "INSERT INTO persona(idPersona, Nombre, Apellido, FechaNac, Telefono, CorreoElectronico,"
                    + " Genero_idSexo, EstadoCivil_idEstCivil, IdDocumentoPaciente, NoDocumento,"
                    + " Religion_IdReligion) value(?,?,?,?,?,?,?,?,?,?,?)";
            this.st = this.getCn().prepareStatement(sql);
            st.setInt(1, per.getIdPersona());
            st.setString(2, per.getNombre());
            st.setString(3, per.getApellido());
            st.setString(4, per.getFechaNacimiento());
            st.setString(5, per.getTelefono());
            st.setString(6, per.getCorreoElectronico());
            st.setInt(7, per.getIdGenero());
            st.setInt(8, per.getIdEstadoCivil());
            st.setInt(9, per.getIdDocumentoPaciente());
            st.setString(10, per.getNoDocumento());
            st.setInt(11, per.getIdReligion());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Revisa personaDAO");
            System.out.println("No se pudo Insertar en PersonaDAO" + e);
        } finally {
            this.Cerrar();
        }
    }

    public List<Persona> listar() throws SQLException {
        List<Persona> lista = null;
        ResultSet rs;

        try {
            this.Conectar();
            String sql = "SELECT * FROM persona";
            st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Persona per = new Persona();
                per.setIdPersona(rs.getInt("idPersona"));
                per.setNombre(rs.getString("Nombre"));
                per.setApellido(rs.getString("Apellido"));
                per.setFechaNacimiento(rs.getString("FechaNac"));
                per.setTelefono(rs.getString("Telefono"));
                per.setCorreoElectronico(rs.getString("CorreoElectronico"));
                per.setIdGenero(rs.getInt("Genero_idSexo"));
                per.setIdEstadoCivil(rs.getInt("EstadoCivil_idEstCivil"));
                per.setIdDocumentoPaciente(rs.getInt("IdDocumentoPaciente"));
                per.setNoDocumento(rs.getString("NoDocumento"));
                per.setIdReligion(rs.getInt("Religion_IdReligion"));
                lista.add(per);
            }

        } catch (Exception e) {
            System.out.println("Revisa PersonaDAO");
            System.out.println("Error al desplegar informacion en PersonaDAO Listar" + e);
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public Persona leerID(Persona per) throws Exception {
        Persona pers = null;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "SELECT * FROM persona WHERE idPersona = ?";

            this.st = this.getCn().prepareStatement(sql);
            st.setInt(1, per.getIdPersona());
            rs = st.executeQuery();
            
            while (rs.next()) {
                pers = new Persona();
                pers.setIdPersona(rs.getInt("idPersona"));
                pers.setNombre(rs.getString("Nombre"));
                pers.setApellido(rs.getString("Apellido"));
                pers.setFechaNacimiento(rs.getString("FechaNac"));
                pers.setTelefono(rs.getString("Telefono"));
                pers.setCorreoElectronico(rs.getString("CorreoElectronico"));
                pers.setIdGenero(rs.getInt("Genero_idSexo"));
                pers.setIdEstadoCivil(rs.getInt("EstadoCivil_idEstCivil"));
                pers.setIdDocumentoPaciente(rs.getInt("IdDocumentoPaciente"));
                pers.setNoDocumento(rs.getString("NoDocumento"));
                pers.setIdReligion(rs.getInt("Religion_IdReligion"));
            }
        } catch (Exception e) {
            System.out.println("Revisa personaDAO");
            System.out.println("No se pudo LeerID en PersonaDAO" + e);
        } finally {
            this.Cerrar();
        }
        return pers;
    }

    public void modificar(Persona per) throws SQLException {
        try {
            this.Conectar();
            String sql = "UPDATE persona SET  Nombre = ?, Apellido = ?, FechaNac = ?, Telefono = ?, CorreoElectronico = ?,"
                    + " Genero_idSexo = ?, EstadoCivil_idEstCivil = ?, IdDocumentoPaciente = ?, NoDocumento = ?,"
                    + " Religion_IdReligion = ? WHERE idPersona = ?";
            this.st = this.getCn().prepareStatement(sql);
            st.setString(1, per.getNombre());
            st.setString(2, per.getApellido());
            st.setString(3, per.getFechaNacimiento());
            st.setString(4, per.getTelefono());
            st.setString(5, per.getCorreoElectronico());
            st.setInt(6, per.getIdGenero());
            st.setInt(7, per.getIdEstadoCivil());
            st.setInt(8, per.getIdDocumentoPaciente());
            st.setString(9, per.getNoDocumento());
            st.setInt(10, per.getIdReligion());
            st.setInt(11, per.getIdPersona());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Revisa personaDAO");
            System.out.println("No se pudo Modificar en PersonaDAO" + e);
        } finally {
            this.Cerrar();
        }
    }
    
    public void eliminar(Persona per) throws SQLException {
        try {
            this.Conectar();
            String sql = "DELETE FROM persona WHERE idPersona = ?";
            this.st = this.getCn().prepareStatement(sql);
            st.setInt(1, per.getIdPersona());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Revisa personaDAO");
            System.out.println("No se pudo Modificar en PersonaDAO" + e);
        } finally {
            this.Cerrar();
        }
    }
}
