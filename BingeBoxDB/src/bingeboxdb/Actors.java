/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bingeboxdb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Armando
 */

@Table(name = "actors")

public class Actors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre_actor")
    private String nombre_actor;
    @Column(name = "nacionalidadActor")
    private String nacionalidadActor;
    @Column(name = "genero_actor")
    private String genero_actor;

    public Actors() {
        
    }
    
    public Actors(String nombre_actor, String nacionalidadActor, String genero_actor) {
        this.nombre_actor = nombre_actor;
        this.nacionalidadActor = nacionalidadActor;
        this.genero_actor = genero_actor;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getnombre_actor() {
        return nombre_actor;
    }

    public void setnombre_actor(String nombre_actor) {
        this.nombre_actor = nombre_actor;
    }

    public String getnacionalidadActor() {
        return nacionalidadActor;
    }

    public void setnacionalidadActor(String nacionalidadActor) {
        this.nacionalidadActor = nacionalidadActor;
    }

    public String getCustomernsumber() {
        return genero_actor;
    }

    public void setCustomernsumber(String genero_actor) {
        this.genero_actor = genero_actor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actors)) {
            return false;
        }
        Actors other = (Actors) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pruebahibernateant.Customer[ id=" + id + " ]";
    }
    
}
