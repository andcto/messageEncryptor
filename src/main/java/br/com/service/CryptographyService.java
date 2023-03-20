package br.com.service;

import org.springframework.stereotype.Service;

@Service
public class CryptographyService {

    public String cifraVigenereEncode(String mensagem){
        return CifraVigenereService.encode(mensagem);
    }

    public String cifraVigenereDecode(String mensagem){
        return CifraVigenereService.decode(mensagem);
    }

}
