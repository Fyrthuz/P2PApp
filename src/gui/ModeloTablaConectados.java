/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Diego
 */
public class ModeloTablaConectados extends AbstractTableModel{
    private java.util.List<String> usuarios;

    public ModeloTablaConectados() {
        this.usuarios = new java.util.ArrayList<String>();
    }

    public int getColumnCount() {
        return 1;
    }

    public int getRowCount() {
        return usuarios.size();
    }

    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "Conectados";
                break;
        }
        return nombre;
    }

    public Class getColumnClass(int col) {
        Class clase = null;

        switch (col) {
            case 0:
                clase = java.lang.String.class;
                break;
        }
        return clase;
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public Object getValueAt(int row, int col) {
        Object resultado = null;

        switch (col) {
            case 0:
                resultado = usuarios.get(row);
                break;
        }
        return resultado;
    }
    
    public void setFilas(java.util.List<String> usuarios) {
        this.usuarios = usuarios;
        fireTableDataChanged();
    }

    public String obtenerUsuarios(int i) {
        return this.usuarios.get(i);
    }
}
