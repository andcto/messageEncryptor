package br.com.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private User sender;
    @OneToMany
    private List<User> receiver;
    private String content;
    private CryptoType cryptoType;

}
