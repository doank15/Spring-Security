package org.tvf.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tvf.security.entity.Task;
import org.tvf.security.entity.User;
import org.tvf.security.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserService userService;

    public Task createTask(Task task, String username) {
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        task.setUser(user);

        return taskRepository.save(task);
    }

    public List<Task> getTasksByUsername(String username) {
        List<Task> tasks = taskRepository.findByUserUsername(username);
        if (tasks.isEmpty()) {
            throw new RuntimeException("No tasks found: " + username);
        }

        return tasks;
    }
}
