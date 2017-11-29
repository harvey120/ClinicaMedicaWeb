package com.ClinicaMedica.DAO;

import com.ClinicaMedica.Modelo.Turno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class TurnoDAO extends DAO {
    String sql;
    PreparedStatement st;
    
    
    public void registrar(Turno doc) throws Exception{
        try{
            
            this.Conectar();
            sql = "insert into turno(IdTurno, HorarioEntrada, HorarioSalida) value(?,?,?)";
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, doc.getIdturno());
            st.setString(2, doc.getHorarioEntrada());
            st.setString(3, doc.getHorarioSalida());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error TurnoDao registrar: " +e);
        }finally{
            this.Cerrar();
        }
    }
    
    
    
    public List<Turno> listar() throws Exception{
        List<Turno> lista=new ArrayList();
        ResultSet rs;
        try{
            this.Conectar();
            sql = "SELECT * FROM turno";
            st = this.getCn().prepareStatement(sql);
           
            rs = st.executeQuery();
          
            while(rs.next()){               
                Turno mar = new Turno();
                mar.setIdturno(rs.getInt("idTurno"));
                mar.setHorarioEntrada(rs.getString("HorarioEntrada"));
                mar.setHorarioSalida(rs.getString("HorarioSalida"));
                lista.add(mar);
            }
            
        }catch(SQLException e){
            System.out.println("Error Pacienete dao: "+e);
        }finally{
            this.Cerrar();
            
        }
        return lista;
    }
    
    public Turno leerID(Turno Tid) throws SQLException{
        Turno nt = null;
        ResultSet nr;
        
        try {
            this.Conectar();
            sql = "SELECT * FROM turno WHERE idTurno = ?";
            PreparedStatement ns = this.getCn().prepareStatement(sql);
            ns.setInt(1, Tid.getIdturno());
            
            nr = ns.executeQuery();
            
            while (nr.next()){
                nt = new Turno();
                nt.setIdturno(nr.getInt("idTurno"));
                nt.setHorarioEntrada(nr.getString("HorarioEntrada"));
                nt.setHorarioSalida(nr.getString("HorarioSalida"));
            }
        } catch (SQLException e) {
            System.out.println("ERROR TurnoDAO leerID: "+e);
        } finally {
            this.Cerrar();
        } return nt;
    }
    
    
     public void modificar(Turno t) throws SQLException{
        try{
            this.Conectar();
            sql="UPDATE turno SET HorarioEntrada=?, HorarioSalida=? WHERE idTurno = ?";
            st = this.getCn().prepareStatement(sql);
            st.setString(1, t.getHorarioEntrada());
            st.setString(2, t.getHorarioSalida());
            st.setInt(3, t.getIdturno());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error TurnoDao modificar: " +e);
        }finally{
            this.Cerrar();
        }
    }
    
    
    
      public void eliminar(Turno tur) throws SQLException{
        try{
            this.Conectar();
            sql = ("DELETE FROM turno WHERE idTurno=?;");
            st = this.getCn().prepareStatement(sql);
            st.setInt(1, tur.getIdturno());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error TurnoDao eliminar:" +e);
        }finally{
            this.Cerrar();
        }
    }
}