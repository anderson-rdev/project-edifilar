package com.edifilar.enums;

import java.util.Properties;
import java.util.regex.Pattern;

public enum Contatos {

   EMAIL("E-mail", "regex.email","email.mensagem.erro"),
   TELEFONE("Telefone", "regex.telefone", "telefone.mensagem.erro"),
   CELULAR("Celular", "regex.celular", "celular.mensagem.erro"),
   WHATSAPP("WhatsApp", "regex.whatsapp", "whatsapp.mensagem.erro"),
   LINKEDIN("LinkedIn", "regex.linkedin", "linkedin.mensagem.erro"),
   TELEGRAM("Telegram", "regex.telegram", "telegram.mensagem.erro"),
   SITE("Site", "regex.site", "site.mensagem.erro"),
   OUTRO("Outro", null, null);

    private final String descricao;
    private final String regexProperty;
    private final String mensagemErroProperty;

    // Construtor
    Contatos(String descricao, String regexProperty, String mensagemErroProperty) {
        this.descricao = descricao;
        this.regexProperty = regexProperty;
        this.mensagemErroProperty = mensagemErroProperty;
    }

    // GET
    public String getDescricao() {
        return descricao;
    }

    public String getMensagemErroProperty() {
        return mensagemErroProperty;
    }

    public String getRegexProperty() {
        return regexProperty;
    }

    // Método que recebe as propriedades carregadas externamente
     public boolean validaValor(String valor, Properties prop) {
        if (this == OUTRO || regexProperty == null) {
            return true;
        }

        String regex = prop.getProperty(regexProperty);
        if(regexProperty == null || regexProperty.trim().isEmpty()) {
            return true;
        }

        return Pattern.matches(regexProperty, valor);
     }

     // Metodo para obter mensagem de erro
    public String getMensagemErro(Properties prop) {
        if (mensagemErroProperty == null) {
            return "Valor inválido";
        }
        return prop.getProperty(mensagemErroProperty, "Valor inválido");
    }


}
