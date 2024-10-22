package com.todo.com.stha.repository;

/*

@author pritam shrestha
@version 1.0
@date 2024-10-22

*/

import com.todo.com.stha.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
}
