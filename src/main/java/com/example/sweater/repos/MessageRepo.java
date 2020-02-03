package com.example.sweater.repos;

import com.example.sweater.domians.Message;
import com.example.sweater.domians.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface MessageRepo extends CrudRepository<Message, Long> {



    List<Message> findByUsersId(Long id);

    Iterable<Message> findByTag(String filter);

    @Query("select tag, text from Message m where m.usersId = ?1")
    Collection<Message> getVoteIdByUser(Long id);
}