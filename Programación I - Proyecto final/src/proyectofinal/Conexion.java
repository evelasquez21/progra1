/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import proyectofinal.admin.modelo.UsuarioTabla;


/**
 *
 * @author eduar
 */
public class Conexion {
    private Connection connection = null;
    private ResultSet rs = null;
    private Statement s = null;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public Statement getS() {
        return s;
    }

    public void setS(Statement s) {
        this.s = s;
    }
    
    
    
    public void iniciarConexion(){
        if (connection != null){
            return;
        }
        
        String url = "jdbc:postgresql://ep-tiny-cloud-a4vxtune-pooler.us-east-1.aws.neon.tech/sistemaTickets?user=neondb_owner&password=npg_afHzK8XIx9oZ&sslmode=require";
        try {
            Class.forName("org.postgresql.Driver");
            
            connection = DriverManager.getConnection(url);
            
            if (connection != null){
                System.out.println("Conectando a la base de datos");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void insertarUsuarios(String nombreCompleto, String correoElectronico, String nombreUsuario, String password, String idRol){
        
        
        try {
            iniciarConexion();
            s = connection.createStatement();
            int z = s.executeUpdate("INSERT INTO \"Usuarios\"(\"nombreCompleto\", nombreusuario, passowrd, idrol, \"correoElectronico\") VALUES ('" + nombreCompleto + "', '" + nombreUsuario + "', '" + password + "', " + idRol + ", '" + correoElectronico + "')");
            if (z == 1) {
                System.out.println("Se agregó el registro");
            } else {
                System.out.println("No se pudo registrar");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void asignarCombobox(String tabla, ComboBox cbo){
        try {
            iniciarConexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT * FROM \"" + tabla + "\"");
            
            // Crear dinamismo en las columnas - datos
            ObservableList<String> list = FXCollections.observableArrayList();
            while (rs.next()) {                
                list.add(rs.getString(1));
            }
            cbo.setItems(list);
            
           
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void consultarUsuarios(TableView<UsuarioTabla> tableView){
        ObservableList<UsuarioTabla> data = FXCollections.observableArrayList();
        try {
            iniciarConexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT u.idusuario, u.\"nombreCompleto\", u.nombreusuario, u.\"correoElectronico\", r.nombrerol FROM \"Usuarios\" u JOIN \"Roles\" r ON u.idrol = r.idrol;");
            
            
            while (rs.next()) {                
                UsuarioTabla usuario = new UsuarioTabla(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                data.add(usuario);
            }
            tableView.setItems(data);
           
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
