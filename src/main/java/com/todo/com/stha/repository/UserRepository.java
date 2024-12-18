package com.todo.com.stha.repository;

import com.todo.com.stha.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author pritam shrestha
 * @version v1.0
 * @date 2024-11-17
 **/

@Repository
public interface UserRepository extends MongoRepository<Users,String> {
    Optional<Users> findByUsername(String username);
}
