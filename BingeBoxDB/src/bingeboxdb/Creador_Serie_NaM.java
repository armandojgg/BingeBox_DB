/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bingeboxdb;

import bingeboxdb.Actors_NaM;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Armando
 */

// Clase Creador_Serie_NaM en la cual se le asigna unos atributos, unos métodos GET y SET y su relación.
@Entity
@Table(name = "creador_serie")
public class Creador_Serie_NaM implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "idcreador_serie")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Column(name = "genero")
    private String genero;
    
    
    // Relación 1:N con creaciones
    @OneToMany(mappedBy = "creador", cascade = CascadeType.ALL)
    private List<creacion_series> creaciones; 
    
    public Creador_Serie_NaM() {
        
    }
    
    public Creador_Serie_NaM(String nombre, String nacionalidad, String genero) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.genero = genero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<creacion_series> getCreaciones() {
        return creaciones;
    }

    public void setCreaciones(List<creacion_series> creaciones) {
        this.creaciones = creaciones;
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
        if (!(object instanceof Actors_NaM)) {
            return false;
        }
        Creador_Serie_NaM other = (Creador_Serie_NaM) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Creador_Serie_NaM{" + "id=" + id + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", genero=" + genero + ", creaciones=" + creaciones + '}';
    }


}
