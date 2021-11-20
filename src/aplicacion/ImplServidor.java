/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class ImplServidor extends UnicastRemoteObject implements InterfazServidor{
    
    private baseDatos.FachadaBaseDatos fbase;
    //Usuarios conectados
    private ArrayList<Usuario> usuarios;
    
    
    public ImplServidor(baseDatos.FachadaBaseDatos fbase) throws RemoteException{
        super();
        this.fbase = fbase;
        this.usuarios = new ArrayList();
    }
    
    
    @Override
    public boolean LogIn(InterfazUsuario user,String nombre,String clave) throws RemoteException{
        Usuario usuario = new Usuario(nombre,user);
        if(this.usuarios.contains(usuario)){
            return false;
        }
        this.usuarios.add(usuario);
        return fbase.LogIn(nombre, clave);
    }
    
    @Override
    public boolean LogOut(InterfazUsuario user,String nombre) throws RemoteException{
        Usuario user2 = new Usuario(nombre,user);
        this.usuarios.remove(user2);
        return true;
    }
    
    @Override
    public boolean Registrarse(InterfazUsuario user,String nombre,String clave) throws RemoteException{
        //Aqui no añadimos el usuario
        return fbase.Registro(nombre, clave);   
    }
    
    @Override
    public boolean Editar(String id,String clave) throws RemoteException{
        return this.fbase.Editar(id, clave);
    }
}
