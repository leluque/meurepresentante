package br.com.luque.meurepresentante;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Esta interface define um objeto de acesso aos dados de partidos.
 *
 * @author Leandro Luque
 */
public interface PartidoDAO extends JpaRepository<Partido, Long> {

}
