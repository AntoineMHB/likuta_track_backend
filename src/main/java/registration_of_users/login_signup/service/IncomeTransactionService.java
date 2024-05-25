package registration_of_users.login_signup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import registration_of_users.login_signup.model.IncomeTransaction;
import registration_of_users.login_signup.repository.IncomeTransactionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeTransactionService {

    @Autowired
    private IncomeTransactionRepository incomeTransactionRepository;

    public List<IncomeTransaction> findAll() {
        return incomeTransactionRepository.findAll();
    }

    public IncomeTransaction findById(Long id) {
        Optional<IncomeTransaction> incomeTransaction = incomeTransactionRepository.findById(id);
        return incomeTransaction.orElse(null);
    }

    public IncomeTransaction save(IncomeTransaction incomeTransaction) {
        return incomeTransactionRepository.save(incomeTransaction);
    }

    public void deleteById(Long id) {
        incomeTransactionRepository.deleteById(id);
    }
}
