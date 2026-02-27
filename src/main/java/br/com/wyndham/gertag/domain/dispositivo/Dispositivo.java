package br.com.wyndham.gertag.domain.dispositivo;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "dispositivos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String nome; // EX: TI01

    private String modelo; // Desktop Dell

    private Integer memoriaRam; // 12

    private String sistemaOperacional; // Linux

    @Enumerated(EnumType.STRING)
    private StatusDispositivo status;

    private String observacao;

    @Column(unique = true)
    private String codigoTag;



}
