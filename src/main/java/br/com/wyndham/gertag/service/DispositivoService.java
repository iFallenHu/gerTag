package br.com.wyndham.gertag.service;


import br.com.wyndham.gertag.domain.Dispositivo;
import br.com.wyndham.gertag.domain.DispositivoRepository;
import br.com.wyndham.gertag.domain.StatusDispositivo;
import br.com.wyndham.gertag.dto.DispositivoRequestDTO;
import br.com.wyndham.gertag.dto.DispositivoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DispositivoService {

    private final DispositivoRepository repository;

    public DispositivoResponseDTO criar(DispositivoRequestDTO dto) {
        if (repository.existsByNome(dto.getNome())) {
            throw new RuntimeException("Já existe um dispositivo com esse nome. ");
        }
        Long patrimonio = gerarPatrimonio();

       Dispositivo dispositivo = Dispositivo.builder()
               .nome(dto.getNome())
               .modelo(dto.getModelo())
               .memoriaRam(dto.getMemoriaRam())
               .sistemaOperacional(dto.getSistemaOperacional())
               .patrimonio(patrimonio)
               .status(StatusDispositivo.ATIVO)
               .codigoTag(gerarCodigoTag(patrimonio))
               .build();


        Dispositivo salvo = repository.save(dispositivo);

        return DispositivoResponseDTO.builder()
                .id(salvo.getId())
                .nome(salvo.getNome())
                .modelo(salvo.getModelo())
                .memoriaRam(salvo.getMemoriaRam())
                .sistemaOperacional(salvo.getSistemaOperacional())
                .status(salvo.getStatus())
                .codigoTag(salvo.getCodigoTag())
                .build();

    }
    public Long gerarPatrimonio() {

        Long ultimo = repository.buscarUltimoPatrimonio();

        if (ultimo == null) {
            return 1L;
        }

        return ultimo + 1;
    }

    private String gerarCodigoTag(Long patrimonio) {
        return String.format("GT-%04d", patrimonio);
    }

    public List<DispositivoResponseDTO> listar(){

        return repository.findAll()
                .stream()
                .map(dispositivo -> DispositivoResponseDTO.builder()
                        .id(dispositivo.getId())
                        .nome(dispositivo.getNome())
                        .modelo(dispositivo.getModelo())
                        .memoriaRam(dispositivo.getMemoriaRam())
                        .sistemaOperacional(dispositivo.getSistemaOperacional())
                        .patrimonio(dispositivo.getPatrimonio())
                        .status(dispositivo.getStatus())
                        .codigoTag(dispositivo.getCodigoTag())
                        .build())
                .toList();
    }

}
