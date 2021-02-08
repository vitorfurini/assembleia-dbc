package com.dbc.vitorfurini.assembleiadbc.domain;

import com.dbc.vitorfurini.assembleiadbc.enums.StatusAssembleia;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

@Entity
public class Assembleia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(nullable = false)
    private Long duracao;

    @ManyToOne
    private Pauta pauta;

    @Column
    private StatusAssembleia statusAssembleia;

    public Assembleia() {
        /* construtor vazio */
    }

    public Assembleia(Long id) {
        this.id = id;
    }

    public Long obterIdPauta() {
        if (pauta == null) {
            return null;
        }
        return pauta.getId();
    }

    @PrePersist
    public void prePersist() {
        if (data == null) {
            data = LocalDateTime.now();
        }

        if (duracao <= 0L) {
            duracao = 1L;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Long getDuracao() {
        return duracao;
    }

    public void setDuracao(Long duracao) {
        this.duracao = duracao;
    }

    public Pauta getPauta() {
        return pauta;
    }

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusAssembleia getStatusAssembleia() {
        return statusAssembleia;
    }

    public void setStatusAssembleia(StatusAssembleia statusAssembleia) {
        this.statusAssembleia = statusAssembleia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assembleia that = (Assembleia) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Assembleia{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", descricao='" + descricao + '\''
                + ", data=" + data
                + ", duracao=" + duracao
                + ", pauta=" + pauta
                + ", statusAssembleia=" + statusAssembleia
                + '}';
    }
}
