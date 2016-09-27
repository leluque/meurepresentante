package br.com.luque.meurepresentante;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Esta classe implementa imagens.
 *
 * @author Leandro Luque
 */
@Entity
@Table(name = "imagem")
public class Imagem extends Arquivo {

    @Column(name = "largura")
    private int largura;
    @Column(name = "altura")
    private int altura;
    @Column(name = "tipo")
    private String tipo;

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

}
