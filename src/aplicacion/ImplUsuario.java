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
public class ImplUsuario extends UnicastRemoteObject implements InterfazUsuario{
    
    private ArrayList<Usuario> amigos;
    
    public ImplUsuario() throws RemoteException {
        super();
        this.amigos = new ArrayList();
    }
    
    @Override
    public void RecibeMensajes(String mensaje){
    
    }
    
    @Override
    public void NotificaConexionAmigo(Usuario amigo){
        this.amigos.add(amigo);
    }
    
    @Override
    public void NotificaDesconexionAmigo(Usuario amigo){
        this.amigos.remove(amigo);
    }

    public ArrayList<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(ArrayList<Usuario> amigos) {
        this.amigos = amigos;
    }
    
}
