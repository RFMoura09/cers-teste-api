package com.cers.testecrudrafael.repositories;

import java.util.List;

import com.cers.testecrudrafael.models.Message;
import com.cers.testecrudrafael.utils.Status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findByStatusOrderByCreatedAtDesc(Status status);
}
