package com.ClinicaMedica.DAO;

import com.ClinicaMedica.Modelo.ReferenciaClinica;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Harvey
 */
public class ReferenciaClinicaDAO extends DAO {

    private PreparedStatement st;

    public List<ReferenciaClinica> listar() throws SQLException {
        List<ReferenciaClinica> lista = null;
        ResultSet rs;

        try {
            this.Conectar();
            String sql = "SELECT * FROM referenciaclinica";
            st = this.getCn().prepareCall(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                ReferenciaClinica ref = new ReferenciaClinica();
                ref.setIdReferenciaClinica(rs.getInt("IdReferenciaClinica"));
                ref.setNombre(rs.getString("Nombre"));
                lista.add(ref);
            }
        } catch (Exception e) {
            System.out.println("Error al desplegar informacion en ReferenciaClinicaDAO Listar" + e);
        } finally {
            this.Cerrar();
        }
        return lista;
    }
    public void insertar(ReferenciaClinica re) throws SQLException{
        try {
            this.Conectar();
            String sql = "INSERT INTO referenciaclinica VALUES (?,?)";
            PreparedStatement ns = this.getCn().prepareStatement(sql);
            ns.setInt(1, re.getIdReferenciaClinica());
            ns.setString(2, re.getNombre());
            ns.executeUpdate();            
        } catch (SQLException e) {
            System.out.println("Error ReferenciaClinicaDao insertar: "+e);
        } finally {
            this.Cerrar();
        }
    }
     public void modificar(ReferenciaClinica rc) throws SQLException {
        try {
            this.Conectar();
            String sql = "UPDATE referenciaclinica SET Nombre=? WHERE idReferenciaClinica=?";
            PreparedStatement ns = this.getCn().prepareStatement(sql);
            ns.setString(1, rc.getNombre());
            ns.setInt(2, rc.getIdReferenciaClinica());
            ns.executeUpdate(); 
        } catch (SQLException e) {
            System.out.println("Error Enfermedad modificar: "+e);
        } finally {
            this.Cerrar();
        }
    }
     public ReferenciaClinica leerID(ReferenciaClinica en) throws SQLException{
        ReferenciaClinica ne = null;
        ResultSet nr;
        
        try {
            this.Conectar();
            String sql = "SELECT * FROM referenciaclinica WHERE idReferenciaClinica = ?";
            PreparedStatement ns = this.getCn().prepareStatement(sql);
            ns.setInt(1, en.getIdReferenciaClinica());
            nr = ns.executeQuery();
            
            while (nr.next()){
                ne = new ReferenciaClinica();
                ne.setIdReferenciaClinica(nr.getInt("idReferenciaClinica"));
                ne.setNombre(nr.getString("Nombre"));
               
            }
        } catch (SQLException e) {
            System.out.println("ERROR ReferenciaClinicaDAO leerID: "+e);
        } finally {
            this.Cerrar();
        } return ne;
    }
}
