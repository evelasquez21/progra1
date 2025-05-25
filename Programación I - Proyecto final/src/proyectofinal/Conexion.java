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
import javafx.scene.control.Label;
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
    
    // Modulo de Login ------------------------->
    
    
    // Fin modulo de Login <-------------
    public boolean iniciarSession(String nombreUsuario, String passowrd){
        boolean usuario = false;
        try {
            iniciarConexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT nombreusuario, passowrd FROM \"Usuarios\" WHERE nombreusuario='" + nombreUsuario + "' AND passowrd='" + passowrd + "'");
            
            
            while (rs.next()) {                
                if(rs.getString(1) != null){
                    System.out.println("Sesión iniciada");
                    usuario = true;
                } else {
                    usuario = false;
                }
            }
            
           
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        
        return usuario;
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
                datos.add(rs.getString(6));
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
    
    public void listaRoles(ComboBox cbo, ArrayList<String> datos){
        try {
            iniciarConexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT * FROM \"Roles\"");
            
            ObservableList<String> list = FXCollections.observableArrayList();
            while (rs.next()) {
                list.add(rs.getString(1));
                datos.add(rs.getString(1));
                datos.add(rs.getString(2));
            }
            cbo.setItems(list);
           
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    // Fin modulo de usuarios <-------------
    
    // Modulo Roles y permisos ---------------->
    public void consultarRoles(TableView<RolesTabla> tableView, ArrayList<String> datos){
        ObservableList<RolesTabla> data = FXCollections.observableArrayList();
        try {
            iniciarConexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT idrol, nombrerol, \"descripcionRol\", tipoacceso FROM \"Roles\"");
            
            
            while (rs.next()) {                
                RolesTabla roles = new RolesTabla(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                datos.add(rs.getString(1));
                datos.add(rs.getString(2));
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
    
    
    // Modulo de Departamentos ---------------->
    public void consultarAsignaciones(TableView<Asignaciones> tableView){
        ObservableList<Asignaciones> data = FXCollections.observableArrayList();
        try {
            iniciarConexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT a.\"idAsignacion\", u.\"nombreCompleto\", u.nombreusuario, d.\"NombreDepartamento\" FROM \"Asignacion\" a  JOIN \"Usuarios\" u ON u.idusuario = a.idusuario JOIN \"Departamentos\" d ON d.\"IdDepartamento\" = a.\"IdDepartamento\"");
            
            
            while (rs.next()) {                
                Asignaciones asignaciones = new Asignaciones(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                data.add(asignaciones);
            }
            tableView.setItems(data);
           
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void consultarDepartamentos(TableView<Departamentos> tableView, ArrayList<String> datos){
        ObservableList<Departamentos> data = FXCollections.observableArrayList();
        try {
            iniciarConexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT * FROM \"Departamentos\"");
            
            
            while (rs.next()) {                
                Departamentos depto = new Departamentos(rs.getString(1), rs.getString(2), rs.getString(3));
                data.add(depto);
                datos.add(rs.getString(1));
                datos.add(rs.getString(2));
            }
            tableView.setItems(data);
           
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void listaTecnicos(ComboBox cbo, ArrayList<String> datos){
        try {
            iniciarConexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT u.idusuario, u.\"nombreCompleto\" FROM \"Roles\" r JOIN \"Usuarios\" u ON r.idrol = u.idrol WHERE r.nombrerol LIKE '%Tecnico%'");
            
            ObservableList<String> list = FXCollections.observableArrayList();
            while (rs.next()) {
                list.add(rs.getString(1));
                datos.add(rs.getString(1));
                datos.add(rs.getString(2));
            }
            cbo.setItems(list);
           
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void insertarDepartamentos(String nombreDepto, String descripcionDepto){
        try {
            iniciarConexion();
            s = connection.createStatement();
            int z = s.executeUpdate("INSERT INTO \"Departamentos\"(\"NombreDepartamento\", \"DescripcionDepartamento\") VALUES ('" + nombreDepto + "', '" + descripcionDepto + "')");
            if (z == 1) {
                System.out.println("Se agregó el registro");
            } else {
                System.out.println("No se pudo registrar");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void actualizarDepartamentos(String id, String nombreDepto, String descripcionDepto){
        try {
            iniciarConexion();
            s = connection.createStatement();
            int z = s.executeUpdate("UPDATE \"Departamentos\" SET \"NombreDepartamento\"='" + nombreDepto + "', \"DescripcionDepartamento\"='" + descripcionDepto + "' WHERE \"IdDepartamento\"=" + id);
            if (z == 1) {
                System.out.println("Se actualizo el registro");
            } else {
                System.out.println("No se pudo actualizar el registro");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void eliminarDepartamentos(String id){
        try {
            iniciarConexion();
            s = connection.createStatement();
            int z = s.executeUpdate("DELETE FROM \"Departamentos\" WHERE \"IdDepartamento\"=" + id);
            if (z == 1) {
                System.out.println("Se agregó elimino el registro");
            } else {
                System.out.println("No se pudo eliminar el registro");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void insertarAsignaciones(String idUsuario, String idDepartamento){
        try {
            iniciarConexion();
            s = connection.createStatement();
            int z = s.executeUpdate("INSERT INTO \"Asignacion\"(idusuario, \"IdDepartamento\") VALUES (" + idUsuario + ", " + idDepartamento + ")");
            if (z == 1) {
                System.out.println("Se agregó el registro");
            } else {
                System.out.println("No se pudo registrar");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void actualizatAsignaciones(String id, String idUsuario, String idDepartamento){
        try {
            iniciarConexion();
            s = connection.createStatement();
            int z = s.executeUpdate("UPDATE \"Asignacion\" SET idusuario=" + idUsuario + ", \"IdDepartamento\"=" + idDepartamento + " WHERE \"idAsignacion\"=" + id);
            if (z == 1) {
                System.out.println("Se actualizo el registro");
            } else {
                System.out.println("No se pudo actualizar el registro");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void eliminarAsignaciones(String id){
        try {
            iniciarConexion();
            s = connection.createStatement();
            int z = s.executeUpdate("DELETE FROM \"Asignacion\" WHERE \"idAsignacion\"=" + id);
            if (z == 1) {
                System.out.println("Se agregó elimino el registro");
            } else {
                System.out.println("No se pudo eliminar el registro");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    // Fin modulo de Departamentos <-------------
    
    // Modulo de Tickets ---------------->
    public void consultaTickets(TableView<Tickets> tableView){
        ObservableList<Tickets> data = FXCollections.observableArrayList();
        try {
            iniciarConexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT t.\"noTicket\", t.descripcion,  d.\"NombreDepartamento\", p.\"NombrePrioridad\",  TO_CHAR(t.\"FechaCreacion\", 'DD/MM/YYYY'), t.\"desProblema\" FROM \"Ticket\" t JOIN \"Departamentos\" d ON d.\"IdDepartamento\" = t.\"idDepartamento\" JOIN \"Prioridades\" p ON p.\"IdPrioridad\" = t.\"idPrioridad\"");
            
            while (rs.next()) {      
                Tickets ticket = new Tickets(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                data.add(ticket);
                
            }
            tableView.setItems(data);
           
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void insertarTicket(String descripcion, String idDepartamento, String idPrioridad, String desProblema){
        try {
            iniciarConexion();
            s = connection.createStatement();
            int z = s.executeUpdate("INSERT INTO \"Ticket\"(descripcion, \"idDepartamento\", \"idPrioridad\", \"FechaCreacion\", \"desProblema\") VALUES ('"+ descripcion +"', '"+ idDepartamento +"', '"+ idPrioridad +"', CURRENT_DATE, '"+ desProblema +"')");
            if (z == 1) {
                System.out.println("Se agregó el registro");
            } else {
                System.out.println("No se pudo registrar");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void actualizarTicket(String noTicket, String descripcion, String idDepartamento, String idPrioridad, String desProblema){
        try {
            iniciarConexion();
            s = connection.createStatement();
            int z = s.executeUpdate("UPDATE \"Ticket\" SET descripcion='"+ descripcion +"', \"idDepartamento\"="+ idDepartamento +", \"idPrioridad\"="+ idPrioridad +", \"desProblema\"='"+ desProblema +"' WHERE \"noTicket\"=" + noTicket);
            if (z == 1) {
                System.out.println("Se actualizo el registro");
            } else {
                System.out.println("No se pudo actualizar el registro");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void eliminarTicket(String noTicket){
        try {
            iniciarConexion();
            s = connection.createStatement();
            int z = s.executeUpdate("DELETE FROM \"Ticket\" WHERE \"nivelEstado\"=" + noTicket);
            if (z == 1) {
                System.out.println("Se actualizo el registro");
            } else {
                System.out.println("No se pudo actualizar el registro");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void consultaEstados(TableView<Estados> tableView){
        ObservableList<Estados> data = FXCollections.observableArrayList();
        try {
            iniciarConexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT * FROM \"Estados\"");
            
            while (rs.next()) {      
                Estados estado = new Estados(rs.getString(1), rs.getString(2), rs.getString(3));
                data.add(estado);
                
            }
            tableView.setItems(data);
           
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void insertarEstado(String nivelEstado, String nombreEstado, String descripcionEstado){
        try {
            iniciarConexion();
            s = connection.createStatement();
            int z = s.executeUpdate("INSERT INTO public.\"Estados\"(\"nivelEstado\", \"nombreEstado\", \"descripcionEstado\") VALUES (" + nivelEstado + ", '" + nombreEstado + "', '" + descripcionEstado + "');");
            if (z == 1) {
                System.out.println("Se agregó el registro");
            } else {
                System.out.println("No se pudo registrar");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void actualizarEstados(String nivelEstado, String nombreEstado, String descripcionEstado){
        try {
            iniciarConexion();
            s = connection.createStatement();
            int z = s.executeUpdate("UPDATE \"Estados\" SET \"nombreEstado\"='"+ nombreEstado +"', \"descripcionEstado\"='"+ descripcionEstado +"' WHERE \"nivelEstado\"=" + nivelEstado);
            if (z == 1) {
                System.out.println("Se actualizo el registro");
            } else {
                System.out.println("No se pudo actualizar el registro");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void EliminarEstado(String nivelEstado){
        try {
            iniciarConexion();
            s = connection.createStatement();
            int z = s.executeUpdate("DELETE FROM \"Estados\" WHERE \"nivelEstado\"=" + nivelEstado);
            if (z == 1) {
                System.out.println("Se actualizo el registro");
            } else {
                System.out.println("No se pudo actualizar el registro");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void listaDepartamentos(ComboBox cbo, ArrayList<String> datos){
        try {
            iniciarConexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT * FROM \"Departamentos\"");
            
            ObservableList<String> list = FXCollections.observableArrayList();
            while (rs.next()) {
                list.add(rs.getString(1));
                datos.add(rs.getString(1));
                datos.add(rs.getString(2));
            }
            cbo.setItems(list);
           
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void listaPrioridad(ComboBox cbo, ArrayList<String> datos){
        try {
            iniciarConexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT * FROM \"Prioridades\"");
            
            ObservableList<String> list = FXCollections.observableArrayList();
            while (rs.next()) {
                list.add(rs.getString(1));
                datos.add(rs.getString(1));
                datos.add(rs.getString(2));
            }
            cbo.setItems(list);
           
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    // Fin modulo de Tickets <-------------
}
