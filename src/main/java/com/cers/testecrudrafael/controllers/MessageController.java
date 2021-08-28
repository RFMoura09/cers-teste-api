package com.cers.testecrudrafael.controllers;

import java.time.LocalDateTime;

import com.cers.testecrudrafael.models.Message;
import com.cers.testecrudrafael.repositories.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/messages")
@CrossOrigin
public class MessageController {

    @Autowired
    MessageRepository _messageRepository;

    @GetMapping
    public Iterable<Message> getMessages() {
        return _messageRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable int id) {
        return _messageRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Message addMessage(@RequestBody Message message) {
        Message newMessage = new Message();
        newMessage.setTitle(message.getTitle());
        newMessage.setDescription(message.getDescription());
        newMessage.setCreatedAt(LocalDateTime.now());

        return _messageRepository.save(newMessage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable int id, @RequestBody Message message) {
        return _messageRepository.findById(id).map(record -> {
            record.setTitle(message.getTitle());
            record.setDescription(message.getDescription());
            record.setUpdatedAt(LocalDateTime.now());
            Message updated = _messageRepository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        return _messageRepository.findById(id).map(record -> {
            _messageRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

}
