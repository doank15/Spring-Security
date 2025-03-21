package org.tvf.security.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.tvf.security.entity.Task;

import java.util.List;

public interface TaskRepository extends JpaRepositoryImplementation<Task, Long> {
    List<Task> findByUserUsername(String username);
}
