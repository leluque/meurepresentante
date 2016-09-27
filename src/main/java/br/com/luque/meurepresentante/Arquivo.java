package br.com.luque.meurepresentante;

/**
 * Esta classe implementa arquivos.
 *
 * @author Leandro Luque
 */
public class Arquivo extends EntidadeDominio {

    private long tamanho;
    private String nomeOriginal;
    private String arquivoServidor;
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
