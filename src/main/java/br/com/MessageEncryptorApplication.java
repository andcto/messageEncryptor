package br.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@SpringBootApplication
public class MessageEncryptorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageEncryptorApplication.class, args);
	}

}
