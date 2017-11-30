package com.ClinicaMedica.DAO;

import com.ClinicaMedica.Modelo.Puesto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class puestoDao extends DAO{
    String sql;
    PreparedStatement st;
    
    
    // -------------------------------PUESTO------------------------------------------------------
    public void registrarPuesto(Puesto doc) throws Exception {
        try {
            this.Conectar();
            sql = "insert into puesto(idPuesto, nombre) value(?,?)";
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, doc.getIdPuesto());
            st.setString(2, doc.getNombre());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Errooooooor" + e);
        } finally {
            this.Cerrar();
        }
    }
    
    
    
    
    public List<Puesto> listar() throws Exception {
        List<Puesto> lista = new ArrayList();
        ResultSet rs;
        int i = -1;
        try {
            System.out.println("***********************daolistar Puesto **********************************");
            this.Conectar();
            sql = "SELECT * FROM puesto";
            st = this.getCn().prepareStatement(sql);

            rs = st.executeQuery();

            while (rs.next()) {
                i++;
                Puesto mar = new Puesto();
                mar.setIdPuesto(rs.getInt("idPuesto"));
                mar.setNombre(rs.getString("nombre"));
                lista.add(mar);
                //System.out.println(lista.get(i).getCodigo());
            }

        } catch (Exception e) {
            System.out.println("**************************error Puesto dao******************************" + e);
        } finally {
            this.Cerrar();
        }
        return lista;
    }
    
    
    public void modificarPuesto(Puesto mar) throws SQLException {
        try {
            this.Conectar();
            System.out.println("hola Puesto ***********************************");
            sql = "UPDATE puesto SET nombre=? WHERE idPuesto = ?";
            st = this.getCn().prepareStatement(sql);
            st.setString(1, mar.getNombre());
            st.setInt(2, mar.getIdPuesto());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("**********************error Puesto **************************" + e);
        } finally {
            this.Cerrar();
        }
    }
    
    
    public void eliminarPuesto(Puesto mar) throws SQLException {

        try {
            this.Conectar();
            sql = ("DELETE FROM puesto WHERE idPuesto = ?;");
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, mar.getIdPuesto());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Don pelos" + e);
        } finally {
            this.Cerrar();
        }
    } 
    
}
