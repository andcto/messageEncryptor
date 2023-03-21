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
public class EncryptDTO {
    private String message;
    private CryptoType cryptoType;
}
