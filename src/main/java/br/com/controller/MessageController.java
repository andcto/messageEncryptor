package br.com.controller;

import br.com.dto.MessageDTO;
import br.com.model.CryptoType;
import br.com.model.Message;
import br.com.model.Users;
import br.com.repository.MessageRepository;
import br.com.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MessageController {
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    MessageService messageService;

    @PostMapping("/message/create")
    public String create(@RequestBody Message message){
        messageService.save(message);
        return "Ok";
    }

//    @GetMapping("/message/all")
//    public List<MessageDTO> listAllMessage(Users user){
//        List<MessageDTO> listMessagesDTO = new ArrayList<MessageDTO>();
//        List<Message> listMessages;
//
//        listMessages = messageRepository.findAllByReceiverOrSenderOrderBySentDate(user);
//
//        for(Message m : listMessages){
//            MessageDTO messageDTO = new MessageDTO();
//
//            messageDTO.setMessageContentDecrypted("");//passar pelo metodo de descriptografar
//            messageDTO.setMessageContentCrypted();
//            messageDTO.setCryptoType();
//            messageDTO.setSender();
//
//        }
//
//        return listMessagesDTO;
//    }
}
