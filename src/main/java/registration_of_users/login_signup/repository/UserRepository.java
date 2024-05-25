package registration_of_users.login_signup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import registration_of_users.login_signup.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    @Override
    List<User> findAll();
    User findByUsername(String username);

}
