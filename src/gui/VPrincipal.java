/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class VPrincipal extends javax.swing.JFrame {

    
    private aplicacion.FachadaAplicacion fa;
    private String id;
    private String chat;
    private aplicacion.InterfazUsuario usuariochat;
    /**
     * Creates new form VPrincipal
     */
    public VPrincipal(java.awt.Frame parent, boolean modal, aplicacion.FachadaAplicacion fa,String id) {
        initComponents();
        this.TNombre.setText("Hola: " + id);
        BChat.setEnabled(false);
        BAceptar.setEnabled(false);
        BRechazar.setEnabled(false);
        this.fa = fa;
        this.id = id;
        this.BEnviar.setEnabled(false);
        this.BChat.setEnabled(false);
        this.Chat.setEditable(false);
        this.Chat.setVisible(false);
        this.Mensajes.setVisible(false);
        this.BEnviar.setVisible(false);
    }
    
    public void actualizar_ventanaConectados(ArrayList<aplicacion.Usuario> amigos) {
        ModeloTablaConectados m = (ModeloTablaConectados) tablaconectados.getModel();
        ArrayList<String> aux = new ArrayList();
        
        for(aplicacion.Usuario user : amigos){
            aux.add(user.getId());
        }
        m.setFilas(aux);
    }
    
    public void actualizar_ventanaDesconectados(ArrayList<String> desconectados) {
        ModeloTablaDesconectados m = (ModeloTablaDesconectados) tabladesconectados.getModel();
        m.setFilas(desconectados);
    }
    
    public void actualizar_ventanaSolicitudAmistad(ArrayList<String> sa) {
        ModeloTablaAmistad m = (ModeloTablaAmistad) tablasolicitudes.getModel();
        m.setFilas(sa);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaconectados = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabladesconectados = new javax.swing.JTable();
        TNombre = new javax.swing.JLabel();
        BEditarperf = new javax.swing.JButton();
        BSalir = new javax.swing.JButton();
        BChat = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablasolicitudes = new javax.swing.JTable();
        BAceptar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        BRechazar = new javax.swing.JButton();
        EliminaramigoB = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        Chat = new javax.swing.JTextArea();
        BEnviar = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        Mensajes = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaconectados.setModel(new ModeloTablaConectados());
        tablaconectados.setName("Amigos conectados"); // NOI18N
        tablaconectados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaconectadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaconectados);

        tabladesconectados.setModel(new ModeloTablaDesconectados());
        tabladesconectados.setName("Amigos desconectados"); // NOI18N
        jScrollPane2.setViewportView(tabladesconectados);

        TNombre.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        TNombre.setText("Hola:");

        BEditarperf.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BEditarperf.setText("Editar perfil");
        BEditarperf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEditarperfActionPerformed(evt);
            }
        });

        BSalir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BSalir.setText("Exit");
        BSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSalirActionPerformed(evt);
            }
        });

        BChat.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BChat.setText("Chatear");
        BChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BChatActionPerformed(evt);
            }
        });

        tablasolicitudes.setModel(new ModeloTablaAmistad());
        tablasolicitudes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablasolicitudesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablasolicitudes);

        BAceptar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BAceptar.setText("Aceptar");
        BAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAceptarActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setText("Solicitar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        BRechazar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BRechazar.setText("Rechazar");
        BRechazar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRechazarActionPerformed(evt);
            }
        });

        EliminaramigoB.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        EliminaramigoB.setText("Eliminar Amigo");
        EliminaramigoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminaramigoBActionPerformed(evt);
            }
        });

        Chat.setColumns(20);
        Chat.setRows(5);
        jScrollPane4.setViewportView(Chat);

        BEnviar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BEnviar.setText("Enviar");
        BEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEnviarActionPerformed(evt);
            }
        });

        Mensajes.setColumns(20);
        Mensajes.setRows(5);
        jScrollPane6.setViewportView(Mensajes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BEditarperf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BSalir)
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(BChat)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(BRechazar)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                            .addComponent(BAceptar))
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(EliminaramigoB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 21, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BEditarperf)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TNombre)
                        .addComponent(BSalir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BChat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BAceptar)
                            .addComponent(BRechazar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(EliminaramigoB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(BEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))
                        .addGap(16, 16, 16))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSalirActionPerformed
        try {
            // TODO add your handling code here:
            this.fa.getServer().LogOut(this.fa.getUser(), id);
        } catch (RemoteException ex) {
            Logger.getLogger(VPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }//GEN-LAST:event_BSalirActionPerformed

    private void BEditarperfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEditarperfActionPerformed
        // TODO add your handling code here:
        this.fa.mostrarVEditar(id);
    }//GEN-LAST:event_BEditarperfActionPerformed

    private void tablaconectadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaconectadosMouseClicked
        // TODO add your handling code here:
        BChat.setEnabled(true);
    }//GEN-LAST:event_tablaconectadosMouseClicked

    private void tablasolicitudesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablasolicitudesMouseClicked
        // TODO add your handling code here:
        BAceptar.setEnabled(true);
        BRechazar.setEnabled(true);
    }//GEN-LAST:event_tablasolicitudesMouseClicked

    private void BAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAceptarActionPerformed
        // TODO add your handling code here:
        ModeloTablaAmistad m = (ModeloTablaAmistad) tablasolicitudes.getModel();
        try {
            this.fa.getServer().AnadirAmigo(this.fa.getUser(), id, m.obtenerAmistades(tablasolicitudes.getSelectedRow()));
        } catch (RemoteException ex) {
            Logger.getLogger(VPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.actualizar_ventanaDesconectados(this.fa.getUser().getDesconectados());
        BAceptar.setEnabled(false);
        BRechazar.setEnabled(false);
    }//GEN-LAST:event_BAceptarActionPerformed

    private void BRechazarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRechazarActionPerformed
        // TODO add your handling code here:
        ModeloTablaAmistad m = (ModeloTablaAmistad) tablasolicitudes.getModel();
        try {
            this.fa.getServer().EliminarAmigo(this.fa.getUser(), id, m.obtenerAmistades(tablasolicitudes.getSelectedRow()));
        } catch (RemoteException ex) {
            Logger.getLogger(VPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        BAceptar.setEnabled(false);
        BRechazar.setEnabled(false);
    }//GEN-LAST:event_BRechazarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.fa.mostrarVVusuarios(this.id);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void EliminaramigoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminaramigoBActionPerformed
        // TODO add your handling code here:
        this.fa.mostrarVEliminarAmigo(this.id);
    }//GEN-LAST:event_EliminaramigoBActionPerformed

    private void BEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEnviarActionPerformed
        
        if(!this.Mensajes.equals("")){
            this.Chat.append(this.id + ":" + this.Mensajes.getText() + "\n");
            for(aplicacion.Usuario amigo: this.fa.getUser().getAmigos()){
                if(amigo.getId().equals(this.chat) || amigo.getInterfaz().equals(this.usuariochat)){
                    try {
                        this.usuariochat=amigo.getInterfaz();
                        this.usuariochat.RecibeMensajes(this.fa.getUser(), this.id + ":" + this.Mensajes.getText() + "\n");
                    } catch (RemoteException ex) {
                        Logger.getLogger(VPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    this.Mensajes.setText("");
                    break;
                }
            }
        }
    }//GEN-LAST:event_BEnviarActionPerformed

    
    public void actualizarChat(aplicacion.InterfazUsuario envia,String mensaje){
        
        if(!envia.equals(this.usuariochat)){
            this.BEnviar.setEnabled(true);
            this.BChat.setEnabled(false);
            this.Mensajes.setEnabled(true);

            this.Chat.setVisible(true);
            this.Mensajes.setVisible(true);
            this.BEnviar.setVisible(true);
            this.Chat.selectAll();
            this.Chat.replaceSelection("");
        }
        this.Chat.append(mensaje);
        this.usuariochat = envia;
    }
    
    
    private void BChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BChatActionPerformed
        ModeloTablaConectados m = (ModeloTablaConectados) this.tablaconectados.getModel();        
        this.BEnviar.setEnabled(true);
        this.BChat.setEnabled(false);
        
        this.Chat.setVisible(true);
        this.Mensajes.setVisible(true);
        this.BEnviar.setVisible(true);
        
        this.Chat.selectAll();
        this.Chat.replaceSelection("");
        this.chat=m.obtenerUsuarios(tablaconectados.getSelectedRow());
        for(aplicacion.Usuario amigo: this.fa.getUser().getAmigos()){
            if(amigo.getId().equals(this.chat)){
                this.usuariochat=amigo.getInterfaz();
                break;
            }
        }
        
    }//GEN-LAST:event_BChatActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAceptar;
    private javax.swing.JButton BChat;
    private javax.swing.JButton BEditarperf;
    private javax.swing.JButton BEnviar;
    private javax.swing.JButton BRechazar;
    private javax.swing.JButton BSalir;
    private javax.swing.JTextArea Chat;
    private javax.swing.JButton EliminaramigoB;
    private javax.swing.JTextArea Mensajes;
    private javax.swing.JLabel TNombre;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tablaconectados;
    private javax.swing.JTable tabladesconectados;
    private javax.swing.JTable tablasolicitudes;
    // End of variables declaration//GEN-END:variables
}
