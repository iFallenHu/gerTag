package br.com.wyndham.gertag.dto;

import lombok.Data;

@Data
public class DispositivoRequestDTO {

    private String nome;
    private String modelo;
    private Integer memoriaRam;
    private String sistemaOperacional;

}
