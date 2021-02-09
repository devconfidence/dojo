package br.com.confidence.dojo.properties;

import org.junit.jupiter.api.Test;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;


class MessagePropertiesTest {

    @Test
    public void testaOrdenacao() {
        ArrayList<String> chavesOrdenadas =
                new MessageProperties("messagesTest.properties").ordenaMessages();
        assertThat(chavesOrdenadas, contains("b", "f", "v", "bababa"));
    }

    @Test
    public void testaExtracaoRaiz() {

        MessageProperties messages = new MessageProperties("messagesRaizesTest.properties");
        ArrayList<String> chavesOrdenadas = messages.ordenaMessages();

        Set<String> resultado = messages.raizDaChave(chavesOrdenadas);
        assertThat(resultado, contains("a", "b", "v", "w"));
    }

}