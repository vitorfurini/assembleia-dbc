package com.dbc.vitorfurini.assembleiadbc.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Associado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String cpf;

    @OneToMany(mappedBy = "associado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Votos> votos;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Votos> getVotos() {
        return votos;
    }

    public void setVotos(List<Votos> votos) {
        this.votos = votos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Associado associado = (Associado) o;
        return Objects.equals(id, associado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Associado{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", cpf='" + cpf + '\''
                + ", votos=" + votos
                + '}';
    }
}
