package com.edifilar.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Documento específico para Filiação.
 */
public class Filiacao extends Documentos {

    private final String nomeMae;
    private final String nomePai;
    private final LocalDate dataRegistro;

    private Filiacao(Builder builder) {
        super(builder);
        this.nomeMae = builder.nomeMae;
        this.nomePai = builder.nomePai;
        this.dataRegistro = builder.dataRegistro;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    @Override
    public String toString() {
        return "Filiacao{" +
                "nomeMae='" + nomeMae + '\'' +
                ", nomePai='" + nomePai + '\'' +
                ", dataRegistro=" + dataRegistro +
                ", " + super.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Filiacao)) return false;
        if (!super.equals(o)) return false;
        Filiacao filiacao = (Filiacao) o;
        return Objects.equals(nomeMae, filiacao.nomeMae) &&
                Objects.equals(nomePai, filiacao.nomePai) &&
                Objects.equals(dataRegistro, filiacao.dataRegistro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nomeMae, nomePai, dataRegistro);
    }

    public static class Builder extends Documentos.Builder<Builder> {

        private String nomeMae;
        private String nomePai;
        private LocalDate dataRegistro;

        public Builder nomeMae(String nomeMae) {
            this.nomeMae = nomeMae;
            return this;
        }

        public Builder nomePai(String nomePai) {
            this.nomePai = nomePai;
            return this;
        }

        public Builder dataRegistro(LocalDate dataRegistro) {
            this.dataRegistro = dataRegistro;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Filiacao build() {
            // Validar obrigatoriedade dos campos
            if (super.numero == null || super.numero.isEmpty()) {
                throw new IllegalStateException("Número do documento é obrigatório");
            }
            if (nomeMae == null || nomeMae.isEmpty()) {
                throw new IllegalStateException("Nome da mãe é obrigatório");
            }
            if (dataRegistro == null) {
                throw new IllegalStateException("Data de registro é obrigatória");
            }
            return new Filiacao(this);
        }
    }
}
