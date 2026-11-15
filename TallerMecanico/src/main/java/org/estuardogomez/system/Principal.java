package org.estuardogomez.system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * JavaFX Principal
 * mi clase principal extiende de application para utilizar todos los componentes
 * Application proporciona toda la infraestructura para poder manejar una aplicacion de JavaFX
 * las clases abstractas tienen que implementar su método abstracto
 */
public class Principal extends Application {
    private Stage escenarioPrincipal;
    private Scene escena;

   

    public static void main(String[] args) {
        launch(args);
    }
    
    /*
    * metodo start configurar lo que necesitamos de la ventana
    * escenario principal el fondo en donde vamos a estar cambiando la escena
    * necesito hacer multiherencia cosa que no hace java si no se simula, 
    * porque ya se extendio de application - para eso se implementa una interface (initianizable)
    */
    
    //escenarioPrincipal - parametro de entrada
    //clase parent que me da el tamaño del elemento y levantarlo, necesita saber que elemento visualizar
    //FXMLoader - hacer lectura de un archivo fxml a la parte de java (load - lectura, getClass un recusro)
    @Override
    public void start(Stage escenarioPrincipal) throws Exception {
        this.escenarioPrincipal = escenarioPrincipal;
        Parent root = FXMLLoader.load(getClass().getResource("/org/estuardogomez/view/MenuPrincipalView.fxml")); //escena la que cambia y se setea en el escenario principal
        //cuando cree la escena con el constructor se pasa de parametro quien va hacer la escena (nuestro archivo fxml)
        Scene escena = new Scene(root);
        
        escenarioPrincipal.setTitle("Taller Mecánico");
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
                
                
    }

}