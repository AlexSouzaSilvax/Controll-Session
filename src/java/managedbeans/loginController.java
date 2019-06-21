/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.LoginEntity;

/**
 *
 * @author alex.silva
 */
@ManagedBean(name = "loginController")
@SessionScoped
public class loginController implements Serializable {

    private LoginEntity login;

    public loginController() {
        login = new LoginEntity();
    }

    public String logarNoSistema() {
        if (login.getLogin().equals("alex") && login.getSenha().equals("123")) {
            
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            session.setAttribute("usuario", login);
            
            System.out.println("usuário válido...");
            return "/app/index?faces-redirect=true";
        } else {
            System.out.println("usuário inválido...");
            return "/seguranca/login?faces-redirect=true";
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        System.out.println("saiu do sistema...");
        return "/seguranca/login?faces-redirect=true";
    }
    
    public String home() {     
        return "/app/index?faces-redirect=true";
    }
    
    public String teste() {     
        return "/app/teste?faces-redirect=true";
    }

    public LoginEntity getLogin() {
        return login;
    }

    public void setLogin(LoginEntity login) {
        this.login = login;
    }

}
