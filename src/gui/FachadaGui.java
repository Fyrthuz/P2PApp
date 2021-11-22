/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.rmi.RemoteException;

/**
 *
 * @author Diego
 */
public class FachadaGui {
    aplicacion.FachadaAplicacion fa;
    VPrincipal vp;
    VAutentificacion va;
    VRegistro vr;
    VEditar ve;
    VVerusuarios vv;
    VEliminarAmigo vea;

    public VEliminarAmigo getVea() {
        return vea;
    }
    
    public FachadaGui(aplicacion.FachadaAplicacion fa) {
        this.fa = fa;
    }

    public VPrincipal getVp() {
        return vp;
    }

    public VVerusuarios getVv() {
        return vv;
    }
    
    public void setVp(VPrincipal vp) {
        this.vp = vp;
    }
    
    public void iniciaVista() {
        
        va = new VAutentificacion(vp, true, fa);
        //vp.setLocationRelativeTo(null);
        va.setLocationRelativeTo(null);
        //vp.setVisible(true);
        va.setVisible(true);
    }
    
    public void mostrarRegistro(aplicacion.InterfazServidor server){
        vr = new VRegistro(vp, true, fa, server);
        vr.setLocationRelativeTo(null);
        vr.setVisible(true);
    }
    
    public void mostrarVprincipal(String nombre) throws RemoteException{
        vp = new VPrincipal(vp, true, fa, nombre);
        vp.setLocationRelativeTo(null);
        vp.setVisible(true);
        vp.actualizar_ventanaConectados(this.fa.getUser().getAmigos());
        vp.actualizar_ventanaDesconectados(this.fa.getUser().getDesconectados());
        vp.actualizar_ventanaSolicitudAmistad(this.fa.getUser().getSa());
    }
    
    public void mostrarVEditar(String id){
        this.ve = new VEditar(this.vp, true, fa, id);
        ve.setLocationRelativeTo(null);
        ve.setVisible(true);
    } 
    
    public void mostrarVVusuarios(String id){
        this.vv = new VVerusuarios(this.vp, true, fa, id);
        vv.setLocationRelativeTo(null);
        vv.setVisible(true);
    }
    
    public void mostrarVEliminarAmigo(String id){
        this.vea = new VEliminarAmigo(this.vp, true, fa, id);
        vea.setLocationRelativeTo(null);
        vea.setVisible(true);
    }
}
