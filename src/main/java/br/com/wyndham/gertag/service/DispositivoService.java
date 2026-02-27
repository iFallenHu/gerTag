package br.com.wyndham.gertag.service;


import br.com.wyndham.gertag.domain.Dispositivo;
import br.com.wyndham.gertag.domain.DispositivoRepository;
import br.com.wyndham.gertag.domain.StatusDispositivo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DispositivoService {

    private final DispositivoRepository repository;

    public Dispositivo criar(Dispositivo dispositivo) {
        if (repository.existsByNome(dispositivo.getNome())) {
            throw new RuntimeException("Já existe um dispositivo com esse nome. ");
        }

        dispositivo.setStatus(StatusDispositivo.ATIVO);
        dispositivo.setCodigoTag(gerarCodigoTag());

        return repository.save(dispositivo);

    }

    private String gerarCodigoTag() {
        return "GT-" + UUID.randomUUID().toString().substring(0,8).toUpperCase();
    }

}
