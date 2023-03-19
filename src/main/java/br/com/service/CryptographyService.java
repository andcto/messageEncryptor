package br.com.service;

import org.springframework.stereotype.Service;

@Service
public class CryptographyService {

    public String cifraVigenereEncode(String chave, String menssagem){
        return CifraVigenereService.encode(chave, menssagem);
    }

    public String cifraVigenereDecode(String chave, String menssagem){
        return CifraVigenereService.decode(chave, menssagem);
    }

}
