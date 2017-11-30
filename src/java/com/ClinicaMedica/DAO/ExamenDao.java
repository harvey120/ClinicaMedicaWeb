/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicaMedica.DAO;

import com.ClinicaMedica.Modelo.Examen;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javam
 */
public class ExamenDao extends DAO {
     public void insertar(Examen ex) throws SQLException{
        try {
            this.Conectar();
            String sql = "INSERT INTO examen VALUES (?,?,?)";
            PreparedStatement ns = this.getCn().prepareStatement(sql);
            ns.setInt(1, ex.getIdExamen());
            ns.setString(2, ex.getNombre());
            ns.setInt(3, ex.getIdCategoriaExamen());
            ns.executeUpdate();            
        } catch (SQLException e) {
            System.out.println("Error ExamenDao insertar: "+e);
        } finally {
            this.Cerrar();
        }
    }
      
    public List<Examen> listar() throws SQLException {
        List<Examen> lista = null;
        ResultSet rs;

        try {
            this.Conectar();
            String sql = "SELECT * FROM examen";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Examen exa = new Examen();
                exa.setIdExamen(rs.getInt("IdExamen"));
                exa.setNombre(rs.getString("Nombre"));
                exa.setIdCategoriaExamen(rs.getInt("idCategoriaExamen"));
                lista.add(exa);
            }
        } catch (SQLException e) {
            System.out.println("Error al desplegar informacion en ExamenDao Listar" + e);
        } finally {
            this.Cerrar();
        }
        return lista;
    }
      public Examen leerID(Examen exx) throws SQLException{
        Examen exaa = null;
        ResultSet nr;
        
        try {
            this.Conectar();
            String sql = "SELECT * FROM examen WHERE IdExamen = ?";
            PreparedStatement ns = this.getCn().prepareStatement(sql);
            ns.setInt(1, exx.getIdExamen());
            nr = ns.executeQuery();
            
            while (nr.next()){
                exaa = new Examen();
                exaa.setIdExamen(nr.getInt("IdExamen"));
                exaa.setNombre(nr.getString("Nombre"));
                exaa.setIdCategoriaExamen(nr.getInt("IdCategoriaExamen"));
            }
        } catch (SQLException e) {
            System.out.println("ERROR ExamenDao leerID: "+e);
        } finally {
            this.Cerrar();
        } return exaa;
    }
    
    public void modificar(Examen exam) throws SQLException {
        try {
            this.Conectar();
            String sql = "UPDATE examen SET Nombre=?, idCategoriaExamen=? WHERE IdExamen=?";
            PreparedStatement ns = this.getCn().prepareStatement(sql);
            ns.setString(1, exam.getNombre());
            ns.setInt(2, exam.getIdCategoriaExamen());
            ns.setInt(3, exam.getIdExamen());
            ns.executeUpdate(); 
        } catch (SQLException e) {
            System.out.println("Error examen modificar: "+e);
        } finally {
            this.Cerrar();
        }
    }
    
    public void eliminar (Examen eex) throws SQLException{
        try {
            this.Conectar();
            String sql = "DELETE FROM examen WHERE IdExamen = ?";
            PreparedStatement ns = this.getCn().prepareStatement(sql);
            ns.setInt(1, eex.getIdExamen());
            ns.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error ExamenDao eliminar: "+e);
        } finally {
            this.Cerrar();
        }
    }
}
