/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ClinicaMedica.DAO;

import com.ClinicaMedica.Modelo.RevisionGeneral;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author javam
 */
public class RevisionGeneralDao extends DAO{
     public void insertar(RevisionGeneral ne) throws SQLException{
        try {
            this.Conectar();
            String sql = "INSERT INTO revisiongeneral VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ns = this.getCn().prepareStatement(sql);
            ns.setInt(1, ne.getIdExamenGeneral());
            ns.setString(2, ne.getPresion());
             ns.setString(3, ne.getTemperatura());
              ns.setString(4, ne.getPeso());
               ns.setString(5, ne.getEstatura());
                ns.setString(6, ne.getTalla());
            ns.setInt(7, ne.getCita_IdCitaa());
            ns.executeUpdate();            
        } catch (SQLException e) {
            System.out.println("Error RevisionGeneralDao insertar: "+e);
        } finally {
            this.Cerrar();
        }
    }
      
    public List<RevisionGeneral> listar() throws SQLException {
        List<RevisionGeneral> lista = null;
        ResultSet rs;

        try {
            this.Conectar();
            String sql = "SELECT * FROM revisiongeneral";
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                RevisionGeneral revi = new RevisionGeneral();
               revi.setIdExamenGeneral(rs.getInt("IdExamenGeneral"));
                revi.setPresion(rs.getString("Presion"));
                 revi.setTemperatura(rs.getString("Temperatura"));
                  revi.setPeso(rs.getString("Peso"));
                   revi.setEstatura(rs.getString("Estatura"));
                    revi.setTalla(rs.getString("Talla"));
                revi.setCita_IdCitaa(rs.getInt("Cita_IdCitaa"));
                lista.add(revi);
            }
        } catch (SQLException e) {
            System.out.println("Error al desplegar informacion en RevisionGeneralDao Listar" + e);
        } finally {
            this.Cerrar();
        }
        return lista;
    }
      public RevisionGeneral leerID(RevisionGeneral ree) throws SQLException{
        RevisionGeneral eer = null;
        ResultSet nr;
        
        try {
            this.Conectar();
            String sql = "SELECT * FROM revisiongeneral WHERE IdExamenGeneral = ?";
            PreparedStatement ns = this.getCn().prepareStatement(sql);
            ns.setInt(1, ree.getIdExamenGeneral());
            nr = ns.executeQuery();
            
            while (nr.next()){
                eer = new RevisionGeneral();
                eer.setIdExamenGeneral(nr.getInt("IdExamenGeneral"));
                eer.setPresion(nr.getString("Presion"));
                eer.setTemperatura(nr.getString("Temperatura"));
                eer.setPeso(nr.getString("Peso"));
                eer.setEstatura(nr.getString("Estatura"));
                eer.setTalla(nr.getString("Talla"));
                eer.setCita_IdCitaa(nr.getInt("Cita_IdCitaa"));
            }
        } catch (SQLException e) {
            System.out.println("ERROR RevisionGeneralDao leerID: "+e);
        } finally {
            this.Cerrar();
        } return eer;
    }
    
    public void modificar(RevisionGeneral rev) throws SQLException {
        try {
            this.Conectar();
            String sql = "UPDATE revisiongeneral SET Presion=?, Temperatura=?, Peso=?, Estatura=?, Talla=?, Cita_IdCitaa=? WHERE IdExamenGeneral=?";
            PreparedStatement ns = this.getCn().prepareStatement(sql);
            ns.setString(1, rev.getPresion());
            ns.setString(2, rev.getTemperatura());
            ns.setString(3, rev.getPeso());
            ns.setString(4, rev.getEstatura());
            ns.setString(5, rev.getTalla());
            ns.setInt(6, rev.getCita_IdCitaa());
            ns.setInt(7, rev.getIdExamenGeneral());
            ns.executeUpdate(); 
        } catch (SQLException e) {
            System.out.println("Error RevisionGeneral modificar: "+e);
        } finally {
            this.Cerrar();
        }
    }
    
    public void eliminar (RevisionGeneral rg) throws SQLException{
        try {
            this.Conectar();
            String sql = "DELETE FROM revisiongeneral WHERE IdExamenGeneral = ?";
            PreparedStatement ns = this.getCn().prepareStatement(sql);
            ns.setInt(1, rg.getIdExamenGeneral());
            ns.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error RevisionGeneralDao eliminar: "+e);
        } finally {
            this.Cerrar();
        }
    }
}
