package br.com.wyndham.gertag.controller;


import br.com.wyndham.gertag.domain.Dispositivo;
import br.com.wyndham.gertag.service.DispositivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dispositivos")
public class DispositivoController {

    private final DispositivoService service;

    @PostMapping
    public Dispositivo criar(@RequestBody Dispositivo dispositivo) {
        return service.criar(dispositivo);
    }

}
