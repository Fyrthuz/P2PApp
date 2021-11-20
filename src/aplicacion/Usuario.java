/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.util.Objects;

/**
 *
 * @author PC
 */
public class Usuario {
    
    private String id;
    private InterfazUsuario interfaz;

    public Usuario(String id, InterfazUsuario interfaz) {
        this.id = id;
        this.interfaz = interfaz;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public InterfazUsuario getInterfaz() {
        return interfaz;
    }

    public void setInterfaz(InterfazUsuario interfaz) {
        this.interfaz = interfaz;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
