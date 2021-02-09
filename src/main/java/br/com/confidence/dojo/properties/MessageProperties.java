package br.com.confidence.dojo.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class MessageProperties {

    private String nomeArquivo;

    public MessageProperties(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public ArrayList<String> ordenaMessages() {

        Properties properties = bundleMessagesFromFile();

        ArrayList<String> chaves = new ArrayList<>(properties.stringPropertyNames());
        chaves.sort(String::compareTo);

        return chaves;
    }

    private Properties bundleMessagesFromFile() {
        InputStream arquivo = this.getClass().getClassLoader().getResourceAsStream(nomeArquivo);
        Properties bundleMessages = new Properties();
        try {
            bundleMessages.load(arquivo);
        } catch (IOException e) {
            //Assert.fail();
        }
        return bundleMessages;
    }

    public Set<String> raizDaChave(List<String> chaves) {

        Set<String> raizes = new HashSet<>();
        for (int i = 0; i < chaves.size(); i++) {

            if (chaves.get(i).contains(".")) {
                raizes.add(chaves.get(i).split("\\.")[0]);
            }  else {
                raizes.add(chaves.get(i));
            }

        }
        return raizes;
    }
}
