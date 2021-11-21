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
    public boolean LogIn(InterfazUsuario user, String nombre, String clave) throws RemoteException {
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
        for (Usuario s : notifica) {
            s.getInterfaz().NotificaConexionAmigo(usuario.getInterfaz(), usuario.getId(), s.getId());
        }

        usuario.getInterfaz().definirDesconectados(desconectados);

        for (String sa : this.fbase.SolicitarAmigos(nombre)) {
            user.NotificaSolicitudAmigo(user, sa);
        }

        return fbase.LogIn(nombre, clave);
    }

    @Override
    public boolean LogOut(InterfazUsuario user, String nombre) throws RemoteException {
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
    public boolean Registrarse(InterfazUsuario user, String nombre, String clave) throws RemoteException {
        //Aqui no añadimos el usuario
        return fbase.Registro(nombre, clave);
    }

    @Override
    public boolean Editar(String id, String clave) throws RemoteException {
        return this.fbase.Editar(id, clave);
    }

    @Override
    public void EliminarAmigo(InterfazUsuario user, String id, String amigo) throws RemoteException {
        user.NotificaSolicitudAmigoUnaCon(user, this.fbase.EliminaSolicitudAmigo(id, amigo));
    }

    @Override
    public boolean AnadirAmigo(InterfazUsuario user, String id, String amigo) throws RemoteException {
        return this.fbase.AceptarSolicitudAmistad(id, amigo);
    }
}
