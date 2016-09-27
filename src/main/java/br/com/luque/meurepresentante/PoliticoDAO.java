package br.com.luque.meurepresentante;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Esta interface define um objeto de acesso aos dados de politicos.
 *
 * @author Leandro Luque
 */
public interface PoliticoDAO extends JpaRepository<Politico, Long> {

}
