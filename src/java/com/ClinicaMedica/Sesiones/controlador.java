package com.ClinicaMedica.Sesiones;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * @author Harvey
 */
@ManagedBean
@SessionScoped
public class controlador implements Serializable {

    loginModelo usu = new loginModelo();

    public loginModelo getUsu() {
        return usu;
    }

    public void setUsu(loginModelo usu) {
        this.usu = usu;
    }

    public void verificarSesion() {

        try {
            FacesContext context = FacesContext.getCurrentInstance();
            loginModelo usua = (loginModelo) context.getExternalContext().getSessionMap().get("session");
            if (usua == null) {
                context.getExternalContext().redirect("../login.xhtml");
            } else {
                usu = usua;
            }
        } catch (IOException ex) {
            System.out.println("Aqui es el eerror");
        }
    }

    public String verificarDireccion() {
        String a;
        return a = "../Doctor/Calendario";
    }

    public int Validador() {
        int respuesta = 2;

        System.out.println("respuesta: " + usu.getIdPuesto());
        System.out.println("Nombre:" + usu.getNombre());
        
        return respuesta;
    }

}
