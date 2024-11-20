/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bingeboxdb;

import bingeboxdb.Actors_NaM;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Armando
 */

// Clase Capitulos en la cual se le asigna unos atributos, unos métodos GET y SET y su relación.
@Entity
@Table(name = "capitulos")
public class Capitulos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_capitulo")
    private Integer id;
    @Column(name = "titulo_capitulo")
    private String titulo_capitulo;
    @Column(name = "numero_episodio")
    private Integer numero_episodio;
    @Column(name = "duracion_episodio")
    private String duracion_episodio;
    @Column(name = "director_episodio")
    private String director_episodio;
    @Column(name = "guionista_episodio")
    private String guionista_episodio;
    @Column(name = "temporada_id", insertable = false, updatable = false)
    private Integer temporada_id;
    
    @ManyToOne
    @JoinColumn(name = "temporada_id")
    private Temporadas_1aN temporada;
    public Capitulos() {
        
    }
    
    public Capitulos(String titulo_capitulo, Integer numero_episodio, String duracion_episodio, String director_episodio, String guionista_episodio, Integer temporada_id) {
        this.titulo_capitulo = titulo_capitulo;
        this.numero_episodio = numero_episodio;
        this.duracion_episodio = duracion_episodio;
        this.director_episodio = director_episodio;
        this.guionista_episodio = guionista_episodio;
        this.temporada_id = temporada_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo_capitulo() {
        return titulo_capitulo;
    }

    public void setTitulo_capitulo(String titulo_capitulo) {
        this.titulo_capitulo = titulo_capitulo;
    }

    public Integer getNumero_episodio() {
        return numero_episodio;
    }

    public void setNumero_episodio(Integer numero_episodio) {
        this.numero_episodio = numero_episodio;
    }

    public String getDuracion_episodio() {
        return duracion_episodio;
    }

    public void setDuracion_episodio(String duracion_episodio) {
        this.duracion_episodio = duracion_episodio;
    }

    public String getDirector_episodio() {
        return director_episodio;
    }

    public void setDirector_episodio(String director_episodio) {
        this.director_episodio = director_episodio;
    }

    public String getGuionista_episodio() {
        return guionista_episodio;
    }

    public void setGuionista_episodio(String guionista_episodio) {
        this.guionista_episodio = guionista_episodio;
    }

    public Integer getTemporada_id() {
        return temporada_id;
    }

    public void setTemporada_id(Integer temporada_id) {
        this.temporada_id = temporada_id;
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
        Capitulos other = (Capitulos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Capitulos{" + "id=" + id + ", titulo_capitulo=" + titulo_capitulo + ", numero_episodio=" + numero_episodio + ", duracion_episodio=" + duracion_episodio + ", director_episodio=" + director_episodio + ", guionista_episodio=" + guionista_episodio + ", temporada_id=" + temporada_id + ", temporada=" + temporada + '}';
    }
    
}
