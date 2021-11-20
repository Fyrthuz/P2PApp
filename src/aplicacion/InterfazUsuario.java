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
public interface InterfazUsuario extends Remote{
    
    public void RecibeMensajes(String mensaje) throws RemoteException;
    public void NotificaConexionAmigo(Usuario amigo) throws RemoteException;
    public void NotificaDesconexionAmigo(Usuario amigo) throws RemoteException;
}
