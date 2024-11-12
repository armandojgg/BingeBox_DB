/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bingeboxdb;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
// Clase Participacion_Actor_Pelicula en la cual se le asigna unos atributos, unos métodos GET y SET y su relación.
@Entity
@Table(name = "participacion_actor_pelicula")
public class Participacion_Actor_Pelicula implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "peliculas_id")
    private Peliculas_NaM pelicula;

    @ManyToOne
    @JoinColumn(name = "actors_id")
    private Actors_NaM actor;

    @Column(name = "papel_realiza")
    private String papel_realiza;

    public Participacion_Actor_Pelicula() {

    }

    public Participacion_Actor_Pelicula(Peliculas_NaM pelicula, Actors_NaM actor, String papel_realiza) {
        this.pelicula = pelicula;
        this.actor = actor;
        this.papel_realiza = papel_realiza;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Peliculas_NaM getPelicula() {
        return pelicula;
    }

    public void setPelicula(Peliculas_NaM pelicula) {
        this.pelicula = pelicula;
    }

    public Actors_NaM getActor() {
        return actor;
    }

    public void setActor(Actors_NaM actor) {
        this.actor = actor;
    }

    public String getPapel_realiza() {
        return papel_realiza;
    }

    public void setPapel_realiza(String papel_realiza) {
        this.papel_realiza = papel_realiza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pelicula != null ? pelicula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actors_NaM)) {
            return false;
        }
        Participacion_Actor_Pelicula other = (Participacion_Actor_Pelicula) object;
        if ((this.pelicula == null && other.pelicula != null) || (this.pelicula != null && !this.pelicula.equals(other.pelicula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Participacion_Actor_Pelicula{" + "id=" + id + ", pelicula=" + pelicula + ", actor=" + actor + ", papel_realiza=" + papel_realiza + '}';
    }

}
