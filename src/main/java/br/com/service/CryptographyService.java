package br.com.service;

import br.com.model.CryptoType;
import org.springframework.stereotype.Service;

@Service
public class CryptographyService {

    public String encrypt(String mensagem, CryptoType cryptoType){
        if(cryptoType.equals(CryptoType.VIGENERE)){
            return CifraVigenereService.encode(mensagem);
        } else if (cryptoType.equals(CryptoType.VERNAN)) {
            return mensagem;
        } else if (cryptoType.equals(CryptoType.AES256)) {
            return mensagem;
        } else {
            return null;
        }
    }

    public String cifraVigenereEncode(String mensagem){
        return CifraVigenereService.encode(mensagem);
    }

    public String cifraVigenereDecode(String mensagem){
        return CifraVigenereService.decode(mensagem);
    }

    public String decrypt(String mensagem, CryptoType cryptoType) {
        if(cryptoType.equals(CryptoType.VIGENERE)){
            return CifraVigenereService.decode(mensagem);
        } else if (cryptoType.equals(CryptoType.VERNAN)) {
            return mensagem;
        } else if (cryptoType.equals(CryptoType.AES256)) {
            return mensagem;
        } else {
            return null;
        }
    }
}
