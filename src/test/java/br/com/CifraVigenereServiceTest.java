package br.com;

import br.com.service.CryptographyService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CifraVigenereServiceTest {

    private String  CHAVE = "POIS";
    @Test
    public void test(){

        String texto = "ESTE é um teste de criptografia";

        CryptographyService cryptographyService = new CryptographyService();

        String textoCifrado = cryptographyService.cifraVigenereEncode(CHAVE, texto);
        String textoClaro = cryptographyService.cifraVigenereDecode(CHAVE, textoCifrado);

        System.out.println(textoCifrado);
        System.out.println(textoClaro);

        assertEquals(texto, textoClaro);
    }
}
