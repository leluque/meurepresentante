package br.com.luque.meurepresentante;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Esta interface define um objeto de acesso aos dados de projetos.
 *
 * @author Leandro Luque
 */
public interface ProjetoDAO extends JpaRepository<Projeto, Long> {

}
