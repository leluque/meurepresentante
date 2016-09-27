package br.com.luque.meurepresentante;

/**
 * Esta classe implementa partidos politicos.
 *
 * @author Leandro Luque
 */
public class Partido extends EntidadeDominio {

    private String sigla;
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
