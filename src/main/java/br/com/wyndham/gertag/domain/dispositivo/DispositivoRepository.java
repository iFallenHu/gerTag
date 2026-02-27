package br.com.wyndham.gertag.domain.dispositivo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface DispositivoRepository extends JpaRepository<Dispositivo, UUID> {

    boolean existsByNome(String nome);

    boolean existsByCodigoTag(String codigoTag);


}
