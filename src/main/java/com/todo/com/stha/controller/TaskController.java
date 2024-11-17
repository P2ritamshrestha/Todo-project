package com.todo.com.stha.controller;

/*

@author pritam shrestha
@version 1.0
@date 2024-10-22

*/

import com.todo.com.stha.entity.Task;
import com.todo.com.stha.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5174"})
@RestController
@RequestMapping("/todo-project")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping()
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        taskService.createTask(task);
        return ResponseEntity.ok("Task created Successfully");
    }

    @PutMapping()
    public ResponseEntity<?> updateTask(@RequestBody Task task) {
        taskService.updateTask(task);
        return ResponseEntity.ok("Task updated Successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTaskById(@PathVariable String id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task delete Successfully");
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable String id) {
        return ResponseEntity.ok(taskService.getTask(id));
    }

    @GetMapping()
    public ResponseEntity<?> getAllTask(@RequestParam("page") Integer page, @RequestParam("size")Integer size) {
        return ResponseEntity.ok(taskService.getTasks(page, size));
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteAllTask() {
        taskService.deleteAllTask();
        return ResponseEntity.ok("Task delete Successfully");
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> checkFavorite(@PathVariable String id) {
        taskService.checkFavorite(id);
        return ResponseEntity.ok("Task set favorite  Successfully");
    }

    @GetMapping("/favorite")
    public ResponseEntity<?> getAllFavoriteTask() {
        return ResponseEntity.ok(taskService.getFavoriteTasks());
    }

    @GetMapping("/complete")
    public ResponseEntity<?> getCompleteTasks() {
        return ResponseEntity.ok(taskService.getCompleteTasks());
    }

    @GetMapping("/pending")
    public ResponseEntity<?> getPendingTasks() {
        return ResponseEntity.ok(taskService.getPendingTasks());
    }

    @GetMapping("/progress")
    public ResponseEntity<?> getProgressTasks() {
        return ResponseEntity.ok(taskService.getProgressTasks());
    }


}
