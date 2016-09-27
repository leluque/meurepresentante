package br.com.luque.meurepresentante;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Esta classe representa projetos propostos na casa legislativa municipal.
 *
 * @author Leandro Luque
 */
@Entity
@Table(name = "projeto")
public class Projeto extends EntidadeDominio {

    @Column(name = "assunto")
    private String assunto;
    @ManyToMany(mappedBy = "projetos")
    private List<Politico> autores;
    @Column(name = "numero")
    private String numero;
    @Column(name = "ano")
    private int ano;
    @Column(name = "lei")
    private String lei;
    @Enumerated(EnumType.STRING)
    private StatusProjeto status;
    @Column(name = "link_camara")
    private String linkCamara;
    @Enumerated(EnumType.STRING)
    private TipoProjeto tipoProjeto;

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public void addPolitico(Politico autor) {
        if (!this.autores.contains(autor)) {
            this.autores.add(autor);
        }
    }

    public boolean removePolitico(Politico autor) {
        return this.autores.remove(autor);
    }

    public Politico removePoliticoAt(int i) {
        return this.autores.remove(i);
    }

    public int countPoliticos() {
        return this.autores.size();
    }

    public Politico getPoliticoAt(int i) {
        return this.autores.get(i);
    }

    public List<Politico> getPoliticoes() {
        return autores;
    }

    public void setPoliticoes(List<Politico> autores) {
        this.autores = autores;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getLei() {
        return lei;
    }

    public void setLei(String lei) {
        this.lei = lei;
    }

    public StatusProjeto getStatus() {
        return status;
    }

    public void setStatus(StatusProjeto status) {
        this.status = status;
    }

    public String getLinkCamara() {
        return linkCamara;
    }

    public void setLinkCamara(String linkCamara) {
        this.linkCamara = linkCamara;
    }

    public List<Politico> getAutores() {
        return autores;
    }

    public void setAutores(List<Politico> autores) {
        this.autores = autores;
    }

    public TipoProjeto getTipoProjeto() {
        return tipoProjeto;
    }

    public void setTipoProjeto(TipoProjeto tipoProjeto) {
        this.tipoProjeto = tipoProjeto;
    }

}
