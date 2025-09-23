package com.edifilar.model;

import java.util.Objects;

/**
 * Superclasse abstrata para diferentes tipos de documentos.
 */
public abstract class Documentos {

    protected final String numero;
    private final String emissor;
    private final String paisEmissao;

    protected Documentos(Builder<?> builder) {
        this.numero = builder.numero;
        this.emissor = builder.emissor;
        this.paisEmissao = builder.paisEmissao;
    }

    public String getNumero() {
        return numero;
    }

    public String getEmissor() {
        return emissor;
    }

    public String getPaisEmissao() {
        return paisEmissao;
    }

    @Override
    public String toString() {
        return "Documento{" +
                "numero='" + numero + '\'' +
                ", emissor='" + emissor + '\'' +
                ", paisEmissao='" + paisEmissao + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Documentos)) return false;
        Documentos documento = (Documentos) o;
        return Objects.equals(numero, documento.numero) &&
                Objects.equals(emissor, documento.emissor) &&
                Objects.equals(paisEmissao, documento.paisEmissao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, emissor, paisEmissao);
    }

    /**
     * Builder genérico para Documento.
     * @param <T> tipo do builder concreto
     */
    public abstract static class Builder<T extends Builder<T>> {
        protected String numero;
        private String emissor;
        private String paisEmissao;

        public T numero(String numero) {
            this.numero = numero;
            return self();
        }

        public T emissor(String emissor) {
            this.emissor = emissor;
            return self();
        }

        public T paisEmissao(String paisEmissao) {
            this.paisEmissao = paisEmissao;
            return self();
        }

        protected abstract T self();

        public abstract Documentos build();
    }
}
