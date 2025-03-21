package org.tvf.security.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.tvf.security.entity.User;

public interface UserRepository extends JpaRepositoryImplementation<User, Long> {
    User findByUsername(String username);
}
