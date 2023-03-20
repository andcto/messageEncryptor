package br.com.repository;

import br.com.model.Message;
import br.com.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {
    public List<Message> findAllByReceiverOrSenderOrderBySentDate(Users user1, Users user2);

}
