package org.estuardogomez.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import org.estuardogomez.system.Principal;

public class RegisterController implements Initializable {
    private Principal escenarioPrincipal;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public Principal getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }
    
    public void login(){
        escenarioPrincipal.menuLogin();
    }
}
