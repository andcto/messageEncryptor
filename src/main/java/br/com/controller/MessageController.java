package br.com.controller;

import br.com.dto.EncryptDTO;
import br.com.dto.MessageDTO;
import br.com.model.Message;
import br.com.model.Users;
import br.com.repository.MessageRepository;
import br.com.repository.UserRepository;
import br.com.service.CryptographyService;
import br.com.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MessageController {
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    MessageService messageService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CryptographyService cryptographyService;

    @PostMapping("/message/create")
    public String create(@RequestBody Message message){
        messageService.save(message);
        return "Ok";
    }

    @PostMapping("/message/encrypt")
    public String encrypt(@RequestBody EncryptDTO encryptDTO){

        return cryptographyService.encrypt(encryptDTO.getMessage(), encryptDTO.getCryptoType());

    }

    @PostMapping("/message/decrypt")
    public String decrypt(@RequestBody EncryptDTO decryptDTO){

        return cryptographyService.decrypt(decryptDTO.getMessage(), decryptDTO.getCryptoType());

    }

    @GetMapping("/message/allid")
    public List<Long> listAllId(Long userId){

        Users user = userRepository.findById(userId).get();
        List<Long> messagesIds = messageRepository.findMessagesIdByUser(user);

        return messagesIds;

    }

    @GetMapping("/message/{messageId}")
    public ModelAndView getMessageFragment(@PathVariable Long messageId){

        Message message = messageRepository.findById(messageId).get();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", message);
        modelAndView.setViewName("fragments/message :: recivedMessage");
        return modelAndView;
    }

    @GetMapping("/message/empty")
    public ModelAndView getMessageFragmentEmpty(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fragments/message :: emptyMessages");
        return modelAndView;

    }

    @GetMapping("/message/all")
    public List<MessageDTO> listAllMessage(Long userId){
        List<MessageDTO> listMessagesDTO = new ArrayList<MessageDTO>();
        List<Message> listMessages;

        Users user = userRepository.findById(userId).get();

        listMessages = messageRepository.findMessagesBySenderOrReceiverIsNull(user);

        for(Message m : listMessages){
            MessageDTO messageDTO = new MessageDTO();

            //messageDTO.setMessageContentDecrypted("");//passar pelo metodo de descriptografar
            messageDTO.setMessageContentCrypted(m.getContent());
            messageDTO.setCryptoType(m.getCryptoType());
            if(m.getSender() != null){
                messageDTO.setSender(m.getSender().getName());
            }

            listMessagesDTO.add(messageDTO);

        }

        return listMessagesDTO;
    }
}
