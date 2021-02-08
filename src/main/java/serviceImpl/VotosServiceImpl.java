package serviceImpl;

import entities.Votos;
import org.springframework.stereotype.Service;
import repository.VotosRepository;
import service.VotosService;

import java.util.List;

@Service
public class VotosServiceImpl implements VotosService {

    private final VotosRepository votoRepository;

    public VotosServiceImpl(VotosRepository votoRepository) {
        this.votoRepository = votoRepository;
    }

    @Override
    public List<Votos> listAll() {
        return votoRepository.findAll();
    }

    @Override
    public Votos save(Votos voto) {
        return votoRepository.save(voto);
    }
}
