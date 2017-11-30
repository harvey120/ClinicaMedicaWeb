package Mantenimiento;

import com.ClinicaMedica.DAO.DAO;
import com.ClinicaMedica.Modelo.Enfermedad;
import com.ClinicaMedica.Modelo.Examen;
import com.ClinicaMedica.Modelo.Medicamento;
import com.ClinicaMedica.Modelo.Ocupacion;
import com.ClinicaMedica.Modelo.Religion;
import com.ClinicaMedica.Modelo.Turno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class dao_matenimiento extends DAO {

    private PreparedStatement pre;
    String sql;
    ResultSet rs;

    /*-----------------------------------------insertar---------------------------------------------*/
    public void insertarMedicamento() throws SQLException {
        try {
            this.Conectar();
            sql = "INSERT INTO medicamento(idMedicamento, Nombre, Descripcion, FechaVencimiento, Proveedor_idProveedor, Inventario_idInventario)"
                    + " VALUES (?,?,?,?,?,?)";
            this.pre = this.getCn().prepareStatement(sql);
            Medicamento med = new Medicamento();
            pre.setInt(1, med.getIdmedicamento());
            pre.setString(2, med.getNombre());
            pre.setString(3, med.getDescripcion());
            pre.setString(4, med.getFecha());
            pre.setInt(5, med.getProvedor());
            
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("no inserta medicamento: " + ex);
        } finally {
            this.Cerrar();
        }
    }

    public void insertarOcupacion() throws SQLException {
        try {
            this.Conectar();
            sql = "INSERT INTO ocupacion (IdOcupacion, Nombre) VALUES (?,?)";
            this.pre = this.getCn().prepareStatement(sql);
            Ocupacion ocu = new Ocupacion();
            pre.setInt(1, ocu.getIdOcupacion());
            pre.setString(2, ocu.getNombre());
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("no inserta ocupacion: " + ex);
        } finally {
            this.Cerrar();
        }
    }

    public void insertarEnfermedad() throws SQLException {
        try {
            this.Conectar();
            sql = "INSERT INTO enfermedad(IdEnfermedad, Nombre, CategoriaEnfermedad_IdCategoriaE) VALUES (?,?,?)";
            this.pre = this.getCn().prepareStatement(sql);
            Enfermedad enf = new Enfermedad();
            pre.setInt(1, enf.getIdEnfermedad());
            pre.setInt(2, enf.getIdCategoriaEnfermedad());
            pre.setString(3, enf.getNombre());
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("no inserta enfermedad: " + ex);
        } finally {
            this.Cerrar();
        }
    }

    public void insertarReligion() throws SQLException {
        try {
            this.Conectar();
            sql = "INSERT INTO religion(IdReligion, Nombre) VALUES (?,?)";
            this.pre = this.getCn().prepareStatement(sql);
            Religion reli = new Religion();
            pre.setInt(1, reli.getIdReligion());
            pre.setString(2, reli.getNombre());
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("no inserta Religion: " + ex);
        } finally {
            this.Cerrar();
        }
    }

    public void insertarExamen() throws SQLException {
        try {
            this.Conectar();
            sql = "INSERT INTO `examen`(`IdExamen`, `Nombre`, `idCategoriaExamen`) VALUES (?,?,?))";
            this.pre = this.getCn().prepareStatement(sql);
            Examen ex = new Examen();
            pre.setInt(1, ex.getIdExamen());
            pre.setString(2, ex.getNombre());
            pre.setInt(3, ex.getIdCategoriaExamen());
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("no inserta Examen: " + ex);
        } finally {
            this.Cerrar();
        }
    }

    public void insertarTurno() throws SQLException {
        try {
            this.Conectar();
            sql = "INSERT INTO turno(idTurno, HorarioEntrada, HorarioSalida) VALUES (?,?,?)";
            this.pre = this.getCn().prepareStatement(sql);
            Turno tur = new Turno();
            pre.setInt(1, tur.getIdturno());
            pre.setString(2, tur.getHorarioEntrada());
            pre.setString(3, tur.getHorarioSalida());
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("no inserta turno: " + ex);
        } finally {
            this.Cerrar();
        }
    }

    /*-----------------------------------------insertar---------------------------------------------*/

 /*-----------------------------------------Listar---------------------------------------------*/
    public ArrayList<Medicamento> listarMedicamento() throws SQLException {
        
        List<Medicamento> me = new ArrayList();
        Medicamento men = new Medicamento();
        try {
            this.Conectar();
            sql = "SELECT * FROM medicamento";
            this.pre = this.getCn().prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                men.setNombre(rs.getString("Nombre"));
                men.setDescripcion(rs.getString("Descripcion"));
                men.setFecha(rs.getString("FechaVencimiento"));
                men.setProvedor(rs.getInt("Proveedor_idProveedor"));
               
                men.setIdmedicamento(rs.getInt("idMedicamento"));
                me.add(men);
            }
        } catch (SQLException ex) {
            System.out.println("no inserta ocupacion: " + ex);
        } finally {
            this.Cerrar();
        }
        return (ArrayList<Medicamento>) me;
    }

    public ArrayList<Ocupacion> listarOcupacion() throws SQLException {
        List<Ocupacion> oc = new ArrayList();
        Ocupacion ocu = new Ocupacion();
        try {
            this.Conectar();
            sql = "SELECT * FROM ocupacion";
            this.pre = this.getCn().prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {                
                ocu.setIdOcupacion(rs.getInt("IdOcupacion"));
                ocu.setNombre(rs.getString("Nombre"));
                oc.add(ocu);
            }
        } catch (SQLException ex) {
            System.out.println("no inserta ocupacion: " + ex);
        } finally {
            this.Cerrar();
        }
        return (ArrayList<Ocupacion>) oc;
    }

    public ArrayList<Enfermedad> listarEnfermedad() throws SQLException {
        List<Enfermedad> en = new ArrayList();
        Enfermedad enf = new Enfermedad();
        try {
            this.Conectar();
            sql = "SELECT * FROM enfermedad";
            this.pre = this.getCn().prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {                
                enf.setIdEnfermedad(rs.getInt("IdEnfermedad"));
                enf.setNombre(rs.getString("Nombre"));
                enf.setIdCategoriaEnfermedad(rs.getInt("CategoriaEnfermedad_IdCategoriaE"));
                en.add(enf);
            }
        } catch (SQLException ex) {
            System.out.println("no inserta enfermedad: " + ex);
        } finally {
            this.Cerrar();
        }
        return (ArrayList<Enfermedad>) en;
    }

    public ArrayList<Religion> listarReligion() throws SQLException {
        List<Religion> re= new ArrayList();
        Religion reli = new Religion();
        try {
            this.Conectar();
            sql = "SELECT * FROM religion";
            this.pre = this.getCn().prepareStatement(sql); 
            rs=pre.executeQuery();
            while (rs.next()) {                
                reli.setIdReligion(rs.getInt("IdReligion"));
                reli.setNombre(rs.getString("Nombre"));
                re.add(reli);
            }
        } catch (SQLException ex) {
            System.out.println("no inserta Religion: " + ex);
        } finally {
            this.Cerrar();
        }return (ArrayList<Religion>) re;
    }

    public ArrayList<Examen> listarExamen() throws SQLException {
        List<Examen> exam= new ArrayList();
        Examen exe = new Examen();
        try {
            this.Conectar();
            sql = "SELECT * FROM examen";
            this.pre = this.getCn().prepareStatement(sql);    
            rs=pre.executeQuery();
            while (rs.next()) {                
                exe.setIdCategoriaExamen(rs.getInt("idCategoriaExamen"));
                exe.setIdExamen(rs.getInt("IdExamen"));
                exe.setNombre(rs.getString("Nombre"));
            }
        } catch (SQLException ex) {
            System.out.println("no inserta Examen: " + ex);
        } finally {
            this.Cerrar();
        }return (ArrayList<Examen>) exam;            
    }

    public ArrayList<Turno> listarTurno() throws SQLException {
        List<Turno> t = new ArrayList();
        Turno tur = new Turno();
        try {
            this.Conectar();
            sql = "SELECT * FROM turno";
            this.pre = this.getCn().prepareStatement(sql); 
            rs = pre.executeQuery();
            while (rs.next()) {                
                tur.setIdturno(rs.getInt("idTurno"));
                tur.setHorarioEntrada(rs.getString("HorarioEntrada"));
                tur.setHorarioSalida(rs.getString("HorarioSalida"));
            }
        } catch (SQLException ex) {
            System.out.println("no inserta ocupacion: " + ex);
        } finally {
            this.Cerrar();
        }
        return (ArrayList<Turno>) t;
    }
 /*-----------------------------------------Listar---------------------------------------------*/
 
    
    /*-----------------------------------------Modificar---------------------------------------------*/
    public void modificarMedicamento() throws SQLException {
        try {
            this.Conectar();
            sql = "UPDATE medicamento SET  Nombre=?, Descripcion=?,FechaVencimiento=?,"
                    + "Proveedor_idProveedor=?,Inventario_idInventario=? WHERE idMedicamento=?";
            this.pre = this.getCn().prepareStatement(sql);
            Medicamento med = new Medicamento();
            pre.setString(1, med.getNombre());
            pre.setString(2, med.getDescripcion());
            pre.setString(3, med.getFecha());
            pre.setInt(4, med.getProvedor());
            
            pre.setInt(6, med.getIdmedicamento());
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("no modifico medicamento: " + ex);
        } finally {
            this.Cerrar();
        }
    }

    public void modificarOcupacion() throws SQLException {
        try {
            this.Conectar();
            sql = "UPDATE ocupacion SET Nombre=? WHERE IdOcupacion=?";
            this.pre = this.getCn().prepareStatement(sql);
            Ocupacion ocu = new Ocupacion();
            pre.setString(1, ocu.getNombre());
            pre.setInt(2, ocu.getIdOcupacion());
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("no inserta ocupacion: " + ex);
        } finally {
            this.Cerrar();
        }
    }

    public void modificarEnfermedad() throws SQLException {
        try {
            this.Conectar();
            sql = "UPDATE enfermedad SET Nombre=?,CategoriaEnfermedad_IdCategoriaE=? WHERE IdEnfermedad=?";
            this.pre = this.getCn().prepareStatement(sql);
            Enfermedad enf = new Enfermedad();
            pre.setInt(1, enf.getIdCategoriaEnfermedad());
            pre.setString(2, enf.getNombre());
            pre.setInt(3, enf.getIdEnfermedad());
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("no inserta enfermedad: " + ex);
        } finally {
            this.Cerrar();
        }
    }

    public void modificarReligion() throws SQLException {
        try {
            this.Conectar();
            sql = "UPDATE religion SET Nombre = ? WHERE IdReligion = ? ";
            this.pre = this.getCn().prepareStatement(sql);
            Religion reli = new Religion();
            pre.setString(1, reli.getNombre());
            pre.setInt(2, reli.getIdReligion());
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("no inserta Religion: " + ex);
        } finally {
            this.Cerrar();
        }
    }

    public void modificarExamen() throws SQLException {
        try {
            this.Conectar();
            sql = "UPDATE examen SET Nombre=?,idCategoriaExamen=? WHERE IdExamen=?";
            this.pre = this.getCn().prepareStatement(sql);
            Examen ex = new Examen();
            pre.setString(1, ex.getNombre());
            pre.setInt(2, ex.getIdCategoriaExamen());
            pre.setInt(3, ex.getIdExamen());
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("no inserta Examen: " + ex);
        } finally {
            this.Cerrar();
        }
    }

    public void modificarTurno() throws SQLException {
        try {
            this.Conectar();
            sql = "UPDATE turno SET HorarioEntrada=?, HorarioSalida=? WHERE idTurno=?";
            this.pre = this.getCn().prepareStatement(sql);
            Turno tur = new Turno();
            pre.setString(1, tur.getHorarioEntrada());
            pre.setString(2, tur.getHorarioSalida());
            pre.setInt(3, tur.getIdturno());
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("no inserta ocupacion: " + ex);
        } finally {
            this.Cerrar();
        }
    }

    /*-----------------------------------------Modificar---------------------------------------------*/

 /*-----------------------------------------Buscar---------------------------------------------*/
    public Medicamento buscarMedicamento(Medicamento m) throws SQLException {

        Medicamento men = new Medicamento();
        try {
            this.Conectar();
            sql = "SELECT * FROM medicamento WHERE idMedicamento=?";
            this.pre = this.getCn().prepareStatement(sql);
            pre.setInt(1, m.getIdmedicamento());
            rs = pre.executeQuery();
            while (rs.next()) {
                men.setNombre(rs.getString("Nombre"));
                men.setDescripcion(rs.getString("Descripcion"));
                men.setFecha(rs.getString("FechaVencimiento"));
                men.setProvedor(rs.getInt("Proveedor_idProveedor"));
                
                men.setIdmedicamento(rs.getInt("idMedicamento"));
            }
        } catch (SQLException ex) {
            System.out.println("no inserta ocupacion: " + ex);
        } finally {
            this.Cerrar();
        }
        return men;
    }

    public Ocupacion buscarOcupacion(Ocupacion o) throws SQLException {
        Ocupacion ocu = new Ocupacion();
        try {
            this.Conectar();
            sql = "SELECT * FROM ocupacion WHERE IdOcupacion=?";
            this.pre = this.getCn().prepareStatement(sql);
            pre.setInt(1, o.getIdOcupacion());
            rs = pre.executeQuery();
            while (rs.next()) {                
                ocu.setIdOcupacion(rs.getInt("IdOcupacion"));
                ocu.setNombre(rs.getString("Nombre"));
            }
        } catch (SQLException ex) {
            System.out.println("no inserta ocupacion: " + ex);
        } finally {
            this.Cerrar();
        }
        return ocu;
    }

    public Enfermedad buscarEnfermedad(Enfermedad e) throws SQLException {
        Enfermedad enf = new Enfermedad();
        try {
            this.Conectar();
            sql = "SELECT * FROM enfermedad WHERE IdEnfermedad=?";
            this.pre = this.getCn().prepareStatement(sql);
            pre.setInt(1, e.getIdEnfermedad());
            rs = pre.executeQuery();
            while (rs.next()) {                
                enf.setIdEnfermedad(rs.getInt("IdEnfermedad"));
                enf.setNombre(rs.getString("Nombre"));
                enf.setIdCategoriaEnfermedad(rs.getInt("CategoriaEnfermedad_IdCategoriaE"));
            }
        } catch (SQLException ex) {
            System.out.println("no inserta enfermedad: " + ex);
        } finally {
            this.Cerrar();
        }
        return enf;
    }

    public Religion buscarReligion(Religion r) throws SQLException {
        Religion reli = new Religion();
        try {
            this.Conectar();
            sql = "SELECT * FROM religion WHERE IdReligion=?";
            this.pre = this.getCn().prepareStatement(sql); 
            pre.setInt(1, r.getIdReligion());
            rs=pre.executeQuery();
            while (rs.next()) {                
                reli.setIdReligion(rs.getInt("IdReligion"));
                reli.setNombre(rs.getString("Nombre"));
            }
        } catch (SQLException ex) {
            System.out.println("no inserta Religion: " + ex);
        } finally {
            this.Cerrar();
        }return reli;
    }

    public Examen buscarExamen(Examen e) throws SQLException {
        Examen exe = new Examen();
        try {
            this.Conectar();
            sql = "SELECT * FROM examen WHERE IdExamen=?";
            this.pre = this.getCn().prepareStatement(sql);    
            pre.setInt(1, e.getIdExamen());
            rs=pre.executeQuery();
            while (rs.next()) {                
                exe.setIdCategoriaExamen(rs.getInt("idCategoriaExamen"));
                exe.setIdExamen(rs.getInt("IdExamen"));
                exe.setNombre(rs.getString("Nombre"));
            }
        } catch (SQLException ex) {
            System.out.println("no inserta Examen: " + ex);
        } finally {
            this.Cerrar();
        }return exe;            
    }

    public Turno buscarTurno(Turno t) throws SQLException {
        Turno tur = new Turno();
        try {
            this.Conectar();
            sql = "SELECT * FROM turno WHERE idTurno=?";
            this.pre = this.getCn().prepareStatement(sql); 
            pre.setInt(1, t.getIdturno());
            rs = pre.executeQuery();
            while (rs.next()) {                
                tur.setIdturno(rs.getInt("idTurno"));
                tur.setHorarioEntrada(rs.getString("HorarioEntrada"));
                tur.setHorarioSalida(rs.getString("HorarioSalida"));
            }
        } catch (SQLException ex) {
            System.out.println("no inserta ocupacion: " + ex);
        } finally {
            this.Cerrar();
        }
        return tur;
    }
    /*-----------------------------------------Buscar---------------------------------------------*/

    
}
