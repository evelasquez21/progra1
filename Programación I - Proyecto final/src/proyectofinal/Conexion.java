/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import proyectofinal.admin.modelo.*;
import java.sql.PreparedStatement;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



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
            
           
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    
    // Modulo de parametros ------------------------->
    
    public void consultarPrioridades(TableView<Prioridades> tableView){
        ObservableList<Prioridades> data = FXCollections.observableArrayList();
        try {
            iniciarConexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT * FROM \"Prioridades\"");
            
            
            while (rs.next()) {                
                Prioridades prioridades = new Prioridades(rs.getString(1), rs.getString(2));
                data.add(prioridades);
            }
            tableView.setItems(data);
           
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void insertarPrioridades(String idPrioridad, String nombrePrioridad){
        try {
            iniciarConexion();
            s = connection.createStatement();
            int z = s.executeUpdate("INSERT INTO \"Prioridades\"(\"IdPrioridad\", \"NombrePrioridad\") VALUES (" + idPrioridad + ", '" + nombrePrioridad + "')");
            if (z == 1) {
                System.out.println("Se agregó el registro");
            } else {
                System.out.println("No se pudo registrar");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void eliminarPrioridad(String idPrioridad){
        try {
            iniciarConexion();
            s = connection.createStatement();
            int z = s.executeUpdate("DELETE FROM \"Prioridades\" WHERE \"IdPrioridad\"=" + idPrioridad);
            if (z == 1) {
                System.out.println("Se elimino el registro");
            } else {
                System.out.println("No se pudo eliminar");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void actualizarPrioridad(String idPrioridad, String nombrePrioridad){
        try {
            iniciarConexion();
            s = connection.createStatement();
            int z = s.executeUpdate("UPDATE \"Prioridades\" SET \"NombrePrioridad\"='" + nombrePrioridad + "' WHERE \"IdPrioridad\"=" + idPrioridad);
            if (z == 1) {
                System.out.println("Se actualizo el registro");
            } else {
                System.out.println("No se pudo actualizar el registro");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void obtenerDatosEmpresa(ArrayList<String> datos){
        try {
            iniciarConexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT * FROM \"Empresa\"");
            
            
            while (rs.next()) {                
                datos.add(rs.getString(1));
                datos.add(rs.getString(2));
                datos.add(rs.getString(3));
                datos.add(rs.getString(4));
                datos.add(rs.getString(5));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void actualizarDatosEmpresa(String nombreEmpresa, String idioma, String zonaHoraria, String vencimientoTicket){
        try {
            iniciarConexion();
            s = connection.createStatement();
            int z = s.executeUpdate("UPDATE \"Empresa\" SET \"NombreEmpresa\"='" + nombreEmpresa + "', \"Idioma\"='" + idioma + "', \"ZonaHoraria\"='" + zonaHoraria + "', \"vencimientoTicket\"=" + vencimientoTicket);
            if (z == 1) {
                System.out.println("Se actualizo el registro");
            } else {
                System.out.println("No se pudo actualizar el registro");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void guardarImagen(File archivoImagen){
        String url = "jdbc:postgresql://ep-tiny-cloud-a4vxtune-pooler.us-east-1.aws.neon.tech/sistemaTickets?user=neondb_owner&password=npg_afHzK8XIx9oZ&sslmode=require";
        String query = "UPDATE \"Empresa\" SET \"nombreLogo\"=?, datos=?";
        try (
            Connection conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(query);
            FileInputStream fis = new FileInputStream(archivoImagen);
        ){
            pstmt.setString(1, archivoImagen.getName());
            pstmt.setBinaryStream(2, fis, (int) archivoImagen.length());
            int filas = pstmt.executeUpdate();
            
            if (filas > 0){
                System.out.println("Imagen guardada");
            } else {
                System.out.println("No se pudo guardar la imagen");
            }
            
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void mostrarImagen(ImageView ImageView){
        String url = "jdbc:postgresql://ep-tiny-cloud-a4vxtune-pooler.us-east-1.aws.neon.tech/sistemaTickets?user=neondb_owner&password=npg_afHzK8XIx9oZ&sslmode=require";
        String query = "SELECT \"nombreLogo\", datos FROM \"Empresa\"";
        
        try (
            Connection conn = DriverManager.getConnection(url);
            PreparedStatement pstmt = conn.prepareStatement(query);
        ){
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                InputStream is = rs.getBinaryStream("datos");
                Image imagen = new Image(is);
                ImageView.setImage(imagen);
            }
        } catch (Exception e) {
        }
    }
    
    // Fin modulo de parametros <-------------
    
    // Modulo de usuarios ------------------------->
    
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
           
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void buscarUsuarios(TableView<UsuarioTabla> tableView, String id){
        ObservableList<UsuarioTabla> data = FXCollections.observableArrayList();
        try {
            iniciarConexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT u.idusuario, u.\"nombreCompleto\", u.nombreusuario, u.\"correoElectronico\", r.nombrerol FROM \"Usuarios\" u JOIN \"Roles\" r ON u.idrol = r.idrol WHERE u.idusuario = " + id);
            
            while (rs.next()) {                
                UsuarioTabla usuario = new UsuarioTabla(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                data.add(usuario);
            }
            tableView.setItems(data);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
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
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void actualizarUsuarios(String id, String nombreCompleto, String correoElectronico, String nombreUsuario, String password, String idRol){
        try {
            iniciarConexion();
            s = connection.createStatement();
            int z = s.executeUpdate("UPDATE \"Usuarios\" SET \"nombreCompleto\"='" + nombreCompleto + "', nombreusuario='" + nombreUsuario + "', passowrd='" + password + "', idrol=" + idRol + ", \"correoElectronico\"='" + correoElectronico + "' WHERE idusuario=" + id);
            if (z == 1) {
                System.out.println("Se actualizo el registro");
            } else {
                System.out.println("No se pudo actualizar el registro");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void eliminarUsuarios(String id){
        try {
            iniciarConexion();
            s = connection.createStatement();
            int z = s.executeUpdate("DELETE FROM \"Usuarios\" WHERE idusuario=" + id);
            if (z == 1) {
                System.out.println("Se agregó elimino el registro");
            } else {
                System.out.println("No se pudo eliminar el registro");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    // Fin modulo de usuarios <-------------
    
    // Modulo Roles y permisos ---------------->
    public void consultarRoles(TableView<RolesTabla> tableView){
        ObservableList<RolesTabla> data = FXCollections.observableArrayList();
        try {
            iniciarConexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT idrol, nombrerol, \"descripcionRol\", tipoacceso FROM \"Roles\"");
            
            
            while (rs.next()) {                
                RolesTabla roles = new RolesTabla(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                data.add(roles);
            }
            tableView.setItems(data);
           
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void consultarPermisos(TableView<PermisosTabla> tableView){
        ObservableList<PermisosTabla> data = FXCollections.observableArrayList();
        try {
            iniciarConexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT p.\"idPermiso\", p.\"nombrePermiso\", p.\"descripcionPermiso\", r.nombrerol FROM \"Permisos\" p JOIN \"Roles\" r ON p.idrol = r.idrol");
            
            
            while (rs.next()) {                
                PermisosTabla permisos = new PermisosTabla(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                data.add(permisos);
            }
            tableView.setItems(data);
           
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void insertarRoles(String nombreRol, String tipoAcceso, String descripcionRol){
        try {
            iniciarConexion();
            s = connection.createStatement();
            int z = s.executeUpdate("INSERT INTO \"Roles\"(nombrerol, tipoacceso, \"descripcionRol\") VALUES ('" + nombreRol + "', " + tipoAcceso + ", '" + descripcionRol + "')");
            if (z == 1) {
                System.out.println("Se agregó el registro");
            } else {
                System.out.println("No se pudo registrar");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void insertarPermisos(String nombrePermiso, String descripcionPermiso, String idRol){
        try {
            iniciarConexion();
            s = connection.createStatement();
            int z = s.executeUpdate("INSERT INTO \"Permisos\"(\"nombrePermiso\", \"descripcionPermiso\", idrol) VALUES ('" + nombrePermiso + "', '" + descripcionPermiso + "', "+ idRol +")");
            if (z == 1) {
                System.out.println("Se agregó el registro");
            } else {
                System.out.println("No se pudo registrar");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void actualizarRoles(String id, String nombreRol, String tipoAcceso,  String descripcionROl){
        try {
            iniciarConexion();
            s = connection.createStatement();
            int z = s.executeUpdate("UPDATE \"Roles\" SET nombrerol='" + nombreRol + "', tipoacceso=" + tipoAcceso + ", \"descripcionRol\"='" + descripcionROl + "' WHERE idrol=" + id);
            if (z == 1) {
                System.out.println("Se actualizo el registro");
            } else {
                System.out.println("No se pudo actualizar el registro");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void actualizarPermisos(String id, String nombrePermiso, String descripcionPermiso,  String idRol){
        try {
            iniciarConexion();
            s = connection.createStatement();
            int z = s.executeUpdate("UPDATE \"Permisos\" SET \"nombrePermiso\"='" + nombrePermiso + "', \"descripcionPermiso\"='"+ descripcionPermiso +"', idrol='" + idRol + "' WHERE \"idPermiso\"=" + id);
            if (z == 1) {
                System.out.println("Se actualizo el registro");
            } else {
                System.out.println("No se pudo actualizar el registro");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void eliminarRoles(String id){
        try {
            iniciarConexion();
            s = connection.createStatement();
            int z = s.executeUpdate("DELETE FROM \"Roles\" WHERE idrol=" + id);
            if (z == 1) {
                System.out.println("Se agregó elimino el registro");
            } else {
                System.out.println("No se pudo eliminar el registro");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void eliminarPermisos(String id){
        try {
            iniciarConexion();
            s = connection.createStatement();
            int z = s.executeUpdate("DELETE FROM public.\"Permisos\" WHERE \"idPermiso\"=" + id);
            if (z == 1) {
                System.out.println("Se agregó elimino el registro");
            } else {
                System.out.println("No se pudo eliminar el registro");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    // Fin modulo de Roles y permisos <-------------
    
    
}
