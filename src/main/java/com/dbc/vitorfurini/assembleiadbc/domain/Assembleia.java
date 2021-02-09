package com.dbc.vitorfurini.assembleiadbc.domain;

import com.dbc.vitorfurini.assembleiadbc.enums.StatusAssembleia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Assembleia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String descricaoAssembleia;

    @Column(nullable = false)
    private String dataCriacao;

    @Column(nullable = false)
    private Long duracao;

    @ManyToOne
    private Pauta pauta;

    @OneToMany(mappedBy = "assembleia", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Votos> voto;

    @Column
    private StatusAssembleia statusAssembleia;

    public Assembleia(Long id) {
        this.id = id;
    }

    public Long obterIdPauta() {
        if (pauta == null) {
            return null;
        }
        return pauta.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescricaoAssembleia() {
        return descricaoAssembleia;
    }

    public void setDescricaoAssembleia(String descricaoAssembleia) {
        this.descricaoAssembleia = descricaoAssembleia;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
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

    public List<Votos> getVoto() {
        return voto;
    }

    public void setVoto(List<Votos> voto) {
        this.voto = voto;
    }

    public StatusAssembleia getStatusAssembleia() {
        return statusAssembleia;
    }

    public void setStatusAssembleia(StatusAssembleia statusAssembleia) {
        this.statusAssembleia = statusAssembleia;
    }
}
