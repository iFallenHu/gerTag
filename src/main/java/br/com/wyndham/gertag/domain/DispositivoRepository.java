package br.com.wyndham.gertag.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface DispositivoRepository extends JpaRepository<Dispositivo, UUID> {

    boolean existsByNome(String nome);

    boolean existsByCodigoTag(String codigoTag);

    Optional<Dispositivo> findTopByOrderByPatrimonioDesc();

    @Query("SELECT MAX(d.patrimonio) FROM Dispositivo d")
    Long buscarUltimoPatrimonio();

}
