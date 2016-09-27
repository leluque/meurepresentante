package br.com.luque.meurepresentante;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Esta classe implementa partidos politicos.
 *
 * @author Leandro Luque
 */
@Entity
@Table(name = "partido")
public class Partido extends EntidadeDominio {

    @Column(name = "sigla")
    private String sigla;
    @Column(name = "nome")
    private String nome;

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
