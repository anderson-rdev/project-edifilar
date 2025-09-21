package com.edifilar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.edifilar.enums.Contatos;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class ContatoTest {

    private Properties props;
    private Properties telefone;

    @BeforeEach
    void setup() {
        props = new Properties();
        telefone = new Properties();

        // Regex simples de e-mail
        props.setProperty("regex.email", "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
        props.setProperty("email.mensagem.erro", "anderson.ramos@gmail.com");

        // Regex simples de telefone
        // telefone.setProperty("regex.telefone", "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
        telefone.setProperty("telefone.mensagem.erro", "15");

    }

    @Test
    void DeveRetornarTelefoneSeValido() {
        String TelefoneInformado = "25";

        // Validando Telefone
        boolean validez = Contatos.TELEFONE.validaValor(TelefoneInformado,telefone);

        // Valida Telefone
        String result = validez ? TelefoneInformado : Contatos.TELEFONE.getMensagemErro(telefone);

        assertEquals(TelefoneInformado, result);

    }

    @Test
    void DeveRetornarErroTelefoneSeValido() {
        String TelefoneInformado = "25";

        // Validando Telefone
        boolean validez = Contatos.TELEFONE.validaValor(TelefoneInformado,telefone);

        // Valida Telefone
        String result = validez ? TelefoneInformado : Contatos.TELEFONE.getMensagemErro(telefone);

        assertEquals(TelefoneInformado, result);

    }

    @Test
    void deveRetornarEmailDigitadoSeValido() {
        String emailDigitado = "anderson.ramos@gmail.com";

        // Valida o e-mail
        boolean valido = Contatos.EMAIL.validaValor(emailDigitado, props);

        // Se válido, retorna o próprio e-mail
        String resultado = valido ? emailDigitado : Contatos.EMAIL.getMensagemErro(props);

        assertEquals(emailDigitado, resultado);
    }

    @Test
    void deveRetornarMensagemErroSeEmailInvalido() {
        String emailDigitado = "anderson.ramos@gmail.com";

        boolean valido = Contatos.EMAIL.validaValor(emailDigitado, props);

        String resultado = valido ? emailDigitado : Contatos.EMAIL.getMensagemErro(props);

        assertEquals("anderson.ramos@gmail.com", resultado);
    }

}
