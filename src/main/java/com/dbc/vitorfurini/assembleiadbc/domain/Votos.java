package com.dbc.vitorfurini.assembleiadbc.domain;

import com.dbc.vitorfurini.assembleiadbc.enums.TipoVoto;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Votos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private TipoVoto tipoVoto;

    @ManyToOne
    private Assembleia assembleia;

    @ManyToOne
    private Associado associado;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public TipoVoto getTipoVoto() {
        return tipoVoto;
    }

    public void setTipoVoto(TipoVoto tipoVoto) {
        this.tipoVoto = tipoVoto;
    }

    public Assembleia getAssembleia() {
        return assembleia;
    }

    public void setAssembleia(Assembleia assembleia) {
        this.assembleia = assembleia;
    }

    public Associado getAssociado() {
        return associado;
    }

    public void setAssociado(Associado associado) {
        this.associado = associado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Votos votos = (Votos) o;
        return Objects.equals(id, votos.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Votos{"
                + "id=" + id
                + ", tipoVoto='" + tipoVoto + '\''
                + ", assembleia=" + assembleia
                + '}';
    }
}
