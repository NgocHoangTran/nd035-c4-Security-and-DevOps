package com.fpt.nd035c4SecurityandDevOps.model.persistence.repositories;

import com.fpt.nd035c4SecurityandDevOps.model.persistence.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
