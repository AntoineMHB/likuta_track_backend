package registration_of_users.login_signup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import registration_of_users.login_signup.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
