package br.com.luque.meurepresentante.persistencia;

import br.com.luque.meurepresentante.dominio.Politico;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Esta interface define um objeto de acesso aos dados de politicos.
 *
 * @author Leandro Luque
 */
@Component
public interface PoliticoRepository extends JpaRepository<Politico, Long> {

    Politico findByNome(String nome);
    
    List<Politico> findByMunicipioAndEstado(String municipio, String estado);
    
}
