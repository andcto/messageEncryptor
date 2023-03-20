package br.com.service;

import br.com.model.CryptoType;
import br.com.model.Message;
import br.com.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    CryptographyService cryptographyService;

//    public MessageDTO toMessageDTO(Message message){
//
//    }

    public void save(Message message) {
        if(message.getCryptoType()== CryptoType.VIGENERE){
            message.setContent(cryptographyService.cifraVigenereEncode(message.getContent()));

            messageRepository.save(message);
        }
    }
}
