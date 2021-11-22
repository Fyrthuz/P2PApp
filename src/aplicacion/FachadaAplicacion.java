/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.rmi.RemoteException;

/**
 *
 * @author Diego
 */
public class FachadaAplicacion {
    gui.FachadaGui fgui;
    baseDatos.FachadaBaseDatos fbd;
    InterfazServidor server;
    ImplUsuario user;

    public InterfazServidor getServer() {
        return server;
    }

    public void setServer(InterfazServidor server) {
        this.server = server;
    }

    public FachadaAplicacion(ImplUsuario user) {
        fgui = new gui.FachadaGui(this);
        this.user = user;
        
    }
    
    public void IniciaVista(){
        fgui.iniciaVista();
    }
    public void mostrarRegistro(InterfazServidor server){
        fgui.mostrarRegistro(server);
    }
    public void mostrarVprincipal(String nombre) throws RemoteException{
        fgui.mostrarVprincipal(nombre);
    }
    
    public void mostrarVEditar(String id){
        fgui.mostrarVEditar(id);
    }
    
    public void mostrarVVusuarios(String id){
        fgui.mostrarVVusuarios(id);
    }
    public ImplUsuario getUser() {
        return user;
    }

    public void setUser(ImplUsuario user) {
        this.user = user;
    }
    
    
    
}
