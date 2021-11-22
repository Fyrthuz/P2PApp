/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class ImplServidor extends UnicastRemoteObject implements InterfazServidor {

    private baseDatos.FachadaBaseDatos fbase;
    //Usuarios conectados
    private ArrayList<Usuario> usuarios;

    public ImplServidor(baseDatos.FachadaBaseDatos fbase) throws RemoteException {
        super();
        this.fbase = fbase;
        this.usuarios = new ArrayList();
    }

    @Override
    public synchronized boolean LogIn(InterfazUsuario user, String nombre, String clave) throws RemoteException {
        Usuario usuario = new Usuario(nombre, user);
        if (this.usuarios.contains(usuario)) {
            return false;
        }
        this.usuarios.add(usuario);
        ArrayList<Usuario> notifica = new ArrayList();
        ArrayList<String> desconectados = new ArrayList();
        for (String s : this.fbase.Amigos(nombre)) {
            for (Usuario u : this.usuarios) {
                if (u.getId().equals(s)) {
                    notifica.add(u);
                } else {
                    desconectados.add(s);
                }
            }
        }

        usuario.getInterfaz().definirDesconectados(desconectados);

        
        for (Usuario s : notifica) {
            s.getInterfaz().NotificaConexionAmigo(usuario.getInterfaz(), usuario.getId(), s.getId());
        }
        
        
        for (String sa : this.fbase.SolicitarAmigos(nombre)) {
            user.NotificaSolicitudAmigo(user, sa);
        }

        return fbase.LogIn(nombre, clave);
    }

    @Override
    public synchronized boolean LogOut(InterfazUsuario user, String nombre) throws RemoteException {
        Usuario user2 = new Usuario(nombre, user);
        this.usuarios.remove(user2);
        ArrayList<Usuario> notifica = new ArrayList();
        for (String s : this.fbase.Amigos(nombre)) {
            for (Usuario u : this.usuarios) {
                if (u.getId().equals(s)) {
                    notifica.add(u);
                }
            }
        }
        for (Usuario s : notifica) {
            s.getInterfaz().NotificaDesconexionAmigo(user2.getInterfaz(), user2.getId());
        }
        return true;
    }

    @Override
    public synchronized boolean Registrarse(InterfazUsuario user, String nombre, String clave) throws RemoteException {
        //Aqui no añadimos el usuario
        return fbase.Registro(nombre, clave);
    }

    @Override
    public synchronized boolean Editar(String id, String clave) throws RemoteException {
        return this.fbase.Editar(id, clave);
    }

    @Override
    public synchronized void EliminarAmigo(InterfazUsuario user, String id, String amigo) throws RemoteException {
        user.NotificaSolicitudAmigoUnaCon(user, this.fbase.EliminaSolicitudAmigo(id, amigo));
    }

    @Override
    public synchronized void AnadirAmigo(InterfazUsuario user, String id, String amigo) throws RemoteException {
        user.NotificaSolicitudAmigoUnaCon(user, this.fbase.AceptarSolicitudAmistad(id, amigo));
        int controlador=0;
        for(Usuario s: usuarios){
            if (s.getId().equals(amigo)){
                controlador=1;
                user.NotificaConexionAmigo(user, amigo, id);
                s.getInterfaz().NotificaConexionAmigo(user, id, s.getId());
            }
        }
        //Si el usuario no está conectado lo metemos en desconectados
        if (controlador==0){
            user.definirDesconectados(this.fbase.Amigos(id));
        }
    }
    
    @Override
    public synchronized void VerUsuariosDesconocidos(InterfazUsuario user, String id, String nombre) throws RemoteException{
        user.NotificaAmigosDesconocidos(user, this.fbase.buscarUsuario(id, nombre));
    }
    
    @Override
    public synchronized void enviarpeti(InterfazUsuario user, String id, String amigo) throws RemoteException{
        if (this.fbase.NuevaSolicitudAmistad(id, amigo)){
            for(Usuario s: usuarios){
                if (s.getId().equals(amigo)){
                    s.getInterfaz().AnadirSolicitudAmistad(user, id);
                }
            }
        } else {
            System.out.println("Error a la hora de enviar peti");
        }
    }
    
    @Override
    public synchronized void EliminarAmistad (String id,String eliminado) throws RemoteException{
        this.fbase.EliminarAmista(id, eliminado);
        for(Usuario user : this.usuarios){
            if(user.getId().equals(id)){
                user.getInterfaz().eliminarAmistades(eliminado);
            }else if(user.getId().equals(eliminado)){
                user.getInterfaz().eliminarAmistades(id);
            }
        }
    }

    @Override
    public synchronized void VerAmigo(InterfazUsuario user, String id, String amigo) throws RemoteException{
        System.out.println(this.fbase.VerAmigos(id, amigo));
        user.NotificaAmigos(user, this.fbase.VerAmigos(id, amigo));
    }
}
