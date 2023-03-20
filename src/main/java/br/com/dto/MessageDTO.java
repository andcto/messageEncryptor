package br.com.dto;

import br.com.model.CryptoType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageDTO {
    private String sender;
    private String messageContentCrypted;
    private String messageContentDecrypted;
    private CryptoType cryptoType;
}
