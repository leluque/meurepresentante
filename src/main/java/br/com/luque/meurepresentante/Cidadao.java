package br.com.luque.meurepresentante;

import java.util.Date;
import java.util.List;

/**
 * Esta classe implementa cidadaos.
 *
 * @author Leandro Luque
 */
public class Cidadao extends EntidadeDominio {

    private String cpf;
    private String nome;
    private String email;
    private Telefone telefone;
    private List<Politico> acompanhar;
    private TipoNotificacao tipoNotificacao;
    private Date dataNascimento;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public void addPolitico(Politico politico) {
        if (!this.acompanhar.contains(politico)) {
            this.acompanhar.add(politico);
        }
    }

    public boolean removePolitico(Politico politico) {
        return this.acompanhar.remove(politico);
    }

    public Politico removePoliticoAt(int i) {
        return this.acompanhar.remove(i);
    }

    public int countPoliticos() {
        return this.acompanhar.size();
    }

    public Politico getPoliticoAt(int i) {
        return this.acompanhar.get(i);
    }

    public List<Politico> getAcompanhar() {
        return acompanhar;
    }

    public void setAcompanhar(List<Politico> acompanhar) {
        this.acompanhar = acompanhar;
    }

    public TipoNotificacao getTipoNotificacao() {
        return tipoNotificacao;
    }

    public void setTipoNotificacao(TipoNotificacao tipoNotificacao) {
        this.tipoNotificacao = tipoNotificacao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
