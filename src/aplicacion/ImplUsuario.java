/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author PC
 */
public class ImplUsuario extends UnicastRemoteObject implements InterfazUsuario{
    
    private ArrayList<Usuario> amigos;
    private ArrayList<String> desconectados;
    private ArrayList<String> sa;
    FachadaAplicacion fa;
    
    public ImplUsuario() throws RemoteException {
        super();
        this.amigos = new ArrayList();
        this.desconectados = new ArrayList();
        this.sa = new ArrayList();
    }
    
    @Override
    public void RecibeMensajes(String mensaje){
        this.fa.fgui.getVp().actualizarChat(mensaje);
    }
    
    @Override
    public void NotificaConexionAmigo(InterfazUsuario amigo,String id,String selfid) throws RemoteException{
        this.amigos.add(new Usuario(id,amigo));
        this.fa.fgui.getVp().actualizar_ventanaConectados(this.amigos);
        //this.desconectados=this.getDesconectados();
        this.desconectados.remove(id);
        this.fa.fgui.getVp().actualizar_ventanaDesconectados(this.desconectados);
        amigo.AnadeAmigoALosConectados(this, selfid);
        System.out.println("Se conecto " + id);
        
    }
    
    @Override
    public void NotificaDesconexionAmigo(InterfazUsuario amigo,String id){
        this.amigos.remove(new Usuario(id,amigo));
        this.fa.fgui.getVp().actualizar_ventanaConectados(this.amigos);
        this.desconectados.add(id);
        this.desconectados=this.getDesconectados();
        this.fa.fgui.getVp().actualizar_ventanaDesconectados(this.desconectados);  
        System.out.println("Se desconecto " + id);
        System.out.println(this.amigos);
    }

    
   @Override
    public void AnadeAmigoALosConectados(InterfazUsuario amigo, String id) throws RemoteException{
        if(!this.amigos.contains(new Usuario(id,amigo))){
            this.amigos.add(new Usuario(id,amigo));
            this.desconectados.remove(id);
        }
    }
    
    
    public ArrayList<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(ArrayList<Usuario> amigos) {
        this.amigos = amigos;
    }

    public ArrayList<String> getDesconectados() {
        int aux = this.amigos.size();
        System.out.println(this.amigos);
        System.out.println(this.desconectados);
        for(int i=0; i < aux ; i++){
            if(this.desconectados.contains(this.amigos.get(i).getId())){
                System.out.println("TIS");
                if(aux>=2){
                    this.desconectados.remove(this.amigos.get(i).getId());
                    aux--;
                }else{
                    this.amigos.remove(0);
                    aux=0;
                    break;
                }
                i--;
            }
        }
        System.out.println(this.desconectados);
        Set<String> aux2 = new LinkedHashSet();
        aux2.addAll(this.desconectados);
        desconectados.clear();
        desconectados.addAll(aux2);
        return desconectados;
    }
    
    @Override
    public void definirDesconectados(ArrayList<String> desconectados) throws RemoteException{
        Set<String> aux2 = new LinkedHashSet();
        aux2.addAll(desconectados);
        desconectados.clear();
        desconectados.addAll(aux2);
        this.desconectados = desconectados;
    }
    
    
    @Override
    public void NotificaSolicitudAmigo(InterfazUsuario amigo, String id) throws RemoteException{
        this.sa.add(id);
    }
    
    @Override
    public void NotificaSolicitudAmigoUnaCon(InterfazUsuario amigo, ArrayList<String> id) throws RemoteException{
        this.sa.clear();
        this.sa = id;
        this.fa.fgui.getVp().actualizar_ventanaSolicitudAmistad(this.sa);
    }
    
    @Override
    public ArrayList<String> getSa() throws RemoteException{
        return sa;
    }
    
    @Override
    public void NotificaAmigosDesconocidos (InterfazUsuario amigo,ArrayList<String> id) throws RemoteException{
        System.out.println(id);
        this.fa.fgui.getVv().actualizaventana(id);
    }
    
    @Override
    public void AnadirSolicitudAmistad (InterfazUsuario amigo,String id) throws RemoteException{
        this.sa.add(id);
        this.fa.fgui.getVp().actualizar_ventanaSolicitudAmistad(this.sa);
    }
    
    @Override
    public void eliminarAmistades(String amistad) throws RemoteException{
        Usuario user = new Usuario(amistad,null);
        this.amigos.remove(user);
        this.desconectados.remove(amistad);
        this.fa.fgui.getVp().actualizar_ventanaConectados(this.amigos);
        this.fa.fgui.getVp().actualizar_ventanaDesconectados(this.desconectados);
    }
    
    @Override
    public void NotificaAmigos (InterfazUsuario amigo,ArrayList<String> id) throws RemoteException{
        this.fa.fgui.getVea().actualizaventana(id);
    }
}
