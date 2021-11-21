/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public interface InterfazUsuario extends Remote{
    
    public void RecibeMensajes(String mensaje) throws RemoteException;
    public void NotificaConexionAmigo(InterfazUsuario amigo,String id,String selfId) throws RemoteException;
    public void NotificaDesconexionAmigo(InterfazUsuario amigo,String id) throws RemoteException;
    public void NotificaSolicitudAmigo(InterfazUsuario amigo,String id) throws RemoteException;
    public void AnadeAmigoALosConectados(InterfazUsuario amigo, String id) throws RemoteException;
    public void definirDesconectados(ArrayList<String> desconectados) throws RemoteException;
    public void NotificaSolicitudAmigoUnaCon (InterfazUsuario amigo,ArrayList<String> id) throws RemoteException;
    public ArrayList<String> getSa() throws RemoteException;
}
