package br.com.luque.meurepresentante;

import java.io.Serializable;
import java.util.Date;

/**
 * Esta classe implementa o comportamento comum a entidades de dominio.
 *
 * @author Leandro Luque
 */
public class EntidadeDominio implements Serializable {

    private Long id;
    private Date criacao;
    private Date ultimaAtualizacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCriacao() {
        return criacao;
    }

    public void setCriacao(Date criacao) {
        this.criacao = criacao;
    }

    public Date getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(Date ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

}
