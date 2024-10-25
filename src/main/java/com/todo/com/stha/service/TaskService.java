package com.todo.com.stha.service;

/*

@author pritam shrestha
@version 1.0
@date 2024-10-22

*/


import com.todo.com.stha.entity.Task;

import java.util.List;

public interface TaskService {
    void createTask(Task task);
    void updateTask(Task task);
    void deleteTask(String id);
    Task getTask(String id);
    List<Task> getTasks();

    void deleteAllTask();

    void checkFavorite(String id);

    List<Task> getFavoriteTasks();
}
