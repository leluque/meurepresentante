package br.com.luque.meurepresentante.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * Esta classe implementa telefones.
 *
 * @author Leandro Luque
 */
@Entity
@Table(name = "telefone")
public class Telefone extends EntidadeDominio {

    @Column(name = "codigo_area")
    private String codigoArea;
    @Column(name = "numero")
    private String numero;
    @Enumerated(EnumType.STRING)
    private OperadoraCelular operadora;
    @Column(name = "outra_operadora")
    private String outraOperadora;
    @Column(name = "e_celular")
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
