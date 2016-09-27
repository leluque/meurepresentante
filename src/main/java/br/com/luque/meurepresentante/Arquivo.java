package br.com.luque.meurepresentante;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Esta classe implementa arquivos.
 *
 * @author Leandro Luque
 */
@MappedSuperclass
public abstract class Arquivo extends EntidadeDominio {

    @Column(name = "tamanho")
    private long tamanho;
    @Column(name = "nome_original")
    private String nomeOriginal;
    @Column(name = "arquivo_servidor")
    private String arquivoServidor;
    @Column(name = "tipo")
    private String tipo;

    public long getTamanho() {
        return tamanho;
    }

    public void setTamanho(long tamanho) {
        this.tamanho = tamanho;
    }

    public String getNomeOriginal() {
        return nomeOriginal;
    }

    public void setNomeOriginal(String nomeOriginal) {
        this.nomeOriginal = nomeOriginal;
    }

    public String getArquivoServidor() {
        return arquivoServidor;
    }

    public void setArquivoServidor(String arquivoServidor) {
        this.arquivoServidor = arquivoServidor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
