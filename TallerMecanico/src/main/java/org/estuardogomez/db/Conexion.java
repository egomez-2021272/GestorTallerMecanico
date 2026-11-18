// clase encargada en mantener el puente de comunicación entre el programa Java y la DB
// patron singleton garantixza que exista solo una instancia al abrir la conexion
// una instancia es un objeto creado a partir de esa clase
package org.estuardogomez.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    //por medio de está variable viajaran tus consultas sql
    private Connection conexion;
    private static Conexion instancia;
    
    private Conexion (){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBGestorTaller2026?useSSL=false", "root", "deve");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch(InstantiationException e){
            e.printStackTrace();
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static Conexion getInstance(){
        if(instancia == null)
            instancia = new Conexion();
        return instancia;
    }
    
    public Connection getConexion(){
        return conexion;
    }
    
    public void setConexion(Connection conexion){
        this.conexion = conexion;
    }
    
}
