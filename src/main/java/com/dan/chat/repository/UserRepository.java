package com.dan.chat.repository;

import com.dan.chat.model.Status;
import com.dan.chat.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByStatus(Status status);
}
