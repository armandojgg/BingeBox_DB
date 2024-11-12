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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Armando
 */
// Clase creacion_series en la cual se le asigna unos atributos, unos métodos GET y SET y su relación.
@Entity
@Table(name = "creacion_series")
public class creacion_series implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    // Relación muchos a uno con Serie
    @ManyToOne
    @JoinColumn(name = "series_id")
    private Series_1aN serie;
    
    // Relación muchos a uno con Creador
    @ManyToOne
    @JoinColumn(name = "creador_id")
    private Creador_Serie_NaM creador;

    public creacion_series() {

    }

    public creacion_series(Series_1aN serie, Creador_Serie_NaM creador) {
        this.serie = serie;
        this.creador = creador;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Series_1aN getSerie() {
        return serie;
    }

    public void setSerie(Series_1aN serie) {
        this.serie = serie;
    }

    public Creador_Serie_NaM getCreador() {
        return creador;
    }

    public void setCreador(Creador_Serie_NaM creador) {
        this.creador = creador;
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
        creacion_series other = (creacion_series) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "creacion_series{" + "id=" + id + ", serie=" + serie + ", creador=" + creador + '}';
    }


}
