/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author PC
 */
public interface InterfazServidor extends Remote{
    
    public boolean  LogIn(InterfazUsuario user,String nombre,String clave) throws RemoteException;
    
    public boolean  LogOut(InterfazUsuario user,String nombre) throws RemoteException;
    
    public boolean  Registrarse(InterfazUsuario user,String nombre,String clave) throws RemoteException;
    
    public boolean  Editar(String id,String clave) throws RemoteException;
    
    public void  EliminarAmigo(InterfazUsuario user, String id,String amigo) throws RemoteException;
    
    public void  AnadirAmigo(InterfazUsuario user, String id,String amigo) throws RemoteException;
    
    public void  VerUsuariosDesconocidos(InterfazUsuario user, String id, String nombre) throws RemoteException;
    
    public void enviarpeti(InterfazUsuario user, String id, String amigo) throws RemoteException;
}
