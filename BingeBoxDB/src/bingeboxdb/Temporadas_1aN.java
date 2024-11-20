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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Armando
 */

// Clase Temporadas_1aN en la cual se le asigna unos atributos, unos métodos GET y SET y su relación.
@Entity
@Table(name = "temporadas")
public class Temporadas_1aN implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_temporada")
    private Integer id;
    @Column(name = "num_temporada")
    private Integer num_temporada;
    @Column(name = "año_estreno")
    private Integer año_estreno;
    @Column(name = "num_episodios")
    private Integer num_episodios;
    @Column(name = "series_id")
    private Integer series_id;
    
    @ManyToOne
    @JoinColumn(name = "series_id", insertable = false, updatable = false)
    private Series_1aN series;

    @OneToMany(mappedBy = "temporada", cascade = CascadeType.ALL)
    private List<Capitulos> capitulos;

    public Temporadas_1aN() {
        
    }
    
    public Temporadas_1aN(Integer num_temporada, Integer año_estreno, Integer num_episodios, Integer series_id) {
        this.num_temporada = num_temporada;
        this.año_estreno = año_estreno;
        this.num_episodios = num_episodios;
        this.series_id = series_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum_temporada() {
        return num_temporada;
    }

    public void setNum_temporada(Integer num_temporada) {
        this.num_temporada = num_temporada;
    }

    public Integer getAño_estreno() {
        return año_estreno;
    }

    public void setAño_estreno(Integer año_estreno) {
        this.año_estreno = año_estreno;
    }

    public Integer getNum_episodios() {
        return num_episodios;
    }

    public void setNum_episodios(Integer num_episodios) {
        this.num_episodios = num_episodios;
    }

    public Integer getSeries_id() {
        return series_id;
    }

    public void setSeries_id(Integer series_id) {
        this.series_id = series_id;
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
        Temporadas_1aN other = (Temporadas_1aN) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Temporadas_1aN{" + "id=" + id + ", num_temporada=" + num_temporada + ", a\u00f1o_estreno=" + año_estreno + ", num_episodios=" + num_episodios + ", series_id=" + series_id + ", series=" + series + ", capitulos=" + capitulos + '}';
    }
}
