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
@Entity
@Table(name = "participacion_actor_serie")
public class Participacion_Actor_Serie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ManyToOne
    @JoinColumn(name = "series_id")
    private Series_1aN serie;

    @Id
    @ManyToOne
    @JoinColumn(name = "actors_id")
    private Actors_NaM actors;

    @Column(name = "papel_realiza")
    private String papel_realiza;
    
    public Participacion_Actor_Serie() {

    }
    
    public Participacion_Actor_Serie(Series_1aN serie, Actors_NaM actors, String papel_realiza) {
        this.serie = serie;
        this.actors = actors;
        this.papel_realiza = papel_realiza;
    }

    public Series_1aN getSerie() {
        return serie;
    }

    public void setSerie(Series_1aN serie) {
        this.serie = serie;
    }

    public Actors_NaM getActors() {
        return actors;
    }

    public void setActors(Actors_NaM actors) {
        this.actors = actors;
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
        hash += (serie != null ? serie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actors_NaM)) {
            return false;
        }
        Participacion_Actor_Serie other = (Participacion_Actor_Serie) object;
        if ((this.serie == null && other.serie != null) || (this.serie != null && !this.serie.equals(other.serie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Participacion_Actor_Serie{" + "serie=" + serie + ", actors=" + actors + ", papel_realiza=" + papel_realiza + '}';
    }

}
