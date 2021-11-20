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
    
    public FachadaGui(aplicacion.FachadaAplicacion fa) {
        this.fa = fa;
    }

    public VPrincipal getVp() {
        return vp;
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
    
    public void mostrarVprincipal(String nombre){
        vp = new VPrincipal(vp, true, fa, nombre);
        vp.setLocationRelativeTo(null);
        vp.setVisible(true);
        vp.actualizar_ventanaConectados(this.fa.getUser().getAmigos());
        vp.actualizar_ventanaDesconectados(this.fa.getUser().getDesconectados());
    }
    
    public void mostrarVEditar(String id){
        this.ve = new VEditar(this.vp, true, fa, id);
        ve.setLocationRelativeTo(null);
        ve.setVisible(true);
    } 

}
