package Sesiones;

import com.dao.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Harvey
 */
public class LoginDAO extends DAO {

    public loginModelo iniciarSesion(loginModelo lo) throws Exception {
        String sql;
        ResultSet rs;
        loginModelo login = null;
        try {
            this.Conectar();
            sql = "SELECT * FROM login WHERE Usuario = ? and contrasenia = ?";
            PreparedStatement st = this.getCn().prepareCall(sql);
            st.setString(1, lo.getUsurio());
            st.setString(2, lo.getContrasena());
            rs = st.executeQuery();
            rs.next();
            login = new loginModelo();
            login.setNombre(rs.getString("Nombre"));
            login.setApellido(rs.getString("Apellido"));
            login.setCorreoElectronico(rs.getString("CorreoElectronico"));
            login.setTelefono(rs.getString("Telefono"));
            login.setEstadoEmpleado(rs.getString("Estado"));
            login.setIdPuesto(rs.getInt("Puesto_idPuesto"));
            login.setIdUsuario(rs.getInt("idUsuario"));
            login.setUsurio(rs.getString("Usuario"));
            login.setContrasena(rs.getString("contrasenia"));
            login.setIdEstadoUsuario(rs.getInt("EstadoUsuario_idEstadoUsuario"));

        } catch (Exception e) {
            System.out.println("No se realizo inicio de Session en Seseiones" + e);
        } finally {
            this.Cerrar();
        }
        return login;
    }
}
