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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Armando
 */

@Entity
@Table(name = "direccion_pelicula")
public class Direccion_Pelicula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "peliculas_id_pelicula")
    private Peliculas_NaM pelicula;

    @ManyToOne
    @JoinColumn(name = "directors_id_director")
    private Directors_NaM director;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "direccion_pelicula",
        joinColumns = @JoinColumn(name = "id_director"),
        inverseJoinColumns = @JoinColumn(name = "id_pelicula")
    )
    private List<Peliculas_NaM> peliculas;

    public Direccion_Pelicula() {
        
    }
    
    public Direccion_Pelicula(Peliculas_NaM pelicula, Directors_NaM director) {
        this.pelicula = pelicula;
        this.director = director;
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

    public Directors_NaM getDirector() {
        return director;
    }

    public void setDirector(Directors_NaM director) {
        this.director = director;
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
        Direccion_Pelicula other = (Direccion_Pelicula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Direccion_Pelicula{" + "id=" + id + ", pelicula=" + pelicula + ", director=" + director + ", peliculas=" + peliculas + '}';
    }
    
}
