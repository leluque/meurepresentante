package br.com.luque.meurepresentante;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Esta interface define um objeto de acesso aos dados de cidadaos.
 *
 * @author Leandro Luque
 */
public interface CidadaoDAO extends JpaRepository<Cidadao, Long> {

}
