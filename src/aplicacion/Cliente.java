/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import gui.FachadaGui;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Fernando
 */
public class Cliente {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        ImplUsuario user = new ImplUsuario();
        FachadaAplicacion app = new FachadaAplicacion(user);
        user.fa= app;
        app.fgui.iniciaVista();
    }
    
}
