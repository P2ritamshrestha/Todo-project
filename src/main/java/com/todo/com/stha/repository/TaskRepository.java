package com.todo.com.stha.repository;

/*

@author pritam shrestha
@version 1.0
@date 2024-10-22

*/

import com.todo.com.stha.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {

    @Query(value = "{ 'favorite': true }")
    List<Task> findAllFavoriteTasks();

    @Query(value = "{'status' : 'PENDING'}")
    List<Task> getPendingTasks();

    @Query(value = "{'status' : 'COMPLETED'}")
    List<Task> getCompleteTasks();

    @Query(value = "{'status' : 'IN_PROGRESS'}")
    List<Task> getProgressTasks();


    @Query(value = "{}")
    Page<Task> findAllWithPagination(Pageable pageable);
}

