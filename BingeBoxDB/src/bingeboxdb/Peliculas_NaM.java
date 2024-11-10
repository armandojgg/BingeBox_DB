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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Armando
 */
@Entity
@Table(name = "peliculas")
public class Peliculas_NaM implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pelicula")
    private Integer id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "genero")
    private String genero;
    @Column(name = "duracion")
    private String duracion;
    @Column(name = "rating")
    private String rating;
    @Column(name = "pais_pelicula")
    private String pais_pelicula;
    @Column(name = "presupuesto")
    private Integer presupuesto;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "direccion_pelicula",
            joinColumns = @JoinColumn(name = "id_pelicula"),
            inverseJoinColumns = @JoinColumn(name = "id_director")
    )
    private List<Directors_NaM> directors;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "participacion_actor_pelicula",
            joinColumns = @JoinColumn(name = "id_pelicula"),
            inverseJoinColumns = @JoinColumn(name = "id_actor")
    )
    private List<Actors_NaM> actors;

    public Peliculas_NaM() {

    }

    public Peliculas_NaM(String titulo, String genero, String duracion, String rating, String pais_pelicula, Integer presupuesto) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.rating = rating;
        this.pais_pelicula = pais_pelicula;
        this.presupuesto = presupuesto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPais_pelicula() {
        return pais_pelicula;
    }

    public void setPais_pelicula(String pais_pelicula) {
        this.pais_pelicula = pais_pelicula;
    }

    public Integer getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Integer presupuesto) {
        this.presupuesto = presupuesto;
    }

    public List<Directors_NaM> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Directors_NaM> directors) {
        this.directors = directors;
    }

    public List<Actors_NaM> getActors() {
        return actors;
    }

    public void setActors(List<Actors_NaM> actors) {
        this.actors = actors;
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
        Peliculas_NaM other = (Peliculas_NaM) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Peliculas_NaM{" + "id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", duracion=" + duracion + ", rating=" + rating + ", pais_pelicula=" + pais_pelicula + ", presupuesto=" + presupuesto + ", directors=" + directors + ", actors=" + actors + '}';
    }

}
