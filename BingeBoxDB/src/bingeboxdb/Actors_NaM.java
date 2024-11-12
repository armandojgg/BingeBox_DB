/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bingeboxdb;

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
import javax.persistence.Table;

/**
 *
 * @author Armando
 */

// Clase Actors_NaM en la cual se le asigna unos atributos, unos métodos GET y SET y su relación.
@Entity
@Table(name = "actors")
public class Actors_NaM implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actor")
    private Integer id;
    @Column(name = "nombre_actor")
    private String nombre_actor;
    @Column(name = "nacionalidad_actor")
    private String nacionalidadActor;
    @Column(name = "genero_actor")
    private String genero_actor;

    // Relación N:M con Series
    @ManyToMany(mappedBy = "actors")
    private List<Series_1aN> series;

    @ManyToMany(mappedBy = "actors", cascade = CascadeType.ALL)
    private List<Peliculas_NaM> peliculas;

    public Actors_NaM() {

    }

    public Actors_NaM(String nombre_actor, String nacionalidad_actor, String genero_actor) {
        this.nombre_actor = nombre_actor;
        this.nacionalidadActor = nacionalidad_actor;
        this.genero_actor = genero_actor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_actor() {
        return nombre_actor;
    }

    public void setNombre_actor(String nombre_actor) {
        this.nombre_actor = nombre_actor;
    }

    public String getNacionalidadActor() {
        return nacionalidadActor;
    }

    public void setNacionalidadActor(String nacionalidadActor) {
        this.nacionalidadActor = nacionalidadActor;
    }

    public String getGenero_actor() {
        return genero_actor;
    }

    public void setGenero_actor(String genero_actor) {
        this.genero_actor = genero_actor;
    }

    public List<Series_1aN> getSeries() {
        return series;
    }

    public void setSeries(List<Series_1aN> series) {
        this.series = series;
    }

    public List<Peliculas_NaM> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Peliculas_NaM> peliculas) {
        this.peliculas = peliculas;
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
        Actors_NaM other = (Actors_NaM) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Actors_NaM{" + "id=" + id + ", nombre_actor=" + nombre_actor + ", nacionalidadActor=" + nacionalidadActor + ", genero_actor=" + genero_actor + ", series=" + series + ", peliculas=" + peliculas + '}';
    }
}
