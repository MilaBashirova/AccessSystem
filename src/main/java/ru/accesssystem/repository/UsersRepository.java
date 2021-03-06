package ru.accesssystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.accesssystem.model.User;

import java.util.Optional;
@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
   Optional<User> findById(Long id);
    Optional<User> findByToken(String token);
}
