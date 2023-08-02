package com.springbootdocker.docker.repositories;

import com.springbootdocker.docker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
