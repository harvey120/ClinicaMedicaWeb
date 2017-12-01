package com.ClinicaMedica.VistaDAO;

import com.ClinicaMedica.DAO.DAO;
import com.ClinicaMedica.Modelo.Empleado;
import com.ClinicaMedica.Modelo.Persona;
import com.ClinicaMedica.Modelo.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Harvey
 */
public class VistaDAOEmpleado extends DAO {

    private PreparedStatement st;
    public int retorno = 0;

    public void registrarEmpleado(Persona per, Empleado emp) throws SQLException {
        try {
            this.Conectar();
            String sql = "INSERT INTO persona(idPersona, Nombre, Apellido, FechaNac, Telefono, CorreoElectronico,"
                    + " Genero_idSexo, EstadoCivil_idEstCivil, IdDocumentoPaciente, NoDocumento,"
                    + " Religion_IdReligion) value(?,?,?,?,?,?,?,?,?,?,?)";
            this.st = this.getCn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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
            ResultSet rs = st.getGeneratedKeys();
            rs.next();
            retorno = rs.getInt(1);

            System.out.println("valor: " + retorno);
            
        } catch (Exception e) {
            System.out.println("Revisa personaDAO");
            System.out.println("No se pudo Insertar en VistaDAOEmpleado" + e);
        } finally {
            this.Cerrar();
        }

        emp.setIdEmpleado(retorno); //  este es el valor de retorno para la nueva tabla

        try {
            System.out.println("Esta a punto de agregar empleado");
            System.out.println("empleado " + emp.getIdEmpleado());
            this.Conectar();
            String sql = "insert into empleado(idEmpleado, Especialidad_idEspecialidad, Consultorio,"
                    + " Estado, Puesto_idPuesto) value(?,?,?,?,?)";
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, emp.getIdEmpleado());
            st.setInt(2, emp.getIdEspecialidad());
            st.setString(3, emp.getConsultorio());
            st.setString(4, emp.getEstado());
            st.setInt(5, emp.getIdPuesto());
            st.executeUpdate();

        } catch (Exception e) {
            System.out.println("Revisa empleadoDAO");
            System.out.println("No se pudo Insertar en VistaDAOEmpleado" + e);
        } finally {
            this.Cerrar();
        }
    }

    public void registrarAdmin(Persona per, Empleado emp, Usuarios usu) throws SQLException {
        try {
            this.Conectar();
            String sql = "INSERT INTO persona(idPersona, Nombre, Apellido, FechaNac, Telefono, CorreoElectronico,"
                    + " Genero_idSexo, EstadoCivil_idEstCivil, IdDocumentoPaciente, NoDocumento,"
                    + " Religion_IdReligion) value(?,?,?,?,?,?,?,?,?,?,?)";
            this.st = this.getCn().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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
            ResultSet rs = st.getGeneratedKeys();
            rs.next();
            retorno = rs.getInt(1);

          
            
        } catch (Exception e) {
            System.out.println("Revisa personaDAO");
            System.out.println("No se pudo Insertar en VistaDAOEmpleado" + e);
        } finally {
            this.Cerrar();
        }

        emp.setIdEmpleado(retorno); //  este es el valor de retorno para la nueva tabla

        try {
            System.out.println("Esta a punto de agregar empleado");
            System.out.println("empleado " + emp.getIdEmpleado());
            this.Conectar();
            String sql = "insert into empleado(idEmpleado, Especialidad_idEspecialidad, Consultorio,"
                    + " Estado, Puesto_idPuesto) value(?,?,?,?,?)";
            st = this.getCn().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, emp.getIdEmpleado());
            st.setInt(2, emp.getIdEspecialidad());
            st.setString(3, emp.getConsultorio());
            st.setString(4, emp.getEstado());
            st.setInt(5, emp.getIdPuesto());
            st.executeUpdate();
            
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            rs.next();
            retorno = rs.getInt(1);
            
        } catch (Exception e) {
            System.out.println("Revisa empleadoDAO");
            System.out.println("No se pudo Insertar en VistaDAOEmpleado" + e);
        } finally {
            this.Cerrar();
        }
        
        usu.setIdUsuario(retorno);//  este es el valor de retorno para la nueva tabla   
        

        try {
            this.Conectar();
            String sql = "insert into usuario( idUsuario,Usuario, Contrasenia, EstadoUsuario_idEstadoUsuario) value(?,?,?,?)";
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, usu.getIdUsuario());
            st.setString(2, usu.getUsuario());
            st.setString(3, usu.getContrasenia());
            st.setInt(4, usu.getIdEstadoUsuario());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("***************ERROR Insertar UsuarioDao************" + e);
        } finally {
            this.Cerrar();
        }
    }

}
