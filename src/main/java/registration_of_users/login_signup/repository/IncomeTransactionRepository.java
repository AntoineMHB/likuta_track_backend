package registration_of_users.login_signup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import registration_of_users.login_signup.model.IncomeTransaction;

public interface IncomeTransactionRepository extends JpaRepository<IncomeTransaction, Long> {
}
