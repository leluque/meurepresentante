package br.com.luque.meurepresentante.persistencia;

import br.com.luque.meurepresentante.dominio.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Esta interface define um objeto de acesso aos dados de projetos.
 *
 * @author Leandro Luque
 */
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

}
