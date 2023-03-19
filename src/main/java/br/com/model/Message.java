package br.com.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Users sender;
    @OneToOne
    private Users receiver;
    private String content;
    private CryptoType cryptoType;

}
