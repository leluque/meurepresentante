package br.com.luque.meurepresentante;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Esta classe implementa politicos (prefeitos, vereadores, deputados etc.).
 *
 * @author Leandro Luque
 */
@Entity
@Table(name = "politico")
public class Politico extends EntidadeDominio {

    @Column(name = "nome")
    private String nome;
    @OneToOne
    @JoinColumn(name = "foto_id")
    private Imagem foto;
    @OneToOne
    @JoinColumn(name = "partido_id")
    private Partido partidoAtual;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "email")
    private String email;
    @ManyToMany
    @JoinTable(name = "projetos_do_politico", joinColumns = {
        @JoinColumn(name = "politico_id")}, inverseJoinColumns = {
        @JoinColumn(name = "projeto_id")})
    private List<Projeto> projetos;
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Column(name = "formacao")
    private String formacao;
    @Column(name = "estado_civil")
    private String estadoCivil;
    @Column(name = "funcao_atual")
    private Funcao funcaoAtual;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Imagem getFoto() {
        return foto;
    }

    public void setFoto(Imagem foto) {
        this.foto = foto;
    }

    public Partido getPartidoAtual() {
        return partidoAtual;
    }

    public void setPartidoAtual(Partido partidoAtual) {
        this.partidoAtual = partidoAtual;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addProjeto(Projeto projeto) {
        if (!this.projetos.contains(projeto)) {
            this.projetos.add(projeto);
        }
    }

    public boolean removeProjeto(Projeto projeto) {
        return this.projetos.remove(projeto);
    }

    public Projeto removeProjetoAt(int i) {
        return this.projetos.remove(i);
    }

    public int countProjetos() {
        return this.projetos.size();
    }

    public Projeto getProjetoAt(int i) {
        return this.projetos.get(i);
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Funcao getFuncaoAtual() {
        return funcaoAtual;
    }

    public void setFuncaoAtual(Funcao funcaoAtual) {
        this.funcaoAtual = funcaoAtual;
    }

}
