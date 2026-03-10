package br.com.wyndham.gertag.dto;

import br.com.wyndham.gertag.domain.StatusDispositivo;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class DispositivoResponseDTO {

    private UUID id;
    private String nome;
    private String modelo;
    private Integer memoriaRam;
    private String sistemaOperacional;
    private Long patrimonio;
    private StatusDispositivo status;
    private String codigoTag;
}
