/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Diego
 */
public class FachadaBaseDatos {
    
    private java.sql.Connection conexion;
    private DaoUsuarios DAOUsuarios;
    
    public FachadaBaseDatos() {
        Properties configuracion = new Properties();
        FileInputStream arqConfiguracion;
        
        
        try {
            arqConfiguracion = new FileInputStream("baseDatos.properties");
            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();

            Properties usuario = new Properties();

            String gestor = configuracion.getProperty("gestor");

            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            this.conexion = java.sql.DriverManager.getConnection("jdbc:" + gestor + "://"
                    + configuracion.getProperty("servidor") + ":"
                    + configuracion.getProperty("puerto") + "/"
                    + configuracion.getProperty("baseDatos"),
                    usuario);

            this.DAOUsuarios = new DaoUsuarios(conexion);

        } catch (IOException | SQLException f) {
            System.err.println(f);
        }

    }
    
    public boolean LogIn(String id,String clave){
        return this.DAOUsuarios.LogIn(id, clave);
    }
    
    public boolean Registro(String id,String clave){
        return this.DAOUsuarios.Registro(id, clave);
    }
    
    public ArrayList<String> Amigos (String id){
        return this.DAOUsuarios.Amigos(id);
    }
    
    public boolean Editar(String id, String clave){
        return this.DAOUsuarios.modificarUsuario(id, clave);
    }
    
    public ArrayList<String> SolicitarAmigos(String id){
        return this.DAOUsuarios.SolicitarAmigos(id);
    }
    
    public ArrayList<String> EliminaSolicitudAmigo(String id, String amigo) {
        return this.DAOUsuarios.EliminaSolicitudAmigo(id, amigo);
    }
    
    public boolean AceptarSolicitudAmistad(String id, String amigo) {
        return this.DAOUsuarios.AceptarSolicitudAmistad(id, amigo);
    }
}
