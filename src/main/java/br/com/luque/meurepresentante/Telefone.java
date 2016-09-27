package br.com.luque.meurepresentante;

/**
 * Esta classe implementa telefones.
 *
 * @author Leandro Luque
 */
public class Telefone extends EntidadeDominio {

    private String codigoArea;
    private String numero;
    private OperadoraCelular operadora;
    private String outraOperadora;
    private boolean eCelular;

    public String getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(String codigoArea) {
        this.codigoArea = codigoArea;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public OperadoraCelular getOperadora() {
        return operadora;
    }

    public void setOperadora(OperadoraCelular operadora) {
        this.operadora = operadora;
    }

    public String getOutraOperadora() {
        return outraOperadora;
    }

    public void setOutraOperadora(String outraOperadora) {
        this.outraOperadora = outraOperadora;
    }

    public boolean iseCelular() {
        return eCelular;
    }

    public void seteCelular(boolean eCelular) {
        this.eCelular = eCelular;
    }

}
