package org.estuardogomez.system;

import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.estuardogomez.controller.LoginController;
import org.estuardogomez.controller.RegisterController;


/**
 * JavaFX Principal
 * mi clase principal extiende de application para utilizar todos los componentes
 * Application proporciona toda la infraestructura para poder manejar una aplicacion de JavaFX
 * las clases abstractas tienen que implementar su método abstracto
 */
public class Principal extends Application {
    //cuando establezco una constante, le agrego 'final' y seguir la estandarizacion MAYUS_MAYUS = valorNoCambia
    private final String PAQUETE_VISTA = "/org/estuardogomez/view/";
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
        //Parent root = FXMLLoader.load(getClass().getResource("/org/estuardogomez/view/LoginView.fxml")); //escena la que cambia y se setea en el escenario principal
        //cuando cree la escena con el constructor se pasa de parametro quien va hacer la escena (nuestro archivo fxml)
       // Scene escena = new Scene(root);
        
        menuLogin();
        escenarioPrincipal.setTitle("Taller Mecánico");
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();                         
    }
    
    public void menuLogin(){
        //establecer errores try
        try{
            LoginController menu = (LoginController)cambiarEscena("LoginView.fxml", 792, 513);
            menu.setEscenarioPrincipal(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void ventanaRegister(){
        try{
            //voy a crear una variable que va a almacenar un controlador de tipo registerController y este va a recibir 3 parametros
            //se hace el cast ya que sabemos que su controlador es de tipo RegisterController y se necesitan metodos exclusivos de él
            RegisterController ventanaRegister = (RegisterController)cambiarEscena("RegisterView.fxml", 792, 513);
            ventanaRegister.setEscenarioPrincipal(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //método que establece que parametros son necesarios para funcionar y cambiar Escena
    // analogia hace 'clicks' para buscar el archivo indicado y mostrarlo
    // 3 parametros fxml - nombre y extension
    public Initializable cambiarEscena(String fxml, int ancho, int alto) throws IOException{
        Initializable resultado = null;
        FXMLLoader cargadorFXML = new FXMLLoader();
        InputStream archivo = Principal.class.getResourceAsStream(PAQUETE_VISTA+fxml);  //buscar archivo fisicamente en la maquina
        cargadorFXML.setBuilderFactory(new JavaFXBuilderFactory());
        cargadorFXML.setLocation(Principal.class.getResource(PAQUETE_VISTA+fxml));//funcionalidad del parent
        
        //cuando se crea la esccena necesito ese archivo para visualziar
        escena = new Scene((AnchorPane)cargadorFXML.load(archivo), ancho, alto);
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.sizeToScene();//se adapte al tamaño de la escena
        escenarioPrincipal.setResizable(false);
        resultado = (Initializable)cargadorFXML.getController();
        
        return resultado;//retornar elemento de tipo initializable
    }

}