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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Armando
 */
// Clase Series_1aN en la cual se le asigna unos atributos, unos métodos GET y SET y su relación.
@Entity
@Table(name = "series")
public class Series_1aN implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_serie")
    private Integer id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "genero")
    private String genero;
    @Column(name = "comienzo_serie")
    private String comienzo_serie;
    @Column(name = "final_serie")
    private String final_serie;
    @Column(name = "pais_serie")
    private String pais_serie;
    @Column(name = "num_temporadas")
    private Integer num_temporadas;
    @Column(name = "num_capitulos")
    private Integer num_capitulos;

    // Relacion 1:N con temporadas
    @OneToMany(mappedBy = "series", cascade = CascadeType.ALL)
    private List<Temporadas_1aN> temporadas;

    // Relacion N:M con actores
    @ManyToMany
    @JoinTable(
            name = "participacion_actor_serie",
            joinColumns = @JoinColumn(name = "series_id"),
            inverseJoinColumns = @JoinColumn(name = "actors_id")
    )
    private List<Actors_NaM> actors;

    // Relacion N:M con creadores
    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL)
    private List<creacion_series> creaciones; 

    public Series_1aN() {

    }

    public Series_1aN(String titulo, String genero, String comienzo_serie, String final_serie, String pais_serie, Integer num_temporadas, Integer num_capitulos) {
        this.titulo = titulo;
        this.genero = genero;
        this.comienzo_serie = comienzo_serie;
        this.final_serie = final_serie;
        this.pais_serie = pais_serie;
        this.num_temporadas = num_temporadas;
        this.num_capitulos = num_capitulos;
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

    public String getComienzo_serie() {
        return comienzo_serie;
    }

    public void setComienzo_serie(String comienzo_serie) {
        this.comienzo_serie = comienzo_serie;
    }

    public String getFinal_serie() {
        return final_serie;
    }

    public void setFinal_serie(String final_serie) {
        this.final_serie = final_serie;
    }

    public String getPais_serie() {
        return pais_serie;
    }

    public void setPais_serie(String pais_serie) {
        this.pais_serie = pais_serie;
    }

    public Integer getNum_temporadas() {
        return num_temporadas;
    }

    public void setNum_temporadas(Integer num_temporadas) {
        this.num_temporadas = num_temporadas;
    }

    public Integer getNum_capitulos() {
        return num_capitulos;
    }

    public void setNum_capitulos(Integer num_capitulos) {
        this.num_capitulos = num_capitulos;
    }

    public List<Temporadas_1aN> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(List<Temporadas_1aN> temporadas) {
        this.temporadas = temporadas;
    }

    public List<Actors_NaM> getActors() {
        return actors;
    }

    public void setActors(List<Actors_NaM> actors) {
        this.actors = actors;
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
        Series_1aN other = (Series_1aN) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Series_1aN{" + "id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", comienzo_serie=" + comienzo_serie + ", final_serie=" + final_serie + ", pais_serie=" + pais_serie + ", num_temporadas=" + num_temporadas + ", num_capitulos=" + num_capitulos + ", temporadas=" + temporadas + ", actors=" + actors + ", creaciones=" + creaciones + '}';
    }

}
