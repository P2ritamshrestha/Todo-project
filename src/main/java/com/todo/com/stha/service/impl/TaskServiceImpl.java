package com.todo.com.stha.service.impl;

/*

@author pritam shrestha
@version 1.0
@date 2024-10-22

*/


import com.todo.com.stha.entity.Task;
import com.todo.com.stha.repository.TaskRepository;
import com.todo.com.stha.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public void createTask(Task task) {
    taskRepository.save(task);
    }

    @Override
    public void updateTask(Task task) {
     Task task1 = taskRepository.findById(task.getId()).get();
     task1.setTitle(task.getTitle());
     taskRepository.save(task1);
    }

    @Override
    public void deleteTask(String id) {
    taskRepository.deleteById(id);
    }

    @Override
    public Task getTask(String id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteAllTask() {
    taskRepository.deleteAll();
    }
}
