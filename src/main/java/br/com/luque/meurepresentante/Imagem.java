package br.com.luque.meurepresentante;

/**
 * Esta classe implementa imagens.
 *
 * @author Leandro Luque
 */
public class Imagem extends Arquivo {

    private int largura;
    private int altura;
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
