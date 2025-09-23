package com.edifilar.model;

import com.edifilar.enums.TipoSanguineo;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma pessoa no sistema.
 */
public class Pessoa extends Dominio {

    private String nome;
    private List<Enderecos> enderecos;
    private TipoSanguineo tipoSanguineo;

    // Construtor padrão
    public Pessoa() {
        super();
        this.enderecos = new ArrayList<>();
    }

    // Construtor com id e nome
    public Pessoa(Long id, String nome) {
        super(id);
        this.nome = nome;
        this.enderecos = new ArrayList<>();
    }

    // Construtor completo
    public Pessoa(Long id, String nome, List<Enderecos> enderecos) {
        super(id);
        this.nome = nome;
        this.enderecos = enderecos != null ? enderecos : new ArrayList<>();
    }

    // Getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Enderecos> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Enderecos> enderecos) {
        this.enderecos = enderecos != null ? enderecos : new ArrayList<>();
    }

    public TipoSanguineo getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    // Método utilitário para adicionar endereço
    public void addEndereco(Enderecos endereco) {
        if (this.enderecos == null) {
            this.enderecos = new ArrayList<>();
        }
        this.enderecos.add(endereco);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + getId() +
                ", nome='" + nome + '\'' +
                ", enderecos=" + (enderecos != null ? enderecos.size() : 0) + " endereços" +
                ", tipoSanguineo=" + tipoSanguineo +
                '}';
    }
}
