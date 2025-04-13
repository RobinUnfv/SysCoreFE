/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.activation.DataSource;

/**
 *
 * @author luis_
 */
public class ConnectionPool {
    
    public static Connection conexionOracle() throws SQLException {
       String url = "jdbc:oracle:thin:@localhost:1521:BDNX1";
       String usuario = "LLE";
       String password = "YVL";
       Connection conn = null;
       try{
         conn = DriverManager.getConnection(url, usuario, password);
         if (conn != null){
             System.out.println("Conexión establecido con éxito...");
         }
       } catch(SQLException e) {
         System.out.println("Error al conectar con la base de datos de Oracle ; "+e.getMessage());
         e.printStackTrace();
       }
       return conn;
    }
    
    public static Connection obtenerConexionOracle() throws SQLException {
      return conexionOracle();
    }
    
    public static void closeConexionOracle(Connection cnn) {
       try {
          if(cnn != null) {
             cnn.close();
          }
       } catch(Exception ex) {
            ex.printStackTrace();
       }
    }
    
     public static Connection obtenerConexion(String fuente) throws SQLException {
        DataSource ds=null;
        Connection conexion=null;
        try{
           DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            conexion = DriverManager.getConnection (
                "jdbc:mysql://localhost/factura2023","root", "luis");
            
        }catch(Exception ex){
            throw new SQLException(ex);
        }
        return conexion;
    }
    public static Connection obtenerConexionMysql() throws SQLException{
        return obtenerConexion("jdbc/genxml");
    }
    
    public static void closeConexion(Connection conexion) {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
