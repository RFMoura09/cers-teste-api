package com.cers.testecrudrafael.repositories;

import com.cers.testecrudrafael.models.Message;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {

}
