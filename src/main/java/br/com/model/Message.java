package br.com.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

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
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime sentDate;

}
