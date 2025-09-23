package com.edifilar.model;

/**
 * Classe base simples para entidades com identificador.
 */
public abstract class Dominio {

    private Long id;

    public Dominio() {
        // Construtor padrão
    }

    public Dominio(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
