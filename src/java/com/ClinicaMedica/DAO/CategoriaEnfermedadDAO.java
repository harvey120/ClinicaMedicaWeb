package com.ClinicaMedica.DAO;

import com.ClinicaMedica.Modelo.CategoriaEnfermedad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author medev
 */
public class CategoriaEnfermedadDAO extends DAO {
    String sql;
    
    public void Insertar (CategoriaEnfermedad nc) throws SQLException{
        try {
            this.Conectar();
            sql = "INSERT INTO categoriaenfermedad(idCategoriaEnfermedad, NombreCategoria) VALUES (?,?);";
            PreparedStatement ns = this.getCn().prepareStatement(sql);
            ns.setInt(1, nc.getIdCategoriaEnfermedad());
            ns.setString(2, nc.getNombreCategoria());
            
            ns.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error CategoriaEnfermedadDao Insertar: "+e);
        } finally {
            this.Cerrar();
        }
    }
    
    public List<CategoriaEnfermedad> listar () throws SQLException{
        List<CategoriaEnfermedad> lista = new ArrayList();
        ResultSet nr;
        
        try {
            this.Conectar();
            sql = "SELECT * FROM categoriaenfermedad";
            PreparedStatement ns = this.getCn().prepareStatement(sql);
            nr = ns.executeQuery();
            
            while (nr.next()){
                CategoriaEnfermedad ne = new CategoriaEnfermedad();
                ne.setIdCategoriaEnfermedad(nr.getInt("idCategoriaEnfermedad"));
                ne.setNombreCategoria(nr.getString("NombreCategoria"));
                lista.add(ne);
            }
        } catch (SQLException e) {
            System.out.println("Error CategoriaEnfermedad listar: "+e);
        } finally {
            this.Cerrar();
        } return lista;
    }
    
    public CategoriaEnfermedad leerID(CategoriaEnfermedad cat) throws SQLException{
        CategoriaEnfermedad nc = null;
        ResultSet nr;
        
        try {
            this.Conectar();
            sql="SELECT * FROM categoriaenfermedad WHERE idCategoriaEnfermedad = ?";
            PreparedStatement ns = this.getCn().prepareStatement(sql);
            ns.setInt(1, cat.getIdCategoriaEnfermedad());
            nr = ns.executeQuery();
            
            while (nr.next()) {
                nc = new CategoriaEnfermedad();
                nc.setIdCategoriaEnfermedad(nr.getInt("idCategoriaEnfermedad"));
                nc.setNombreCategoria(nr.getString("NombreCategoria"));
            }
        } catch (SQLException e) {
            System.out.println("ERROR CategoriaEnfermedadDAO leerID: "+e);
        } finally {
            this.Cerrar();
        } return nc;
    }
    
    public void modificar(CategoriaEnfermedad n) throws SQLException{
        try {
            this.Conectar();
            sql = "UPDATE categoriaenfermedad SET NombreCategoria = ? WHERE idCategoriaEnfermedad = ?";
            PreparedStatement ns = this.getCn().prepareStatement(sql);
            ns.setString(1, n.getNombreCategoria());
            ns.setInt(2, n.getIdCategoriaEnfermedad());
            ns.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error CategoriaEnfermedadDao modificar: "+e);
        } finally {
            this.Cerrar();
        }
    }
    
    public void eliminar(CategoriaEnfermedad el) throws SQLException{
        try {
            this.Conectar();
            sql = "DELETE FROM categoriaenfermedad WHERE idCategoriaEnfermedad =?";
            PreparedStatement ns = this.getCn().prepareStatement(sql);
            ns.setInt(1, el.getIdCategoriaEnfermedad());
            ns.executeUpdate();
        } catch (SQLException i) {
            System.out.println("Error CategoriaEnfermedad eliminar: "+i);
        } finally {
            this.Cerrar();
        }
    }
}
