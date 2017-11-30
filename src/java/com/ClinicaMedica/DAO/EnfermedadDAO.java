package com.ClinicaMedica.DAO;

import com.ClinicaMedica.Modelo.Enfermedad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 */
public class EnfermedadDAO extends DAO{
    
      public void insertar(Enfermedad ne) throws SQLException{
        try {
            this.Conectar();
            String sql = "INSERT INTO enfermedad VALUES (?,?,?)";
            PreparedStatement ns = this.getCn().prepareStatement(sql);
            ns.setInt(1, ne.getIdEnfermedad());
            ns.setString(2, ne.getNombre());
            ns.setInt(3, ne.getIdCategoriaEnfermedad());
            ns.executeUpdate();            
        } catch (SQLException e) {
            System.out.println("Error EnfermedadDao insertar: "+e);
        } finally {
            this.Cerrar();
        }
    }
      
    public List<Enfermedad> listar() throws SQLException {
        List<Enfermedad> lista = null;
        ResultSet rs;

        try {
            this.Conectar();
            String sql = "SELECT * FROM enfermedad";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Enfermedad enfer = new Enfermedad();
                enfer.setIdEnfermedad(rs.getInt("IdEnfermedad"));
                enfer.setNombre(rs.getString("Nombre"));
                enfer.setIdCategoriaEnfermedad(rs.getInt("CategoriaEnfermedad_IdCategoriaE"));
                lista.add(enfer);
            }
        } catch (Exception e) {
            System.out.println("Error al desplegar informacion en EnfermedadDAO Listar" + e);
        } finally {
            this.Cerrar();
        }
        return lista;
    }
      public Enfermedad leerID(Enfermedad en) throws SQLException{
        Enfermedad ne = null;
        ResultSet nr;
        
        try {
            this.Conectar();
            String sql = "SELECT * FROM enfermedad WHERE IdEnfermedad = ?";
            PreparedStatement ns = this.getCn().prepareStatement(sql);
            ns.setInt(1, en.getIdEnfermedad());
            nr = ns.executeQuery();
            
            while (nr.next()){
                ne = new Enfermedad();
                ne.setIdEnfermedad(nr.getInt("IdEnfermedad"));
                ne.setNombre(nr.getString("Nombre"));
                ne.setIdCategoriaEnfermedad(nr.getInt("CategoriaEnfermedad_IdCategoriaE"));
            }
        } catch (SQLException e) {
            System.out.println("ERROR EnfermedadDAO leerID: "+e);
        } finally {
            this.Cerrar();
        } return ne;
    }
    
    public void modificar(Enfermedad en) throws SQLException {
        try {
            this.Conectar();
            String sql = "UPDATE enfermedad SET Nombre=?, CategoriaEnfermedad_IdCategoriaE=? WHERE IdEnfermedad=?";
            PreparedStatement ns = this.getCn().prepareStatement(sql);
            ns.setString(1, en.getNombre());
            ns.setInt(2, en.getIdCategoriaEnfermedad());
            ns.setInt(3, en.getIdEnfermedad());
            ns.executeUpdate(); 
        } catch (SQLException e) {
            System.out.println("Error Enfermedad modificar: "+e);
        } finally {
            this.Cerrar();
        }
    }
    
    public void eliminar (Enfermedad el) throws SQLException{
        try {
            this.Conectar();
            String sql = "DELETE FROM enfermedad WHERE idEnfermedad = ?";
            PreparedStatement ns = this.getCn().prepareStatement(sql);
            ns.setInt(1, el.getIdEnfermedad());
            ns.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error EnfermedadDao eliminar: "+e);
        } finally {
            this.Cerrar();
        }
    }
}
