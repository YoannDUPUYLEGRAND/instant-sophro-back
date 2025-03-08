package yoanndlg.java_instant_sophro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yoanndlg.java_instant_sophro.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}