package service;

import entities.Votos;

import java.util.List;

public interface VotosService {

    List<Votos> listAll();

    Votos save(Votos voto);
}
