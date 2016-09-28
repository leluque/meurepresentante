package br.com.luque.meurepresentante.persistencia;

import br.com.luque.meurepresentante.dominio.Cidadao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Esta interface define um objeto de acesso aos dados de cidadaos.
 *
 * @author Leandro Luque
 */
public interface CidadaoRepository extends JpaRepository<Cidadao, Long> {

}
