package com.projectweb.project.repositories;

import com.projectweb.project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
