package br.com.wyndham.gertag.controller;


import br.com.wyndham.gertag.dto.DispositivoRequestDTO;
import br.com.wyndham.gertag.dto.DispositivoResponseDTO;
import br.com.wyndham.gertag.service.DispositivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dispositivos")
public class DispositivoController {

    private final DispositivoService service;

    @PostMapping
    public DispositivoResponseDTO criar(@RequestBody DispositivoRequestDTO dto) {
        return service.criar(dto);
    }

    @GetMapping
    public List<DispositivoResponseDTO> listar(){
        return service.listar();
    }


}
