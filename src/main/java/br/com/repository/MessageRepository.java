package br.com.repository;

import br.com.model.Message;
import br.com.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {
    @Query("SELECT m.id FROM Message m WHERE m.sender = :sender OR (m.receiver IS NULL OR m.receiver = :sender)")
    public List<Long> findMessagesIdByUser(Users sender);

    public List<Message> findMessagesBySenderOrReceiverIsNull(Users users);

    public List<Message> findMessagesBySenderOrReceiverIsNullAndSentDateAfter(Users sender, LocalDateTime sentDate);

}
