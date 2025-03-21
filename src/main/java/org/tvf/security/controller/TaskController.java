package org.tvf.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.tvf.security.entity.Task;
import org.tvf.security.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody Task task, Authentication auth) {
        return taskService.createTask(task, auth.getName());
    }

    @GetMapping
    public List<Task> getUserTasks(Authentication auth) {
        return taskService.getTasksByUsername(auth.getName());
    }
}
