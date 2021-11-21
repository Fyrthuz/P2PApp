/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class DaoUsuarios extends AbstractDAO{
    
    public DaoUsuarios(Connection conexion){
        super.setConexion(conexion);
    }
    
    //Registro de un usuario en la bd
    public boolean LogIn(String id,String clave){
        
        Connection con;
        PreparedStatement stmCatalogo = null;
        ResultSet rsCatalogo;

        con = this.getConexion();

        String consulta = "select * "
                + "from usuarios as u "
                + "where idusuarios = ?";

        try {
            String clavecomp = "";
            String Usuario = "";
            stmCatalogo = con.prepareStatement(consulta);
            stmCatalogo.setString(1, id);

            rsCatalogo = stmCatalogo.executeQuery();

            if (rsCatalogo.next()) {
                Usuario = rsCatalogo.getString("idusuarios");
                clavecomp = rsCatalogo.getString("contrasena");

            }
            if(clavecomp.isEmpty() || !clavecomp.equals(clave)){
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                stmCatalogo.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return true;
    }
    
    //Registro de un usuario en la bd
    public boolean Registro(String id,String clave){
        
        Connection con;
        PreparedStatement stmUsuario = null;

        con = super.getConexion();
        try {
            stmUsuario = con.prepareStatement("insert into usuarios (idusuarios, contrasena) "
                    + "values (?,?)");
            stmUsuario.setString(1, id);
            stmUsuario.setString(2, clave);
            stmUsuario.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return true;
    }
    
    //Modifica la contraseña de un usuario en la bd
    public boolean modificarUsuario(String id, String clave) {
        Connection con;
        PreparedStatement stmUsuario = null;

        con = super.getConexion();
        //Se entiende que los fondos y el tipo de usuario no se pueden cambiar
        try {
            stmUsuario = con.prepareStatement("update usuarios set contrasena = ? where idusuarios=? ");
            stmUsuario.setString(1, clave);
            stmUsuario.setString(2, id);
            stmUsuario.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return true;
    }
    
    //Consulta de los amigos que tiene un usuario
    public ArrayList<String> Amigos(String id) {
        
        ArrayList<String> ret = new ArrayList();
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsAmigos;
        String aux;
        con = super.getConexion();
        try {
            stmUsuario = con.prepareStatement("select amigo1 from amigos where amigo2=? and aceptado=?");
            stmUsuario = con.prepareStatement("select amigo1 from amigos where amigo2=? and aceptado=true");
            stmUsuario.setString(1, id);
            stmUsuario.setBoolean(2, true);
            rsAmigos = stmUsuario.executeQuery();
            
            while (rsAmigos.next()) {
                aux = rsAmigos.getString("amigo1");
                ret.add(aux);
            }
          
            stmUsuario = con.prepareStatement("select amigo2 from amigos where amigo1=? and aceptado=?");
            stmUsuario = con.prepareStatement("select amigo2 from amigos where amigo1=? and aceptado=true");
            stmUsuario.setString(1, id);
            stmUsuario.setBoolean(2, true);
            rsAmigos = stmUsuario.executeQuery();
            
            while (rsAmigos.next()) {
                aux = rsAmigos.getString("amigo2");
                ret.add(aux);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return ret;
        } finally {
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return ret;
    }
    
    //Consulta de las solicitudes de amistad de un usuario
    public ArrayList<String> SolicitarAmigos(String id) {
        
        ArrayList<String> ret = new ArrayList();
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsAmigos;
        String aux;

        con = super.getConexion();
        try {
            stmUsuario = con.prepareStatement("select amigo1 from amigos where amigo2=? and aceptado=false");
            stmUsuario.setString(1, id);
            rsAmigos = stmUsuario.executeQuery();
            
            while (rsAmigos.next()) {
                aux = rsAmigos.getString("amigo1");
                ret.add(aux);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return ret;
        } finally {
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return ret;
    }
    
    //Rechazo de la solicitud
    public ArrayList<String> EliminaSolicitudAmigo(String id, String amigo) {
        Connection con;
        PreparedStatement stmUsuario = null;

        con = super.getConexion();
        try {
            stmUsuario = con.prepareStatement("delete from amigos where amigo1=? and amigo2=?");
            stmUsuario.setString(1, amigo);
            stmUsuario.setString(2, id);
            stmUsuario.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return SolicitarAmigos(id);
    }
    
    //Aceptación de la solicitud
    public boolean AceptarSolicitudAmistad(String id, String amigo) {
        Connection con;
        PreparedStatement stmUsuario = null;

        con = super.getConexion();
        try {
            stmUsuario = con.prepareStatement("update amigos set aceptado=trues where amigo1=? and amigo2=?");
            stmUsuario.setString(1, amigo);
            stmUsuario.setString(2, id);
            stmUsuario.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return true;
    }
    
    //Aceptación de la solicitud
    public boolean NuevaSolicitudAmistad(String id, String amigo) {
        Connection con;
        PreparedStatement stmUsuario = null;
        ResultSet rsCodigo;
        con = super.getConexion();
        int numero = 0;
        try {
            //Vemos el ultimo numero de codigo
            stmUsuario = con.prepareStatement("select codigo from amigos order By codigo desc");
            rsCodigo = stmUsuario.executeQuery();
            if (rsCodigo.next()){
                numero = rsCodigo.getInt("codigo");
            }
            
            //insertamos el usuario
            stmUsuario = con.prepareStatement("insert into amigos values(?, '?', '?', false)");
            stmUsuario.setInt(0, numero);
            stmUsuario.setString(1, id);
            stmUsuario.setString(2, amigo);
            stmUsuario.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                stmUsuario.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return true;
    }
 }
    
