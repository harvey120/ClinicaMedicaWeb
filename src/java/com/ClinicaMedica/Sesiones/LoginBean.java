package com.ClinicaMedica.Sesiones;

import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * @author Harvey
 */
@Named
@ViewScoped
public class LoginBean implements Serializable {

    loginModelo usuario = new loginModelo();
    loginModelo UsuarioSesion = new loginModelo();

    public loginModelo getUsuario() {
        return usuario;
    }

    public void setUsuario(loginModelo usuario) {
        this.usuario = usuario;
    }

    public loginModelo getUsuarioSesion() {
        return UsuarioSesion;
    }

    public void setUsuarioSesion(loginModelo UsuarioSesion) {
        this.UsuarioSesion = UsuarioSesion;
    }

    // creo mi metodo para logear una seseion
    public void loga() {
        LoginDAO log = new LoginDAO(); // llamamos el objeto de tipo dao

        try {
            UsuarioSesion = log.iniciarSesion(usuario); //guardamos el objeto dao y le mandamo un temporal que almacene mi modelo de tipo loginModelo

            if (UsuarioSesion != null) { // aqui preguntamos si en el usuario donde vamos a logar no hay nada? entonces

                /**
                 * en esta parte del codigo aqui vamos a validar respecto del
                 * tipo de empleado que se encuentre en nuestra vista de la base
                 * datos asi se va a redireccionar mi objeto a cada pagina
                 * administrativa
                 */
                if (UsuarioSesion.getIdPuesto() == 1 && UsuarioSesion.getIdEstadoUsuario() == 1) {
                    /**
                     * con cuerdo a la base de datos entonces vamos a crear un
                     * objeto de tipo FacesContext al cual vamos a crear nuestro
                     * map de valor al cual queremos crear la sesion y le
                     * mandamos de parametro el objeto de neustra sesion luego
                     * redireccionamos ese valor a la pagina xhtml que deseemos
                     *
                     */
                    FacesContext context = FacesContext.getCurrentInstance();
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("session", UsuarioSesion);
                    context.getExternalContext().redirect("faces/homes/homeAdmin.xhtml");
                } else {

                }

                if (UsuarioSesion.getIdPuesto() == 4 && UsuarioSesion.getIdEstadoUsuario() == 1) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("session", UsuarioSesion);
                    context.getExternalContext().redirect("faces/vistaCruds/Pacientes.xhtml");
                } else {

                }

                // aqui termina la validacion de sesiones 
            }
        } catch (Exception ex) {
            System.out.println("Error en el Login Bean");
        }
    }
}
